package info.thecodinglive.querydsl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import com.querydsl.jpa.JPQLQuery;

import info.thecodinglive.model.QUserEntity;
import info.thecodinglive.model.UserEntity;

@Transactional
public class UserRepositoryImpl extends QuerydslRepositorySupport implements UserRepositoryCustom{

	public UserRepositoryImpl() {
		super(UserEntity.class);
	}
	
	@Override
	public List<UserEntity> findAllLike(String keyword) {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		// JPQLQuery : 쿼리 전송을 하는 객체이다. QueryDslRepositorySupport에 from 메서드를 사용하여 생성(from 'table') 
		JPQLQuery<UserEntity> query = from(qUserEntity);
		// 쿼리의 where 절과 like를 사용하여 검색 구현  		
		List<UserEntity> resultlist = query.where(qUserEntity.userName.like(keyword)).fetch();
		return resultlist;
	}
	
	/**
	 * 여기서 '@Autowired'의 역할은 entityManager의 의존성 주입 
	 */
	@Override
	@Autowired
	public void setEntityManager(EntityManager entityManager) {
		super.setEntityManager(entityManager);
	}

	@Override
	public int maxAge() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		return from(qUserEntity).select(qUserEntity.age.max()).fetchOne();
	}

	@Override
	public int minAge() {
		QUserEntity qUserEntity = QUserEntity.userEntity;
		JPQLQuery<UserEntity> jpqlQuery = from(qUserEntity);
		return jpqlQuery.select(qUserEntity.age.min()).fetchOne();
	}
}
