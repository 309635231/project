package demo;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo2 {
	public static void main(String[] args) throws Exception{
	//��̬������
		Scanner in=new Scanner(System.in);
		System.out.println("����������");
		String className=in.nextLine();
		Class cls=Class.forName(className);
	//��̬��ȡȫ��������Ϣ
		Method[] ary=cls.getDeclaredMethods();
	//����ȫ������������testΪ��ͷ�ķ���
		Object obj=cls.newInstance();
		for(Method method:ary){
			if(method.getName().startsWith("test")){
				System.out.println(method);
				method.invoke(obj);
			}
		}
	}
	
}