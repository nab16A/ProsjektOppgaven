package prosjektOppgaven;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
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
	
	 private MyFile myFile;
	 private String  path = "H:/Dokumenter/H I N/Høst 2015/ITE1901 Programmering 2/"
			+ "Obligatoriske oppgaver/dataFilen.txt";
	 private String str = "03ac0f 1 110101000000110111001101 001000011110011101001111 5";
	 
	@Before
	public void setUp() {
		myFile = new MyFile();
	}
	
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
	
	//@Ignore
	@Test
	public void dataLagring_ac0e1e_ShouldReturn1357() throws Exception {
		String str = "03ac0f";
		assertThat(myFile.dataLagring(str).get(2).get(0), is(1357));
	}
	
	@Test
	public void myLoggeData___ShouldReturnTheLoggData() throws Exception {
		String str = "acac00";
		assertThat(Integer.valueOf((String) myFile.loggeData().get(str).get(1).get(1)), is(3));
	}


	

}
