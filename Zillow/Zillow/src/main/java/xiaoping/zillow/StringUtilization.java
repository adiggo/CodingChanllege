package xiaoping.zillow;

import java.text.ParseException;

/**
 * 
 * StringUtilization for Question 1.
 * 
 * StringUtilization provides a method to convert a string to long value. </p>
 * Method to solve this problem is simply easy: find the char in each index, and
 * sum them together to get the real numeric value.
 * 
 * And there some situation we need to take into consideration: 1. We have not
 * considered much of overflow. 2. character other than "0 to 9 and '-'" are not
 * valid. 3. empty strings and string only with "-" is equal to 0 in our
 * algorithm.
 * 
 * @author Xiaoping Li
 * @since 05/25/2014
 * @version 1.7
 */
public class StringUtilization {
	/**
	 * Convert a string to a long value.
	 * 
	 * @param s
	 *            A string which contains digits which need to be converted
	 * @return Numeric value of string
	 * @throws ParseException
	 *             that invalid character in the input string
	 */
	public static long stringToLong(String s) throws ParseException {
		// we need to first know whether the string is negative
		boolean isNegative = false;
		// change string s if the input string contains '-'
		if (s.length() > 0 && s.charAt(0) == '-') {
			isNegative = true;
			s = s.substring(1);
		}

		long longValue = 0;

		for (int i = 0; i < s.length(); i++) {
			longValue *= 10;
			int indexValue = charToInt(s.charAt(i), i);
			if (isNegative) {
				longValue -= indexValue;
			} else {
				longValue += indexValue;
			}
		}
		return longValue;
	}

	/**
	 * 
	 * charToInt provides the way to convert a char to integer. If the input is
	 * not valid digit char, the method will print the error message.
	 * 
	 * @param c
	 *            Input character need to be converted.
	 * @param index
	 *            location of the character in the input string.
	 * @return Integer or throws the exception based on the input character.
	 * @throws ParseException
	 */
	private static int charToInt(char c, int index) throws ParseException {

		if (c >= '0' && c <= '9') {
			return (c - '0'); // since the default is ASCII, so we can use it to
								// get the corresponding value.
		}
		throw new ParseException("Illegal character is '" + c + "'", index);

	}

}
