package info.thecodinglive.querydsl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.querydsl.UserRepositoryCustom;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, UserRepositoryCustom{
	UserEntity findByUserName(@Param("userName") String userName);
}
