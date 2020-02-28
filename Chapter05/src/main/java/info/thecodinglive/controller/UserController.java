package info.thecodinglive.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import info.thecodinglive.model.User;

@RestController
public class UserController {
	private static List<User> userList = new ArrayList<User>(); 
	// {} 인스턴스 초기화블록 : 클래스의 생성자 호출 이전에 인스턴스가 생성될 때마다 실행
	{
		userList.add(new User(1, "jpub01", "user01@test.com", "remine", new Date()));
		userList.add(new User(2, "jpub02", "user02@test.com", "restart", new Date()));
		userList.add(new User(3, "jpub03", "user03@test.com", "nine", new Date()));
		userList.add(new User(4, "jpub04", "user04@test.com", "namu", new Date()));
	}
	// static{} 클래스 초기화 블록 : 클래스가 처음 로딩 될 때 한 번 실행
	static {
		userList.add(new User(0, "jpub00", "user00@test.com", "zero", new Date()));
	}
	
	@RequestMapping(value = "/user/{userNo}")
	public ResponseEntity<User> getUesrInfo(@PathVariable(name = "userNo") int userNo) {
		User user = userList.get(userNo);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/user") 
	public ResponseEntity<List<User>> getUserList() {
		HashMap<String, Object> resultList = new HashMap<String, Object>();
		resultList.put("result", userList);
		return new ResponseEntity(resultList, HttpStatus.OK);
	}
}
