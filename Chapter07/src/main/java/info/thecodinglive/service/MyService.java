package info.thecodinglive.service;

import info.thecodinglive.config.MyAnnotation;

public class MyService {
	@MyAnnotation(strValue = "Hi", intValue = 1103)
	public void printSomething() {
		System.out.println("Test my anntaion.");
	}
}
