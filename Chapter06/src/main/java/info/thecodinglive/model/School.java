package info.thecodinglive.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class School {

	@Id
	@Column(name = "SCHOOL_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String address;
	private String telnumber;
	
	/**
	 * '@OneToMany'어노테이션의 mappedBy은 연관 관계에서 다수인 쪽이다.
	 * N : 1
	 * 여기서 school은 Student.school을 뜻하기 때문에 학생 수 만큼의 학교가 다수이다.
	 */
	@OneToMany(mappedBy = "school")
	private Set<Student> students;
	
	public void registerStudent(Student s) {
		if (students == null) {
			students = new HashSet<Student>();
		}
		students.add(s);
	}
	
	public School() {
		super();
		// TODO Auto-generated constructor stub
	}



	public School(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getTelnumber() {
		return telnumber;
	}

	public void setTelnumber(String telnumber) {
		this.telnumber = telnumber;
	}

	@Override
	public String toString() {
		return "School [id=" + id + ", name=" + name + ", address=" + address + ", telnumber=" + telnumber
				+ ", students=" + students + "]";
	}
}
