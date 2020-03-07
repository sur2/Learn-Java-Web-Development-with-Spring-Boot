package info.thecodinglive;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.querydsl.UserRepository;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class QuerydslApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuerydslApplication.class, args);

		UserRepository userRepository = context.getBean(UserRepository.class);

		userRepository.save(new UserEntity("홍길동", 33, UserRole.USER));
		userRepository.save(new UserEntity("홍연희", 33, UserRole.USER));
		userRepository.save(new UserEntity("이홍련", 33, UserRole.USER));
		userRepository.save(new UserEntity("차미홍", 33, UserRole.USER));
		userRepository.save(new UserEntity("철수", 24, UserRole.USER));
		userRepository.save(new UserEntity("영희", 7, UserRole.USER));
		userRepository.save(new UserEntity("척춘경", 41, UserRole.ADMIN));
		userRepository.save(new UserEntity("데니스", 80, UserRole.ADMIN));
		userRepository.save(new UserEntity("비숍", 10, UserRole.ADMIN));

		List<UserEntity> resultList = userRepository.findAllLike("%홍%");
		
		System.out.println("이름에 홍을 포함한 인원 수 : " + resultList.size());
		
		for (UserEntity userEntity : resultList) {
			System.out.println(userEntity.getUserName());
		}
	}

}
