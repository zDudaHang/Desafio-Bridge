package service;

import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import model.Calculation;

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
	
	public int calculateFactorial(int number) {
		if (number <= 1) {
			return 1;
		}
		
		return number * calculateFactorial(number-1); 
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
	
	public static String formatResult(BigInteger result) {
		String formattedResult = String.valueOf(result);
		if (result.compareTo(BigInteger.valueOf(1000)) == 1) {
			NumberFormat formatter = new DecimalFormat("00.###E0",DecimalFormatSymbols.getInstance(Locale.ROOT));
			formattedResult = formatter.format(result);
		}
		return formattedResult;
	}
	
	public ArrayList<Calculation> getHistory() {
		return history;
	}
}
