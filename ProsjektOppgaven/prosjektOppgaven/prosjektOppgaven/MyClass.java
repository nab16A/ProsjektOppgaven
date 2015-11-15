package prosjektOppgaven;

import java.util.ArrayList;
import java.util.Arrays;
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

	public static int konvertBitStrengTilInt(String string) {
		if (string == "")
			return 0;
		if (string.length() < 24 || string.length() > 24)
			throw new IllegalArgumentException("Bit strengen må ha 24 tegn");
		if (!string.matches("[0-1]+"))
			throw new IllegalArgumentException(
					"Bit strengen må ha bare 0 eller 1 som tegn");

		return forberedBeregningBitStreng(string);
	}

	public static int forberedBeregningBitStreng(String string) {
		String[] strArr = string.split("");
		int potens = strArr.length - 1;

		return beregnBitStreng(strArr, potens);
	}

	public static int beregnBitStreng(String[] strArr, int p) {
		int tall = 0;
		for (int i = 0; i < strArr.length; i++) {
			tall += (int) (Integer.valueOf(strArr[i]) * Math.pow(2, p--));
		}
		return tall;
	}

	public static String konvertIntTilHexStreng(int x) {
		String s = "";
		int y = 0;

		String[] strArr = String.valueOf(x).split("");
		int n = strArr.length;

		if ((Math.pow(16, (n - 1)) > (double) x))
			y = n - 2;
		y = n - 1;

		ArrayList<Integer> tallList = new ArrayList<>();
		int d = (int) (x / ((int) Math.pow(16, y)));
		int sub = x - (d * ((int) Math.pow(16, y)));
		tallList.add(d);

		while (sub != 0) {
			x = sub;
			y = y - 1;
			d = (int) (sub / ((int) Math.pow(16, y)));
			sub = sub - (d * ((int) Math.pow(16, y)));
			tallList.add(d);
		}
		ArrayList<String> strList = new ArrayList<>();
		for (int i = 0; i < tallList.size(); i++) {
			if (tallList.get(i).compareTo(9) == -1
					|| tallList.get(i).compareTo(9) == 0)
				strList.add(String.valueOf(tallList.get(i)));
			for (Entry<Character, Integer> entry : myMap.entrySet()) {
				if (entry.getValue().equals(tallList.get(i)))
					strList.add(Character.toString(entry.getKey()));
			}
		}
		for (String string : strList) {
			s += string;
		}
		if (s.charAt(0) == '0' && s.charAt(1) == '0')
			return s.toUpperCase().substring(2);

		return s.toUpperCase().substring(1);
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
