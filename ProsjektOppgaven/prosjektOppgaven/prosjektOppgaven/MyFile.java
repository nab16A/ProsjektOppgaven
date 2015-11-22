package prosjektOppgaven;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MyFile implements AboutFile {
	
	private static List<List<String>> listData;
	private static List<String> listHex;
	private static List<String> listId;
	private static List <String> listBinaryData1;
	private static List<String> listBinaryData2;
	private File fila;
	BufferedReader br = null;

	@Override
	public boolean openFile(String path) throws IOException {
		
		fila = new File(path);
		if(fila.exists() && Desktop.isDesktopSupported())
			return true;
		return false;
	}

	@Override
	public List<List<String>> readFile(String path) throws Exception {
		listData = new ArrayList<>();
		listHex = new ArrayList<>();
		listId = new ArrayList<>();
		listBinaryData1 = new ArrayList<>();
		listBinaryData2 = new ArrayList<>();
		
		fila = new File(path);
		br = new BufferedReader(new InputStreamReader(new FileInputStream(fila)));
		String line = null;
		
		while((line = br.readLine()) != null) {
			String[] tokens = line.split("\\s+");
			if(tokens.length != 4)
				throw new Exception();
			listHex.add(tokens[0]);
			listId.add(tokens[1]);
			listBinaryData1.add(tokens[2]);
			listBinaryData2.add(tokens[3]);
			
			listData.add(listHex);
			listData.add(listId);
			listData.add(listBinaryData1);
			listData.add(listBinaryData2);
		}
		return listData;
	}

	@Override
	public boolean isMoreDataToRead(String path) throws IOException {
			
		br = new BufferedReader(new InputStreamReader(new FileInputStream(fila)));
		String line = br.readLine();
		
		while(line != null) {
			line = br.readLine();
		}
		return false;
	}	

}
