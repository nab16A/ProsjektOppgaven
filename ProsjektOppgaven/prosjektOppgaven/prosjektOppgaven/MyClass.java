package prosjektOppgaven;


public class MyClass implements MyInterface {

	private static MyInterface mpo;

	public MyClass() {

	}

	public MyClass(MyInterface m) {
		this.mpo = m;
	}

	@Override
	public int isHexadecimal(String s) {
		if(s == "a")
			return 10;
		return -1;
	}

}
