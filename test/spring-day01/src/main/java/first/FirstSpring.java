package first;

import java.util.Calendar;
import java.util.Date;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FirstSpring {
	public static void main(String[] args){
		ClassPathXmlApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		//System.out.println(ac);
		//获得对象
		Student stu=ac.getBean("stu1",Student.class);
		System.out.println(stu);
		Date date=ac.getBean("date",Date.class);
		System.out.println(date);
		Calendar cal1=ac.getBean("cal1",Calendar.class);
		System.out.println(cal1);
	}
}
