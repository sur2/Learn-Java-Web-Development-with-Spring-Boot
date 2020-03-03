package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.thecodinglive.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
	
}
