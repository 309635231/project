package demo;

import org.junit.Test;
//ִ��һ������ȫ����@Test��ע����
public class TestCase {
	public void test(){
		System.out.println("test");
	}
	@Demo
	public void hello(){
		System.out.println("Hello");
	}
	@Demo
	public void helloKitty(){
		System.out.println("Hello Kitty");
	}
}
