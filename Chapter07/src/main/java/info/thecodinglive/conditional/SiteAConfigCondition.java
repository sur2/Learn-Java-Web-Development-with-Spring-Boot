package info.thecodinglive.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author PYONG
 * SiteAConfigCondition implements Condition
 * 환경 변수 키와 값을 확인하는 클래스
 */
public class SiteAConfigCondition implements Condition{

	@Override
	// 환경 변수 키 env, 값 site_A가 입력되었는지 확인 
	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		// TODO Auto-generated method stub
		return "site_A".equals(context.getEnvironment().getProperty("env", "site_A"));
	}
}
