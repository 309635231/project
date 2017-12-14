package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.print("����������");
		String className=in.nextLine();
		Class cls=Class.forName(className);
		
		String name="demo";
		Class[] types={String.class,int.class};
		Method method=cls.getDeclaredMethod(name, types);
		System.out.println(method);
		method.setAccessible(true);;
		Object obj=cls.newInstance();
		Object valueObject=method.invoke(obj, "Tom",12);
	}

}
