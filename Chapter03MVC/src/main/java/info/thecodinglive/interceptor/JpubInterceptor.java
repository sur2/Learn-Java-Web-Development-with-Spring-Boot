package info.thecodinglive.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Interceptor 기능을 제공하는 Class이다. 사용하기 위해서는 applicationContext 또는
 * dispatcher-servlet.xml에 <mvc:interceptors> 태그를 추가한다.
 */
public class JpubInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor:: preHandle 메서드 실행 ");
		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor:: postHandle 메서드 실행 ");
		super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Interceptor:: afterComplete 메서드 실행");
		super.afterCompletion(request, response, handler, ex);
	}

	/**
	 * afterConcurrentHandlingStarted 메서드는 비동기 처리를 위해 사용
	 */
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterConcurrentHandlingStarted(request, response, handler);
	}

}
