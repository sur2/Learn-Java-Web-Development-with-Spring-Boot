package info.thecodinglive.javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * applicationContext.xml과 같은 Spring Bean Configuration File를 사용하지 않고
 * '@Configuration' 어노테이션을 클래스 상단에 추가해서 이 클래스가 빈 설정 정보가 포함된 클래스임을 명시한다.
 */
@Configuration
public class CompanyConfig {
	/**
	 * <Bean> 태그들은 '@Bean' 어노테이션으로 대체할 수 있다.  
	 */	
	@Bean(initMethod = "onCreated", destroyMethod = "onDestory")
	public Company company() {
		return new Company("jpub");
	}
}
