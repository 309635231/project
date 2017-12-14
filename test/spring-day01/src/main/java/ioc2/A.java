package ioc2;

public class A {
	
	private B b;
	
	public A() {
		System.out.println("A()");
	}
	
	public A(B b) {
		System.out.println("A(B)");
		this.b = b;
	}

	public void execute(){
		System.out.println("execute()");
		b.f1();
	}


}