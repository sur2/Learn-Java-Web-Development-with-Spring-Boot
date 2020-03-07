package info.thecodinglive.querydsl;

import java.util.List;

import info.thecodinglive.model.UserEntity;

public interface UserRepositoryCustom {
	List<UserEntity> findAllLike(String keyword);
	
	int maxAge();
	
	int minAge();
}
