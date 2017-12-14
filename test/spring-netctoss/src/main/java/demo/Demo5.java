package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo5 {
	public static void main(String[] args) throws Exception{
		Scanner inScanner=new Scanner(System.in);
		System.out.print("¿‡√˚£∫");
		String className=inScanner.nextLine();
		Class cls=Class.forName(className);
		Method[] aryMethods=cls.getDeclaredMethods();
		Object obj=cls.newInstance();
		for(Method method:aryMethods){
			Demo annObject=method.getAnnotation(Demo.class);
			System.out.println(method);
			System.out.println(annObject);
			if(annObject!=null){
			method.invoke(obj);
			}
		}
	}
}
