package info.thecodinglive;

import org.springframework.context.support.GenericXmlApplicationContext;

import basic.WorkService;

public class XmlSpringApp {

	public static void main(String[] args) {
		// XML 설정을 이용하기 위한 객체
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				// Resources 폴더에 있는 파일은 classpath:로 표기할 수 있다.
				"classpath:BeanContext.xml");
		WorkService yourWorkService = (WorkService) context.getBean("yourWorkService", "WorkService.class");
		yourWorkService.asWork();
		
		WorkService bossWorkService = (WorkService) context.getBean("myWorkService");
		bossWorkService.asWork();
		context.close();
	}


}
