package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
	}

	@Test
	public void testEmptyString() {
		assertEquals(0, Calculator.add(""));
	}

	@Test
	public void testTwoNumbers(){
		assertEquals(3, Calculator.add("1,2"));
	}

	@Test
	public void testOneNumber(){
		assertEquals(8, Calculator.add("8"));
	}

	@Test
	public void testMultipleNumbers(){
		assertEquals(6, Calculator.add("3,2,1"));
	}

	@Test
	public void testAddNumbersNewLine(){
		assertEquals(10, Calculator.add("5\n5"));
	}

	@Test
	public void testCommaNewline(){
		assertEquals(666, Calculator.add("333\n222,111"));
	}
}
