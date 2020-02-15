package info.thecodinglive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * SpringBootApplication Annotation이  ComponentScan, Configuration, EnableAutoConfiguration Annotation을 대체
 * EnableAutoConfiguration Annotation은 xxxConfiguration 클래스들을 읽을 수 있도록 한다.
 */
//@SpringBootApplication
@ComponentScan(basePackages = "info.thecodinglive.controller")
@Configuration
@EnableAutoConfiguration
public class Chapter04Application {

	public static void main(String[] args) {
		SpringApplication.run(Chapter04Application.class, args);
	}
}
