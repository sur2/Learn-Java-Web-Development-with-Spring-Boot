package info.thecodinglive;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.ApplicationContext;
//import org.springframework.context.ConfigurableApplicationContext;

/**
 * 스프링 부트가 로드하는 빈들을 확인
 */ 
@SpringBootApplication
public class SpringLoadBean {

	public static void main(String[] args) {
		// ApplicationContext는 ConfigurableApplication을 return 즉 ConfigurableApplicationContext로 선언해도 무방함
		ApplicationContext ctx = SpringApplication.run(SpringLoadBean.class, args);
		// getBeanDefinitionNames 메서드를 사용해서 Context load 된 Bean name을 출력
		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames) {
			System.out.println(beanName);
		}
	}
}
