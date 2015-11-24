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
	
	 private String  path = "H:/Dokumenter/H I N/Høst 2015/ITE1901 Programmering 2/"
			+ "Obligatoriske oppgaver/dataFilen.txt";
	 private String str = "03ac0f 1 110101000000110111001101 001000011110011101001111 5";
	
	@Mock
	AboutFile aboutFileMock;
	
	@InjectMocks
	OpenAndReadClass minKlasse;
	
	//@Ignore
	@Test
	public void openMyFile_PathToTheFile_ShouldReturnTrue() throws IOException {
		minKlasse.openMyFile(path);
		verify(aboutFileMock).openFile(path);
	}
	
	//@Ignore
	@Test(expected=Exception.class)
	public void readMyFile_DataArgumentsGreatherThenFour_ShouldThrowAnException() throws Exception {
		OpenAndReadClass test2 = mock(OpenAndReadClass.class);
		doThrow(new Exception()).when(test2.readMyFile(str));
	}
	
	//@Ignore
	@Test
	public void moreData_IfThereIsNoMoreDataToRead_ShouldReturnFalse() throws Exception {
		OpenAndReadClass test3 = new OpenAndReadClass(aboutFileMock);
		boolean check = test3.moreData(path);
		assertFalse(check);
		verify(aboutFileMock).isMoreDataToRead(path);
	}

}
