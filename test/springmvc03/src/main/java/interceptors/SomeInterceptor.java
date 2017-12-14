package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
	//最后执行的方法，只有当preHandler方法返回值为true时，该方法才会执行
	//最后一个参数是处理器所抛出的异常，可以写一个拦截器，用来处理处理器所抛出的异常
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}
	
	//处理器的方法已经执行完毕，正准备将处理结果返回给前端处理器之前执行postHandle方法。可以在该方法里修改处理结果
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()");
	}

	//DispatcherServlet收到请求后，会先调用preHandle方法。如果该方法的返回值是true，则继续向后调用，如果返回值为false则不再向后调用
	//arg2:描述处理器方法的一个对象
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}
	
}
