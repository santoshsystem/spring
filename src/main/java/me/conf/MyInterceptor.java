package me.conf;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//public class MyInterceptor implements HandlerInterceptor {
public class MyInterceptor extends HandlerInterceptorAdapter {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("=== afterCompletion ====");
	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("=== postHandle ====");
		
	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("=== preHandle ====");
		arg0.getReader().lines().forEach(System.out::println);
		//MyRequestWrapper wrapper = new MyRequestWrapper(arg0);
		//System.out.println(wrapper.getLines());
		return true;
		//return super.preHandle(wrapper, arg1, arg2);
	}

}
