package info.thecodinglive.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import info.thecodinglive.model.UserVO;

@Repository
public class UserRepository {
	private static final String MAPPER_NAME_SPACE="sample.mapper.userMapper.";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public List getUserInfoAll() {
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "selectUserInfoAll");
	}
	
	public int addUserInfo(UserVO userVO) {
		int result = sqlSessionTemplate.insert(MAPPER_NAME_SPACE + "addUserInfo", userVO);
		System.out.println("INSERT RESULT:: "+result);
		return result;
	}
	
	public List findByUserName(String userName) {
		// KEY, VALUE
		Map<String, Object> params = new HashMap();
		params.put("userName", userName);
		return sqlSessionTemplate.selectList(MAPPER_NAME_SPACE + "findByUserNameLike", params);
	}
}
