package service;

import model.Calculation;
import java.util.ArrayList;

public class CalculatorService {
	private ArrayList<Calculation> history = null;
	
	public CalculatorService() {
		history = new ArrayList<>();
	}
	
	public int calculate(int number) {
		int result = calculateFactorial(number);
		history.add(new Calculation(number,result));
		
		return result;
	}
	
	public int calculateFactorial(int number) {
		if (number <= 1) {
			return 1;
		}
		
		return number * calculateFactorial(number-1); 
	}
	
	public ArrayList<Calculation> getHistory() {
		return history;
	}
}
