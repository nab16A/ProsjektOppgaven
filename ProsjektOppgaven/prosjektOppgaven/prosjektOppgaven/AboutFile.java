package prosjektOppgaven;

import java.io.IOException;
import java.util.List;

public interface AboutFile {
	
	boolean openFile(String file) throws IOException;
	
	List<List<String>> readFile(String file) throws IOException, Exception;
	
	boolean isMoreDataToRead(String file) throws IOException;

}
