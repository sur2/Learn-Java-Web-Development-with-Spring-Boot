package info.thecodinglive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

	@Id
	@Column(name = "STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String userName;
	private String grade;
	/**
	 * 학생이 N, 학교가 1인 N:1관계를 가진다. '@ManyToOne'어노테이션은 N:1관계를 나타낸다. 반대로 '@OneToMany',
	 * '@OneToOne'이 있다. '@ManyToOne'의 기본값은 즉시 로딩(EAGER)이며 이 외에 값을 지정할 수 있다. 지연
	 * 로딩(LAZY)를 하는 이유는 즉시 로딩을 하면 연결된 Entity 정보까지 한 번에 가져오므로 성능에 부담을 주기 때문이다.
	 * '@JoinColumn'어노테이션으로 관계를 가지는 Column을 지정한다.
	 */
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SCHOOL_ID")
	private School school;

	public Student(String userName) {
		super();
		this.userName = userName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

}
