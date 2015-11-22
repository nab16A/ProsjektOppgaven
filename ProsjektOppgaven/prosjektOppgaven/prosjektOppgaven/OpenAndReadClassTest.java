package prosjektOppgaven;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class OpenAndReadClassTest {
	private static final String  FILE = "H:/Dokumenter/H I N/Høst 2015/ITE1901 Programmering 2/"
			+ "Obligatoriske oppgaver/dataFilen.txt";
	String s = "03ac0f 1 110101000000110111001101 001000011110011101001111 5";
	
	@Mock
	AboutFile aboutFileMock;
	
	@InjectMocks
	OpenAndReadClass minKlasse;
	
	//@Ignore
	@Test
	public void openMyFile_PathToTheFile_ShouldReturnTrue() throws IOException {
		minKlasse.openMyFile();
		verify(aboutFileMock).openFile(FILE);
		/*OpenAndReadClass tes = new OpenAndReadClass(aboutFileMock);
		boolean check = tes.openMyFile();
		assertFalse(check);*/
	}
	
	@Test(expected=Exception.class)
	public void readMyFile_DataArgumentsGreatherThenFour_ShouldThrowAnException() throws Exception {
		OpenAndReadClass testos = Mockito.mock(OpenAndReadClass.class);
		doThrow(new Exception()).when(testos.readMyFile(s));
	}
	
	@Test
	public void test() throws Exception {
		OpenAndReadClass tes = new OpenAndReadClass(aboutFileMock);
		boolean check = tes.moreData(FILE);
		assertFalse(check);
		//verify(aboutFileMock).isMoreDataToRead(FILE);
	}

}
