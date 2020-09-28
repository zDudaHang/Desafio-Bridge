package util;

import java.math.BigInteger;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * A utility class to format the factorial result
 * 
 * @author Maria Eduarda de Melo Hang
 */
public class Formatter {
	private final static NumberFormat FORMATTER = new DecimalFormat("00.###E0",
			DecimalFormatSymbols.getInstance(Locale.ROOT));

	/**
	 * Returns the result in scientific notation
	 * 
	 * @param result The factorial result
	 * @return The result in scientific notation if the result is bigger than 1000
	 */
	public static String formatResult(BigInteger result) {
		if (result.compareTo(BigInteger.valueOf(1000)) == 1) {
			return FORMATTER.format(result);
		}

		return String.valueOf(result);
	}
}
