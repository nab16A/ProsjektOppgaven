package prosjektOppgaven;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	
	public static String konvertIntTilBitStreng(int tall) {
		if(tall < 0)
			throw new IllegalArgumentException("Tallet må være positivt");
		String s = "";
		int arrBinary[] = new int[24];
		int k = 0;
		while (tall > 0) {
			arrBinary[k++] = tall % 2;
			tall = tall / 2;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = k - 1; i >= 0; i--) {
			s += sb.append(arrBinary[i]).toString();
		}
		while (s.length() < 24) {
			s = "0" + s;
		}
		return s;
	}
	
	public static int konvertBitStrengTilInt(Object object) throws ParseException {
		if (object == "")
			return 0;
		if (((String) object).length() < 24 || ((String) object).length() > 24)
			throw new IllegalArgumentException("Bit strengen må ha 24 tegn");
		if (!((String) object).matches("[0-1]+"))
			throw new IllegalArgumentException(
					"Bit strengen må ha bare 0 eller 1 som tegn");

		return forberedBeregningBitStreng(object);
	}

	public static int forberedBeregningBitStreng(Object object) throws ParseException {
		
		String[] strArr = ((String) object).split("");
		int potens = strArr.length - 1;

		return beregnBitStrengtilInt(strArr, potens);
	}

	public static int beregnBitStrengtilInt(String[] strArr, int p) throws ParseException {
		DecimalFormat df = new DecimalFormat();
		int tall = 0;
		for (int i = 0; i < strArr.length; i++) {
			tall += (df.parse(strArr[i]).intValue()) * Math.pow(2, p--);
		}
		return tall;
	}

	public static String konvertIntTilHexStreng(int x) {
		String s = "";
		int modulo;
		char hexArr[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		while (x > 0) {
			modulo = x % 16;
			s = hexArr[modulo] + s;
			x = x / 16;
		}
		return s.toUpperCase();
	}

	public static int konverterHexStrengTilInt(String string) {
		if (string == "")
			return 0;
		if (string.length() < 6 || string.length() > 6)
			throw new IllegalArgumentException("Hex strengen må ha 6 tegn");
		if (!string.matches("^(?=.*[a-f])(?=.*[0-9])[a-f0-9]+$")
				&& !string.matches("^(?=.*[A-F])(?=.*[0-9])[A-F0-9]+$"))
			throw new IllegalArgumentException(
					"Hex strengen må ikke ha andre tegn enn"
							+ " 0123456789abcdef/ABCDEF");

		return beregnHexStringen(string);
	}

	public static int beregnHexStringen(String s) {
		int sum = 0;
		List<Integer> intList = new ArrayList<>();
		char[] sArr = s.toLowerCase().toCharArray();
		for (int i = 0; i < sArr.length; i++) {
			if (Character.isDigit(sArr[i])) {
				intList.add((int) sArr[i] - 48);
			} else if (Character.isLetter(sArr[i])) {
				if (myMap.containsKey(sArr[i])) {
					intList.add(myMap.get(sArr[i]));
				}
			}
		}
		sum = (int) ((intList.get(0) * Math.pow(16, 5))
				+ (intList.get(1) * Math.pow(16, 4))
				+ (intList.get(2) * Math.pow(16, 3))
				+ (intList.get(3) * Math.pow(16, 2))
				+ (intList.get(4) * Math.pow(16, 1)) + (intList.get(5) * Math
				.pow(16, 0)));
		return sum;
	}

	public static int isHexadecimal(String s) {
		if (s == "a")
			return 10;
		return -1;
	}
}
