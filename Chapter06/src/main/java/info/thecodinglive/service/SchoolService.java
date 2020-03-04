package info.thecodinglive.service;

import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import info.thecodinglive.model.School;
import info.thecodinglive.model.Student;
import info.thecodinglive.repository.SchoolRepository;
import info.thecodinglive.repository.StudentRepository;

@Service
public class SchoolService {
	/**
	 * '@Autowired'어노테이션으로 해당타입의 Bean을 의존성 주입
	 */
	@Autowired
	private SchoolRepository schoolRepository;
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * '@Transactional'어노테이션을 사용하여 두 개 이상의 Entity들을 제어할 때 메서드가 하나의 트랜잭션 안에서 실행되도록
	 * 한다. 지연 로딩(LASY) 시 다른 Entity 정보를 함께 조회할 경우 proxy를 이용한 지연 로딩 처리 시 에러가 발생 하기 때문에
	 * 하나의 트랜잭션에서 실행한다.
	 */
	@Transactional
	public void findStudentInfo() {
		School school = new School("매력고");
		schoolRepository.save(school);

		Student stu1 = new Student("나라");
		Student stu2 = new Student("민하");
		Student stu3 = new Student("나나");

		stu1.setSchool(school);
		stu2.setSchool(school);
		stu3.setSchool(school);

		studentRepository.save(stu1);
		studentRepository.save(stu2);
		studentRepository.save(stu3);

		List<Student> students = studentRepository.findAll();

		for (Student student : students) {
			System.out.println(student.getUserName() + ", " + student.getSchool().getName());
		}
	}
	
	@Transactional
	public void findSchoolInfo() {
		School sc1 = new School("예체능고");
		sc1.registerStudent(new Student("홍길동"));
		sc1.registerStudent(new Student("유재석"));

		School sc2 = new School("매력고");
		sc2.registerStudent(new Student("나라"));
		sc2.registerStudent(new Student("민하"));

		schoolRepository.saveAll(new HashSet<School>() {{
			add(sc1);
			add(sc2);
		}});
		
		List<School> schools = schoolRepository.findAll();
		
		for (School school : schools) {
			System.out.println(school.toString());
		}
	}
}
