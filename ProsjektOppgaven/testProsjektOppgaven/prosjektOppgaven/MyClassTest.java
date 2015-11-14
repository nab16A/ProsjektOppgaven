package prosjektOppgaven;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
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
	
	@Ignore
	@Test
	public void isHexadecimal_Ten_ShouldBe10() {
		assertEquals(MyClass.isHexadecimal("a"), 10);
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.isHexadecimal("a")).thenReturn(-1);
		assertEquals(MyClass.isHexadecimal("a"), -1);
	}
	
	@Ignore
	@Test
	public void sjekkHexStringen_03ac0f_ShouldBeTrue() {
		assertTrue(MyClass.sjekkHexStringen("03ac0f"));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.sjekkHexStringen("a")).thenReturn(true);
		assertTrue(MyClass.sjekkHexStringen("a"));
	}
	
	@Ignore
	@Test
	public void konverterHexTilInt_0D510f_ShouldBe872719() {
		assertThat(MyClass.konverterHexStrengTilInt("0D510f"), is(872719));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konverterHexStrengTilInt("?")).thenReturn(00);
		assertThat(MyClass.konverterHexStrengTilInt("?"), equalTo(00));
	}
	
	@Ignore
	@Test
	public void konvertIntTilHex_32993_ShouldBe80e1() {
		assertThat(MyClass.konvertIntTilHex(32993), is("080e1"));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertIntTilHex(221)).thenReturn("x");
		assertThat(MyClass.konvertIntTilHex(221), equalTo("x"));
	}
	
	@Ignore
	@Test
	public void konvertBitStrengTilInt_empty_ShouldBe0() {
		assertThat(MyClass.konvertBitStrengTilInt(""), is(0));
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertBitStrengTilInt("a")).thenReturn(12);
		assertThat(MyClass.konvertBitStrengTilInt("a"), equalTo(12));
	}
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Test
	public void konvertBitStrengTilInt_StringWithOtherSignsThan0Or1_ShouldBeThrowAnException() {
		exception.expect(IllegalArgumentException.class);
		exception.expectMessage("Bit stringen må ha bare 0 eller 1 som tegn");
		MyClass.konvertBitStrengTilInt("010010001000010001000005");
				
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertBitStrengTilInt("010010001000010001000005")).thenReturn(5);
		assertThat(MyClass.konvertBitStrengTilInt("010010001000010001000005"), equalTo(5));
	}

}
