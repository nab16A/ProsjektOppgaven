package prosjektOppgaven;

import org.junit.Assert;
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

	@Test
	public void isHexadecimal_Ten_ShouldBe_10() {
		
		assertEquals(MyClass.isHexadecimal("a"), 10);

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.isHexadecimal("a")).thenReturn(-1);

		assertEquals(MyClass.isHexadecimal("a"), -1);
	}

}
