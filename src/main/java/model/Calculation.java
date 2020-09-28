package model;

import java.math.BigInteger;

/**
 * Represents a calculation with the number and its factorial
 * 
 * @author Maria Eduarda de Melo Hang
 */
public class Calculation {
	private int number;
	private BigInteger result;

	public Calculation(int number, BigInteger result) {
		this.number = number;
		this.result = result;
	}

	public int getNumber() {
		return number;
	}

	public BigInteger getResult() {
		return result;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void setResult(BigInteger result) {
		this.result = result;
	}

}
