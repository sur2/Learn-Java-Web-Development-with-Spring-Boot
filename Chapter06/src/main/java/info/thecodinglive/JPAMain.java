package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import info.thecodinglive.model.UserEntity;
import info.thecodinglive.model.UserRole;
import info.thecodinglive.repository.UserRepository;

@SpringBootApplication
public class JPAMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JPAMain.class, args);
		// SpringApplication의 run 메서드의 반환값으로 context를 얻어서 UserRepository의 Bean을 얻는다. 
		UserRepository userRepository = context.getBean(UserRepository.class);
		// save 메서드로 게이터를 저장, insert 문의 역활
		userRepository.save(new UserEntity("윤사장", 60, UserRole.ADMIN));
		UserEntity user = userRepository.findByUesrName("윤사장");
		System.out.println("SELECT:: 나이: " + user.getAge() + ", 이름: " + user.getUesrName() + ", 생성일: " + user.getCreatedAt());
	}

}
