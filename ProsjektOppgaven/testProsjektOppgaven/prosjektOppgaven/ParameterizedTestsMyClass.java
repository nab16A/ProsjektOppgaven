package prosjektOppgaven;

import static org.junit.Assert.*;
import java.text.ParseException;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestsMyClass {

	private final Object actual; 
	private final Object expected;
	
	@Parameters
	public static Iterable<Object[]> data() {
		
		return Arrays.asList(new Object[][] {
				{"03ac0f", 240655},
				{"", 0},
				{"aaaaaa", IllegalArgumentException.class},
				{"123456", IllegalArgumentException.class},
				{"03a5d1e", IllegalArgumentException.class},
				{"03a5d", IllegalArgumentException.class},
				{32993, "80E1"},
				{"001000011110011101001111", 2221903},
				{"001000011110011101001116", IllegalArgumentException.class},
				{"001000011110011101001", IllegalArgumentException.class},
				{-4, IllegalArgumentException.class},
				{10, "000000000000000000001010"}
		});
	}
	
	public ParameterizedTestsMyClass(Object actual, Object expected) {
		this.actual = actual;
		this.expected = expected;
    }
	
	@Test
	public void test_konverterHexStrengTilInt() {
		try{
			MyClass.konverterHexStrengTilInt((String) actual);
		} catch (IllegalArgumentException ex) {
			assertEquals(IllegalArgumentException.class, ex.getClass());
		}
	}
	
	@Test
	public void test_konvertIntTilHexStreng() {
		MyClass.konvertIntTilHexStreng((int)actual);
	}
	
	@Test
	public void test_konvertBitStrengTilInt() throws ParseException {
		try {
			MyClass.konvertBitStrengTilInt((String)actual);
		} catch (IllegalArgumentException ex) {
			assertEquals(IllegalArgumentException.class, ex.getClass());
		}
	}
	
	@Test
	public void test_konvertIntTilBitStreng() {
		try{
			MyClass.konvertIntTilBitStreng((Integer)actual);
		} catch (IllegalArgumentException ex) {
			assertEquals(IllegalArgumentException.class, ex.getClass());
		}
	}
}
