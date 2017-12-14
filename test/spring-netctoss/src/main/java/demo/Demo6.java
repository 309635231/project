package demo;

public class Demo6 {
	public static void main(String[] args) throws Exception{
		ApplicationContext ctx=new ApplicationContext("spring-context.xml");
		Foo foo = (Foo)ctx.getBean("foo");
		Foo f2=ctx.getBean("foo",Foo.class);
		System.out.println(foo);
		System.out.println(f2);
	}
}
