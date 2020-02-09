package basic;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee implements WorkManager {
	@PostConstruct
	public void onCreated() {
		System.out.println("Employee 생성");
	}
	
	@Override
	public String doIt() {
		return "do work";
	}
	@PreDestroy
	public void onDestoryed() {
		System.out.println("Employee 소멸");
	}
}
