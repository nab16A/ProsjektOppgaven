package prosjektOppgaven;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface AboutFile {
	
	boolean openFile(String file) throws IOException;
	
	List<List<String>> readFile(String file) throws IOException, Exception;
	
	boolean isMoreDataToRead(String file) throws IOException;
	
	List<String> calculateBitwiseAND_AsString() throws Exception;
	
	List<String> calculateBitwiseOR_AsString() throws Exception;
	
	List<Integer> calculateBitwiseAND_AsInt() throws Exception;
	
	List<Integer> calculateBitwiseOR_AsInt() throws Exception;
	
	List<List<?>> dataLagring(String string) throws Exception;
	
	public Map<String, List<List<?>>> loggeData() throws Exception;
}
