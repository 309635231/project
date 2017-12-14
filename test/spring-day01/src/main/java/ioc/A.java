package ioc;

public class A {
	private IB b;
	
	public void setB(IB b) {
		System.out.println("setB()");
		this.b = b;
	}

	public A() {
		System.out.println("A()");
	}

	public void execute(){
		System.out.println("execute()");
		b.f1();
	}
}
