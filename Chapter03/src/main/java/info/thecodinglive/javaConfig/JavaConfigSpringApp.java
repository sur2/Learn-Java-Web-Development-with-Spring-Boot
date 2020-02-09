package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import basic.WorkService;

public class JavaConfigSpringApp {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanConfig.class);
		context.refresh();
		// 메서드 이름을 빈 이름으로 조회해서 사용할 수 있다.
		WorkService yourWorkService = (WorkService) context.getBean("yourWorkService");
		yourWorkService.asWork();
		
		WorkService myWorkService = (WorkService) context.getBean("myWorkService");
		myWorkService.asWork();
		
		Company company = (Company) context.getBean("company");
		company.getName();
		
		context.close();
	}

}
