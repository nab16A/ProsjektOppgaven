package prosjektOppgaven;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class MyClassTest {
	
	//@Ignore
	@Test
	public void isHexadecimal_Ten_ShouldBe10() {
		
		assertEquals(MyClass.isHexadecimal("a"), 10);
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.isHexadecimal("a")).thenReturn(-1);

		assertEquals(MyClass.isHexadecimal("a"), -1);
	}
	
	//@Ignore
	@Test
	public void sjekkHexStringen_03ac0f_ShouldBeTrue() {
		
		assertTrue(MyClass.sjekkHexStringen("03ac0f"));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.sjekkHexStringen("a")).thenReturn(true);

		assertTrue(MyClass.sjekkHexStringen("a"));
	}
	
	@Test
	public void konverterHexTilInt_0D510f_ShouldBe872719() {
		
		assertThat(MyClass.konverterHexTilInt("0D510f"), is(872719));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konverterHexTilInt("?")).thenReturn(00);

		assertThat(MyClass.konverterHexTilInt("?"), equalTo(00));
	}

}
