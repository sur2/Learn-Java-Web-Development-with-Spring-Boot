package basic;

public class BasicApp {
	public static void main(String[] args) {
		WorkService workService = new WorkService();
		WorkManager employee = new Employee();
		WorkManager boss = new Boss();
		
		workService.setWorkManager(employee);
		workService.asWork();
		
		workService.setWorkManager(boss);
		workService.asWork();
	}
}
