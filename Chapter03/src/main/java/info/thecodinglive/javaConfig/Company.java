package info.thecodinglive.javaConfig;

public class Company {
	private String name;
	
	public Company(String name) {
		this.name = name;
	}
	
	public String getName() {
		System.out.println(name);
		return name;
	}

	public void onCreated() {
		System.out.println("Company 초기화");
	}
	
	public void onDestory() {
		System.out.println("Company 소멸");
	}
}
