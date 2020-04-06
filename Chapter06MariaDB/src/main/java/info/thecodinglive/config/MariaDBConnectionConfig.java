package info.thecodinglive.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("application.properties")
public class MariaDBConnectionConfig {
	@Value("${spring.datasource.url}")
	private String dbUrl;
	@Value("${spring.datasource.username}")
	private String dbUsername;
	@Value("${spring.datasource.password}")
	private String dbPassword;
	@Value("${spring.datasource.driver-class-name}")
	private String dbClassName;

	@Value("${spring.datasource.schema}")
	private String dbSchema;
	@Value("${spring.datasource.data}")
	private String dbData;
	
	/**
	 * '@Lazy'를 사용하여 다른 Bean들을 먼저 초기화 후 해당 메서드 실행
	 * 데이터베이스의 커넥션을 다시 얻어야하는 상황에서 오류의 범위를 축소(데이터베이스 부분은 따로 오류를 처리)
	 * */
	@Lazy
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		final HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setUsername(dbUsername);
		hikariConfig.setPassword(dbPassword);
	
		// jdbc:MariaDB://IP/dbNmae이 아닌 org.MariaDB.jdbc.MySQLDataSource를 사용하면 setJdbcUrl로 정의된 속성이 무시
		// hikariConfig.setJdbcUrl(dbUrl);
		// addDataSourceProperty 메서드를 사용해서 키값을 url로 정의하여 JDBC URL을 입력받을 것
		hikariConfig.addDataSourceProperty("url", dbUrl);
		hikariConfig.setDataSourceClassName(dbClassName);
		hikariConfig.setLeakDetectionThreshold(2000);
		hikariConfig.setPoolName("jpubDBpool");
		
		// autoCommit : 커넥션을 종료하거나 pool에 반환할 때 트랜잭션 자동화 여부를 결정, 기본 값 TRUE
		boolean isAutoCommit = true;
		hikariConfig.setAutoCommit(isAutoCommit);
		// readOnly : 데이터베이스 변경에 대해서 트랜잭션을 처리하지 않고 읽기만 하는 옵션, 기본 값 FALSE
		boolean readOnly = false;
		hikariConfig.setReadOnly(readOnly);
		// connectionTimeout은 커넥션 얻는 데 소요되는 최대 시간(ms)이며 초과 시 오류 발생, 기본 값 3000(30초)
		long connectionTimeoutMs = 30000;
		hikariConfig.setConnectionTimeout(connectionTimeoutMs);
		
		final HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		System.out.println("::HikariCP DataSource::");
		
		// SQL파일 Resource
		Resource resourceSchema = new ClassPathResource(dbSchema);
		Resource resourceData = new ClassPathResource(dbData);
		// SQL Query execute
		ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator(resourceSchema, resourceData);
		databasePopulator.execute(dataSource);
		
		return dataSource;
	}
	
}
