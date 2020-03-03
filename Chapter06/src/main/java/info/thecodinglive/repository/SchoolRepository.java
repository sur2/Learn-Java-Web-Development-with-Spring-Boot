package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import info.thecodinglive.model.School;

public interface SchoolRepository extends JpaRepository<School, Long>{

}
