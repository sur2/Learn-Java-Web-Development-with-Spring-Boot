package info.thecodinglive;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;

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
		System.out.println(userRepository.getUserInfoAll().toString());
	}
}
