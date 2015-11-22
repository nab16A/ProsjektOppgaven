package prosjektOppgaven;

import java.io.IOException;
import java.util.List;

 
public class OpenAndReadClass {
	
	private AboutFile aboutFile;
	private static final String  FILE = "H:/Dokumenter/H I N/Høst 2015/ITE1901 Programmering 2/"
			+ "Obligatoriske oppgaver/dataFilen.txt";
	
	public OpenAndReadClass(AboutFile aboutFile) {
		this.aboutFile = aboutFile;
	}
	
	public boolean openMyFile() throws IOException {
		return aboutFile.openFile(FILE);
	}
	
	public List<List<String>> readMyFile(String str) throws Exception {
		return aboutFile.readFile(FILE);
	}
	
	public boolean moreData(String str) throws IOException {
		return aboutFile.isMoreDataToRead(FILE);
	}
}
