package info.thecodinglive;

import org.springframework.context.support.GenericXmlApplicationContext;

import basic.WorkService;

public class XmlSpringApp {

	public static void main(String[] args) {
		// XML 설정을 이용하기 위한 객체
		GenericXmlApplicationContext context = new GenericXmlApplicationContext(
				// Java Resources
				"classpath:applicationContext.xml");
	}

	WorkService yourWorkService;

}
