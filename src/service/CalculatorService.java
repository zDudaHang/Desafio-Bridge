package service;

import java.math.BigInteger;
import java.util.ArrayList;

import model.Calculation;

/** The servlet class for the calculator
 * @author Maria Eduarda de Melo Hang
*/
public class CalculatorService {
	private ArrayList<Calculation> history = null;
	
	public CalculatorService() {
		history = new ArrayList<>();
	}
	
	public BigInteger calculate(int number) {
		BigInteger result = calculteFactorialTopDown(number);
		history.add(new Calculation(number,result));
		
		return result;
	}
	
	
	public BigInteger calculteFactorialTopDown(int number) {
		if (number <= 1) {
			return BigInteger.valueOf(1);
		}

		BigInteger results[] = new BigInteger[number+1];
		results[0] = BigInteger.valueOf(1);
		results[1] = BigInteger.valueOf(1);

		for (int i = 2; i <= number; i++) {
			results[i] = (BigInteger.valueOf(i)).multiply(results[i-1]);
		}
		
		return results[number];
	}
	
	public ArrayList<Calculation> getHistory() {
		return history;
	}
	
	public int calculateFactorial(int number) {
		if (number <= 1) {
			return 1;
		}
		
		return number * calculateFactorial(number-1); 
	}
}
