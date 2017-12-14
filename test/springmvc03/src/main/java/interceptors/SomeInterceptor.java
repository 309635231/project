package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SomeInterceptor implements HandlerInterceptor{
	//���ִ�еķ�����ֻ�е�preHandler��������ֵΪtrueʱ���÷����Ż�ִ��
	//���һ�������Ǵ��������׳����쳣������дһ�������������������������׳����쳣
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion()");
	}
	
	//�������ķ����Ѿ�ִ����ϣ���׼�������������ظ�ǰ�˴�����֮ǰִ��postHandle�����������ڸ÷������޸Ĵ�����
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		System.out.println("postHandle()");
	}

	//DispatcherServlet�յ�����󣬻��ȵ���preHandle����������÷����ķ���ֵ��true������������ã��������ֵΪfalse����������
	//arg2:����������������һ������
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}
	
}
