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
	public void konverterHexStrengTilInt_HexString03ac0f_ShouldBe240655() {
		assertThat(MyClass.konverterHexStrengTilInt("03ac0f"), is(240655));

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konverterHexStrengTilInt("a")).thenReturn(12);
		assertThat(MyClass.konverterHexStrengTilInt("a"), equalTo(12));
	}

	//@Ignore
	@Test
	public void konverterHexStrengTilInt_EmptyString_ShouldBe0() {
		assertThat(MyClass.konverterHexStrengTilInt(""), is(0));

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konverterHexStrengTilInt("?")).thenReturn(-1);
		assertThat(MyClass.konverterHexStrengTilInt("?"), equalTo(-1));
	}

	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konverterHexStrengTilInt_HexStringWithJustLetters_ShouldThrowAnException() {
		MyClass.konverterHexStrengTilInt("aaaaaa");
	}

	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konverterHexStrengTilInt_HexStringWithJustNumbers_ShouldThrowAnException() {
		MyClass.konverterHexStrengTilInt("123456");
	}

	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konverterHexStrengTilInt_HexStringGreatherThanSixCharactersOrLessThanSix_ShouldThrowAnException() {
		MyClass.konverterHexStrengTilInt("03a5d1e");
		MyClass.konverterHexStrengTilInt("03a5d");
	}

	//@Ignore
	@Test
	public void konvertIntTilHexStreng_32993_ShouldBe80E1() {
		assertThat(MyClass.konvertIntTilHexStreng(32993), is("80E1"));

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertIntTilHexStreng(32993)).thenReturn("x");
		assertThat(MyClass.konvertIntTilHexStreng(32993), equalTo("x"));
	}

	//@Ignore
	@Test
	public void konvertBitStrengTilInt_empty_ShouldBe0() {
		assertThat(MyClass.konvertBitStrengTilInt(""), is(0));

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertBitStrengTilInt("0")).thenReturn(12);
		assertThat(MyClass.konvertBitStrengTilInt("0"), equalTo(12));
	}

	//@Ignore
	@Test
	public void konvertBitStrengTilInt_001000011110011101001111_ShouldBe2221903() {
		assertThat(MyClass.konvertBitStrengTilInt("001000011110011101001111"),
				is(2221903));

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertBitStrengTilInt("001000011110011101001111"))
				.thenReturn(12);
		assertThat(MyClass.konvertBitStrengTilInt("001000011110011101001111"),
				equalTo(12));
	}

	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konvertBitStrengTilInt_BitStringWithOtherSignsThan0And1_ShouldBeThrowAnException() {
		MyClass.konvertBitStrengTilInt("001000011110011101001116");
	}

	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konvertBitStrengTilInt_BitStringWithLessThan24Characters_ShouldBeThrowAnException() {
		MyClass.konvertBitStrengTilInt("001000011110011101001");
	}
	
	//@Ignore
	@Test(expected = IllegalArgumentException.class)
	public void konvertIntTilBitStreng_NegativInt_ShouldBeThrowAnException() {
		MyClass.konvertIntTilBitStreng(-5);
	}
	
	//@Ignore
	public void konvertIntTilBitStreng_10_ShouldBe000000000000000000001010() {
		assertThat(MyClass.konvertIntTilBitStreng(10), is("000000000000000000001010"));
		
		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.konvertIntTilBitStreng(-5))
				.thenReturn("test");
		assertThat(MyClass.konvertIntTilBitStreng(-5),
				equalTo("test"));
	}
}
