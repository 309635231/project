package demo;

import org.junit.Test;
//执行一个类中全部以@Test标注方法
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
