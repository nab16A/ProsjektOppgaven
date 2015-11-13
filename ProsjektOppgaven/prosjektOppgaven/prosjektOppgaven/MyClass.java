package prosjektOppgaven;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public final class MyClass {
	
	private static final Map<Character, Integer> myMap;
	static {
		myMap = new HashMap<>();
		myMap.put('a', 10);
		myMap.put('b', 11);
		myMap.put('c', 12);
		myMap.put('d', 13);
		myMap.put('e', 14);
		myMap.put('f', 15);
	}
	
	public MyClass() {

	}
	
	public static int konverterHexTilInt(String string) {
		int y = 0;
		if(sjekkHexStringen(string)) 
			y = beregnHexStringen(string);
		return y;
		
	}

	private static int beregnHexStringen(String s) {
		int sum = 0;
		List<Integer> intList = new ArrayList<>();
		char[] sArr = s.toLowerCase().toCharArray();
		for(int i = 0; i < sArr.length; i++) {
			if (Character.isDigit(sArr[i])) { 
				intList.add((int)sArr[i] - 48);
			} else if (Character.isLetter(sArr[i])) {
				if (myMap.containsKey(sArr[i])) {
					intList.add(myMap.get(sArr[i]));
				}
			}
		}
		sum = (intList.get(0) * ((int)(Math.pow(16, 5)))) + (intList.get(1) * 
				((int)(Math.pow(16, 4)))) + (intList.get(2) * ((int)(Math.pow(16, 3)))) +
				(intList.get(3) * ((int)(Math.pow(16, 2)))) + (intList.get(4) *
				((int)(Math.pow(16, 1)))) + (intList.get(5) * ((int)(Math.pow(16, 0))));
		return sum;
	}

	public static boolean sjekkHexStringen(String str) {
		if(str.length() == 6 && str.matches(".*[a-f].*") && str.matches(".*[0-9].*")) 
			return true;
		return false;
	}

	public static int isHexadecimal(String s) {
		if (s == "a")
			return 10;
		return -1;
	}

}
