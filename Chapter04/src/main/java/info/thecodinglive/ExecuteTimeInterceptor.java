package info.thecodinglive;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 수행 시간 체크 인터셉터
 */
public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);

		String reqUri = request.getRequestURI();
		System.out.println("reqUri:: " + reqUri);

		return super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		super.postHandle(request, response, handler, modelAndView);

		long startTime = (long) request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;

		System.out.println("[" + handler + "] executeTime: " + executeTime + "ms.");
	}
}
