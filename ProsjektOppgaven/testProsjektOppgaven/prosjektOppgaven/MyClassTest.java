package prosjektOppgaven;

import static org.junit.Assert.*;
import org.junit.Test;
import org.mockito.Mockito;
import static org.hamcrest.CoreMatchers.*;

public class MyClassTest {

	@Test
	public void isHexadecimal_Ten_ShouldBe_10() {

		MyClass mc = Mockito.mock(MyClass.class);
		Mockito.when(mc.isHexadecimal("a")).thenReturn(20);

		MyClass mc1 = new MyClass();
		assertEquals(mc1.isHexadecimal("a"), 10);
	}
	
	@Test
	public void isHexadecimal_MinusOne_ShouldBe_NegativOne() {

		MyClass mc = Mockito.mock(MyClass.class);
		Mockito.when(mc.isHexadecimal("a")).thenReturn(-1);

		MyClass mc1 = new MyClass();
		assertThat(mc1.isHexadecimal("F"), equalTo(-1));
	}
	

}
