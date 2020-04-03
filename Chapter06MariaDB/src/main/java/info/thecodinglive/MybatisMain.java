package info.thecodinglive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

import info.thecodinglive.model.UserVO;
import info.thecodinglive.repository.UserRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class MybatisMain implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(MybatisMain.class, args);
	}

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		UserVO userVO = new UserVO("test4", "mak", "1234");
		userRepository.addUserInfo(userVO);
		System.out.println("==입력 후==");
		System.out.println(userRepository.getUserInfoAll().toString());
		System.out.println("==like 이름 검색==");
		System.out.println(userRepository.findByUserNameLike("k").toString());
		System.out.println("");
		System.out.println("단건 검색");
//		UserVO one = userRepository.findByUserName("mak");
//		System.out.println(one.getId() + " :: " + one.getUserName() + " :: " + one.getPassWord());
	}
}
