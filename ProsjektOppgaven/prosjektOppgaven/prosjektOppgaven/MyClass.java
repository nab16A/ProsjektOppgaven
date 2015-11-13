package prosjektOppgaven;


public final class MyClass {

	public MyClass() {

	}
	
	public static int konverterHexTilInt(String s) {
		if(sjekkHexStringen(s))
			return 1;
		return -1;
	}

	public static boolean sjekkHexStringen(String s) {
		if(s.length() == 6) 
			if(s.matches(".*[a-f].*") || s.matches(".*[A-F].*") || s.matches(".*[0-9].*"))
				return true;
		return false;
	}

	public static int isHexadecimal(String s) {
		if (s == "a")
			return 10;
		return -1;
	}

}
