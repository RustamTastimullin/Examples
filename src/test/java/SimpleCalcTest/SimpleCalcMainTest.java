package SimpleCalcTest;


import org.example.examples.SimpleCalc.SimpleCalcMain;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SimpleCalcMainTest {

	int x;
	int y;

	@Before
	public void setUp() {
		x = 5;
		y = 7;
	}

	@Test
	public void testSum() {
		int result = 13;
		Assert.assertEquals("5 + 7  must be equal 12", result, SimpleCalcMain.sum(x, y));
	}

}
