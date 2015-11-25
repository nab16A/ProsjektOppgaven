package prosjektOppgaven;

import java.io.IOException;
import java.util.List;
import java.util.Map;

 
public class OpenAndReadClass {
	
	private AboutFile aboutFile;
			
	public OpenAndReadClass(AboutFile aboutFile) {
		this.aboutFile = aboutFile;
	}
	
	public boolean openMyFile(String str) throws IOException {
		return aboutFile.openFile(str);
	}
	
	public List<List<String>> readMyFile(String str) throws Exception {
		return aboutFile.readFile(str);
	}
	
	public boolean moreData(String str) throws IOException {
		return aboutFile.isMoreDataToRead(str);
	}
	
	public List<String> calculateTheBitwiseAND_AsString() throws Exception {
		return aboutFile.calculateBitwiseAND_AsString();
	}
	
	public List<String> calculateTheBitwiseOR_AsString() throws Exception {
		return aboutFile.calculateBitwiseOR_AsString();
	}
	
	public List<Integer> calculateTheBitewiseAND_AsInt() throws Exception {
		return aboutFile.calculateBitwiseAND_AsInt();
	}
	
	public List<Integer> calculateTheBitewiseOR_AsInt() throws Exception {
		return aboutFile.calculateBitwiseAND_AsInt();
	}
	
	public List<List<?>> myDataLagring(String str) throws Exception {
		return aboutFile.dataLagring(str);
	}
	
	public Map<String, List<List<?>>> myLoggeData() throws Exception {
		return aboutFile.loggeData();
	}
}
