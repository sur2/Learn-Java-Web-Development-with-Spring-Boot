package info.thecodinglive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import info.thecodinglive.model.UserEntity;

/**
 * Repository 인터페이스는 JpaRepository 인터페이스를 상속받아 Entity 조작에 필요한 쿼리를 메서드화해서 사용할 수 있는 역활 
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	// Param은 UserEntity의 멤버변수인 uesrName으로 매핑한다.
	UserEntity findByUesrName(@Param("userName")String uesrName);
	
}
