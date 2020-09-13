package model;

public class Calculation {
	private int number;
	private int result;
	
	public Calculation(int number, int result) {
		this.number = number;
		this.result = result;
	}
	
	public int getNumber() { 
		return number;
	}
	
	public int getResult() {
		return result;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void setResult(int result) {
		this.result = result;
	}
}
