package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.querydsl.UserRepository;

@SpringBootApplication
public class MinMaxApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MinMaxApplication.class, args);
		
		UserRepository userRepository = context.getBean(UserRepository.class);
		
		UserEntity u0 = new UserEntity("나라", 26, UserRole.USER);
		UserEntity u1 = new UserEntity("민하", 26, UserRole.USER);
		UserEntity u2 = new UserEntity("경리", 28, UserRole.USER);
		UserEntity u3 = new UserEntity("서지혜", 38, UserRole.USER);
		
		userRepository.save(u0);
		userRepository.save(u1);
		userRepository.save(u2);
		userRepository.save(u3);
		
		System.out.println("MAX AGE:: " + userRepository.maxAge());
		System.out.println("MIN AGE:: " + userRepository.minAge());
	}
}
