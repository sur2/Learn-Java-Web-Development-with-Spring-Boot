package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import basic.Boss;
import basic.Employee;
import basic.WorkManager;
import basic.WorkService;

/**
 * applicationContext.xml과 같은 Spring Bean Configuration File를 사용하지 않고
 * '@Configuration' 어노테이션을 클래스 상단에 추가해서 이 클래스가 빈 설정 정보가 포함된 클래스임을 명시한다.
 * '@Import' 어노테이션을 사용하여 다른'@Configuration' 어노테이션이 붙은 클래스의 Bean을 등록할 수 있다.
 */
@Configuration
@Import(CompanyConfig.class)
public class BeanConfig {
	/**
	 * <Bean> 태그들은 '@Bean' 어노테이션으로 대체할 수 있다.
	 * '@Bean' 어노테이션이 속성으로 initMethod와  destroyMethod를 사용하여 생명주기를 제어할 수 있다.
	 */	
	@Bean
//	(initMethod = "onCreated", destroyMethod = "onDestoryed")
	public WorkManager employee() {
		return new Employee();
	}
	@Bean
//	(initMethod = "onCreated", destroyMethod = "onDestoryed")
	public WorkManager boss() {
		return new Boss();
	}
	@Bean
	public WorkService yourWorkService() {
		WorkService workService = new WorkService();
		workService.setWorkManager(employee());
		return workService;
	}
	@Bean
	public WorkService myWorkService() {
		WorkService workService = new WorkService();
		workService.setWorkManager(boss());
		return workService;
	}
}
