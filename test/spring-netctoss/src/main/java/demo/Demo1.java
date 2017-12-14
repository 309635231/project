package demo;

import java.lang.reflect.Method;
import java.util.Scanner;



public class Demo1 {
	public static void main(String[] args) throws Exception{
		Scanner in = new Scanner(System.in);
		System.out.print("输入类名");
		String className=in.nextLine();
		Class cls = Class.forName(className);
		System.out.println(cls);
		Object obj=cls.newInstance();
		System.out.println(obj);
		
		
		Method[] ary=cls.getDeclaredMethods();
		for(Method method: ary){
			System.out.println(method);
			System.out.println(method.getName());
			System.out.println(method.getReturnType());
			String name=method.getName();
			if(name.startsWith("test")){
				System.out.println("找到了");
			}
		}
	}
}
