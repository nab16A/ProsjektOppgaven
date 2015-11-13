package prosjektOppgaven;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


@RunWith(PowerMockRunner.class)
@PrepareForTest(MyClass.class)
public class MyClassTest {

	@Test
	public void isHexadecimal_Ten_ShouldBe_10() {

		PowerMockito.mockStatic(MyClass.class);
		Mockito.when(MyClass.isHexadecimal("a")).thenReturn(20);

		
	}

}
