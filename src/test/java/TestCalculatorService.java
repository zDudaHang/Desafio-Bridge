
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigInteger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import service.CalculatorService;

public class TestCalculatorService {
	
	private static CalculatorService service = null;
	
	@BeforeAll
	public static void initCalculatorService() {
		service = new CalculatorService();
	}
	
	@Test
	@DisplayName("Test with negative number")
	public void testNegativeParameter() {
		assertEquals(BigInteger.valueOf(-1), service.calculate(-1));
	}
	
	@Test
	@DisplayName("Test with base numbers of factorial")
	public void testBaseParameter() {
		assertEquals(BigInteger.valueOf(1), service.calculate(0));
		assertEquals(BigInteger.valueOf(1), service.calculate(1));
	}
	
	@Test
	@DisplayName("Test with number 10")
	public void testOrdinaryNumber() {
		assertEquals(BigInteger.valueOf(3628800), service.calculate(10));
	}
	
}
