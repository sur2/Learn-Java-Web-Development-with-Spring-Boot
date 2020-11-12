package info.thecodinglive;

import java.lang.reflect.Method;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import info.thecodinglive.config.MyAnnotation;
import info.thecodinglive.impostSelect.MainConfig;
import info.thecodinglive.impostSelect.UseMyBean;
import info.thecodinglive.service.MyService;

@SpringBootApplication
public class Chapter07Application {

	public static void main(String[] args) throws SecurityException, ClassNotFoundException {
		SpringApplication.run(Chapter07Application.class, args);
		
		// MyService 클래스에 MyAnnotation이 존재하는지 확인!
		Method[] methods = Class.forName(MyService.class.getName()).getMethods();
		
		for (int i = 0; i < methods.length; i++) {
			if (methods[i].isAnnotationPresent(MyAnnotation.class)) {
				MyAnnotation an = methods[i].getAnnotation(MyAnnotation.class);
				
				System.out.println("my annotation str value: " + an.strValue());
				System.out.println("my annotation int value: " + an.intValue());
			}
		}
		
		// ImportSelector Test
		ApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
		UseMyBean bean = context.getBean(UseMyBean.class);
		bean.printMsg();
		
	}

}
