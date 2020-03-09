package info.thecodinglive.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * SqlSessionFactory Bean과 SqlSessionTemplate을 비롯한 Mybatis 관련 설정을 하는 클래스
 * Repository에서 사용할 때는 Mybatis-Spring에서 제공하는 sqlSessionTemplate을 사용한다.
 */
@Configuration
@MapperScan(basePackages = { "info.thecodinglive.repository" })
public class MyBatisConfig {

	/**
	 * 생성된 SqlSessionFactory Bean 주입
	 */
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
		return new SqlSessionTemplate(sqlSessionFactory);
	}

	/**
	 * Mybatis-config.xml 파일에 대한 설정 없이도 동작한다. 다만 Mybatis 관련 설정 파일이 없다는 메시지가 출력된다.
	 * 세밀한 설정 제어가 필요한 경우 사용하면 된다.
	 * @throws Exception 
	 */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// SQL Mapper 파일을 여러개 참조 : PathMatchingResourcePatternResolver()
		// 단일 파일 참조 : getResource()
		/*		
		sqlSessionFactoryBean.setConfigLocation(
				(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")));
		*/
		sqlSessionFactoryBean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:sample/mapper/*.xml"));
		return sqlSessionFactoryBean.getObject();
	}

}
