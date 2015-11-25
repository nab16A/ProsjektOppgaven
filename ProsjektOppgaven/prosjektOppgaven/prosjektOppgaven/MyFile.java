package prosjektOppgaven;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyFile implements AboutFile {

	private static final String PATH = "H:/Dokumenter/H I N/Høst 2015/ITE1901 Programmering 2/"
			+ "Obligatoriske oppgaver/dataFilen.txt";
	private static List<List<String>> listData;
	private static List<String> listHex;
	private static List<String> listId;
	private static List<String> listBinaryData1;
	private static List<String> listBinaryData2;
	private static List<String> feilListHex;
	private static List<String> feilListId;
	private static List<String> feilListBinary1;
	private static List<String> feilListBinary2;
	private static List<List<?>> feilListData;
	File fila = null;
	BufferedReader br = null;

	@Override
	public boolean openFile(String path) throws IOException {
		path = PATH;
		fila = new File(path);
		if (fila.exists() && Desktop.isDesktopSupported())
			return true;
		return false;
	}

	@Override
	public List<List<String>> readFile(String path) throws Exception {
		path = PATH;
		listData = new ArrayList<>();
		listHex = new ArrayList<>();
		listId = new ArrayList<>();
		listBinaryData1 = new ArrayList<>();
		listBinaryData2 = new ArrayList<>();
		feilListHex = new ArrayList<>();
		feilListId = new ArrayList<>();
		feilListBinary1 = new ArrayList<>();
		feilListBinary2 = new ArrayList<>();
		feilListData = new ArrayList<>();
		
		fila = new File(path);
		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(fila)));
		String line = null;

		while ((line = br.readLine()) != null) {
			String[] tokens = line.split("\\s+");
			if (tokens.length != 4)
				throw new Exception();
			if(!tokens[1].equals("1") && !tokens[1].equals("2")) {
				feilListHex.add(tokens[0]);
				feilListId.add(tokens[1]);
				feilListBinary1.add(tokens[2]);
				feilListBinary2.add(tokens[3]);
			}
			listHex.add(tokens[0]);
			listId.add(tokens[1]);
			listBinaryData1.add(tokens[2]);
			listBinaryData2.add(tokens[3]);
		}
		feilListData.add(feilListHex);
		feilListData.add(feilListId);
		feilListData.add(feilListBinary1);
		feilListData.add(feilListBinary2);
		listData.add(listHex);
		listData.add(listId);
		listData.add(listBinaryData1);
		listData.add(listBinaryData2);

		calculateBitwiseAND_AsString();
		calculateBitwiseOR_AsString();
		calculateBitwiseAND_AsInt();
		calculateBitwiseOR_AsInt();
		return listData;
	}

	@Override
	public boolean isMoreDataToRead(String path) throws IOException {
		path = PATH;
		br = new BufferedReader(
				new InputStreamReader(new FileInputStream(fila)));
		String line = br.readLine();

		while (line != null) {
			line = br.readLine();
		}
		return false;
	}

	@Override
	public List<String> calculateBitwiseAND_AsString() throws Exception {
		List<String> totalList = new ArrayList<>();
		for (int i = 0; i < listId.size(); i++) {
			if (listId.get(i).equals("1")) {
				String s = null;
				String[] s1Arr = listBinaryData1.get(i).split("");
				String[] s2Arr = listBinaryData2.get(i).split("");
				String[] total = new String[24];
				for (int j = 0; j < s1Arr.length && j < s2Arr.length; j++) {
					if (s1Arr[j].equals("0") && s2Arr[j].equals("0")) {
						total[j] = "0";
					} else if (s1Arr[j].equals("1") && s2Arr[j].equals("1")) {
						total[j] = "1";
					} else {
						total[j] = "0";
					}
					s = Arrays.toString(total).replaceAll("[,]\\s", "");
				}
				totalList.add(s.substring(1, 25));
			}
		}
		return totalList;
	}

	@Override
	public List<String> calculateBitwiseOR_AsString() throws Exception {
		List<String> totalList = new ArrayList<>();
		for (int i = 0; i < listId.size(); i++) {
			if (listId.get(i).equals("2")) {
				String s = null;
				String[] s1Arr = listBinaryData1.get(i).split("");
				String[] s2Arr = listBinaryData2.get(i).split("");
				String[] total = new String[24];
				for (int j = 0; j < s1Arr.length && j < s2Arr.length; j++) {
					if (s1Arr[j].equals("0") && s2Arr[j].equals("0")) {
						total[j] = "0";
					} else if (s1Arr[j].equals("1") && s2Arr[j].equals("1")) {
						total[j] = "1";
					} else {
						total[j] = "1";
					}
					s = Arrays.toString(total).replaceAll("[,]\\s", "");
				}
				totalList.add(s.substring(1, 25));
			}
		}
		return totalList;
	}

	@Override
	public List<Integer> calculateBitwiseAND_AsInt() throws Exception {
		List<Integer> listInt = new ArrayList<>();
		List<String> listStr = calculateBitwiseAND_AsString();
		for (int i = 0; i < listStr.size(); i++) {
			listInt.add(MyClass.konvertBitStrengTilInt(listStr.get(i)));
		}
		return listInt;
	}

	@Override
	public List<Integer> calculateBitwiseOR_AsInt() throws Exception {
		List<Integer> listInt = new ArrayList<>();
		List<String> listStr = calculateBitwiseOR_AsString();
		for (int i = 0; i < listStr.size(); i++) {
			listInt.add(MyClass.konvertBitStrengTilInt(listStr.get(i)));
		}
		return listInt;
	}

	@Override
	public List<List<?>> dataLagring(String string) throws Exception {
		
		readFile(PATH);
		List<List<?>> gjenFinneList = new ArrayList<>();
		
		Map<String, List<List<?>>> myData = new HashMap<>();

		List<String> bitwiseAndStr = calculateBitwiseAND_AsString();
		List<String> bitwiseOrStr = calculateBitwiseOR_AsString();
		List<Integer> bitwiseAndInt = calculateBitwiseAND_AsInt();
		List<Integer> bitwiseOrInt = calculateBitwiseOR_AsInt();

		List<List<?>> saveData = new ArrayList<>();

		for (int i = 0; i < 1; i++) {
			saveData.add(bitwiseAndStr);
			saveData.add(bitwiseOrStr);
			saveData.add(bitwiseAndInt);
			saveData.add(bitwiseOrInt);
			saveData.add(listData);
		}

		for (int i = 0; i < listHex.size(); i++) {
			myData.put(listHex.get(i), saveData);
		}
		
		gjenFinneList = myData.get(string);
		
		return gjenFinneList;
	}

	@Override
	public Map<String, List<List<?>>> loggeData() throws Exception {

		readFile(PATH);
		Map<String, List<List<?>>> loggData = new HashMap<>();

		for (int i = 0; i < feilListHex.size(); i++) {
			loggData.put(feilListHex.get(i), feilListData);
		}
		return loggData;
	}

}
