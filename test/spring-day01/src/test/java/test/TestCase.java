package test;
import ioc.A;
import ioc.LoginService;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;






import scope.MessageBean;
import scope.ScopeBean;
public class TestCase {
	@Test
	//≤‚ ‘◊˜”√”Ú
	public void test1(){
		
		AbstractApplicationContext ac=new ClassPathXmlApplicationContext("scope.xml");
		ScopeBean s1=ac.getBean("s1",ScopeBean.class);
		ScopeBean s2=ac.getBean("s1",ScopeBean.class);
		System.out.println(s1==s2);
	}
	
	@Test
	public void test2(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("scope.xml");
		MessageBean mb1=ac.getBean("mb1",MessageBean.class);
		mb1.sendMsg();
		ac.close();
	}
	
	@Test
	public void test3(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("scope.xml");
		
	}
	
	@Test
	public void test4(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("ioc.xml");
		A a1=ac.getBean("a1",A.class);
		a1.execute();
	}
	
	@Test
	public void test5(){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("pratice.xml");
		LoginService ls=ac.getBean("ls",LoginService.class);
	}
}	
