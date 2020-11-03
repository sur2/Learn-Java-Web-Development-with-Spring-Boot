package info.thecodinglive.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * Target은 어노테이션 적용대상을 의미
 * */
@Target(ElementType.METHOD)
/**
 * Retention은 어노테이션이 적용될 범위를 결정
 * CLASS : 어노테이션 작성 시 기본값, 클래스 파일에 포함되지만 JVM이 로드하지 않는다.
 * RUNTIME : 클래스 파일에 포함되고, JVM이 로드해서 리플렉션 API로 참조 가능하다.
 * SOURCE : 컴파일 때만 사용되고, 클래스 파일에 포함되지 않는다.
 * */ 
@Retention(RetentionPolicy.RUNTIME) 
public @interface MyAnnotation {
	String strValue();
	int intValue();
}
