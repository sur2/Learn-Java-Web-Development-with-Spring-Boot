package basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Boss implements WorkManager {
	/**
	 * Java Config 기반을 설정할 때는 initMethod와 destroyMethod 보다
	 * '@PostConstruct'와 '@PreDestroy'를 많이 사용한다. 
	 */	
	@PostConstruct
	public void onCreated() {
		System.out.println("boss 생성");
	}

	@Override
	public String doIt() {
		return "do boss";
	}
	@PreDestroy
	public void onDestoryed() {
		System.out.println("Boss 소멸");
	}

}
