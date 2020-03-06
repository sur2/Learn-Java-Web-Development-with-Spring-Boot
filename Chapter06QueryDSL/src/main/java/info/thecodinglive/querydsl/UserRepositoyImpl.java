package info.thecodinglive.querydsl;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import info.thecodinglive.model.UserEntity;

public class UserRepositoyImpl extends QuerydslRepositorySupport implements UserRepositoryCustom{
	
	public UserRepositoyImpl() {
		super(UserEntity.class);
	}
	
	@Override
	public List findAllLike(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}
}
