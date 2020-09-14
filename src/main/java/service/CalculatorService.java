package service;

import java.math.BigInteger;
import java.util.ArrayList;

import model.Calculation;

/** A service class to the web application
 * Purpose: Calculates the factorial of a given number and stores the calculations
 * @author Maria Eduarda de Melo Hang
*/
public class CalculatorService {
	
	private ArrayList<Calculation> history = null;
	
	public CalculatorService() {
		history = new ArrayList<Calculation>();
	}
	
	/** Calculates the factorial and stores the calculation in history
	 * This method only stores the calculation if the results is bigger than -1
	 * @param number The number to calculate the factorial
	 * @return The factorial of number
	 * */
	public BigInteger calculate(int number) {
		BigInteger result = calculteFactorialTopDown(number);
		
		// Testing if the result is bigger than -1
		if (result.compareTo(BigInteger.valueOf(-1)) == 1) {
			history.add(new Calculation(number,result));
		}
		
		return result;
	}
	
	/** Calculates the factorial of a number using the top-down algorithm (Dynamic Programming)
	 * @param number The number to calculate the factorial
	 * @return If the number is equal or bigger than 0, returns the factorial of number, else returns -1
	 * indicating an invalid value for the parameter
	 * */
	public BigInteger calculteFactorialTopDown(int number) {
		// If the number is negative, return the -1 to indicate a error
		if (number < 0) {
			return BigInteger.valueOf(-1);
		}
		
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

}
