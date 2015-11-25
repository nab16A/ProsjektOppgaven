package prosjektOppgaven;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;




import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestsMyClass {

	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	private MyClass mc = new MyClass();
	private final String actual; 
	private final Object expected;
	
	@Parameters
	public static Iterable<Object[]> data() {
		
		return Arrays.asList(new Object[][] {
				{"03ac0f", 240655},
				{"", 0}
		});
	}
	
	public ParameterizedTestsMyClass(String actual, Object expected) {
		this.actual = actual;
		this.expected = expected;
    }
	
	@Test
	public void test_konverterHexStrengTilInt() {
		MyClass.konverterHexStrengTilInt(actual);
	}

}
