package xiaoping.zillow;

import java.text.ParseException;

import junit.framework.Assert;

import org.junit.Test;

/**
 * Test case for StringUtilization.
 * 
 * @author iamrick86
 * @since 05/24/2014
 */
public class StringUtilizationTest {

	/**
	 * Test for positive number.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void positiveIntegerTest() throws ParseException {
		Assert.assertEquals(234, StringUtilization.stringToLong("234"));
	}

	/**
	 * Test for negative number.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void negativeIntegerTest() throws ParseException {
		Assert.assertEquals(-234, StringUtilization.stringToLong("-234"));
	}

	/**
	 * When input string is empty, treat as 0.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void emptyTest() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong(""));
	}

	/**
	 * When input string only contains "-", treat as 0.
	 * 
	 * @throws ParseException
	 *             when input string only contains "-", treat as '-0'
	 */
	@Test
	public void negativeEmptyTest() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong("-"));
	}

	/**
	 * Test for input string contains "0".
	 * 
	 * @throws ParseException
	 */
	@Test
	public void zeroTest() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong("0"));
	}

	/**
	 * Test for input string contains more than one zero before other digit.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void zeroTest1() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong("00"));
	}

	/**
	 * Test for input string contains more than one zero in the beginning of the
	 * string.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void zeroTest2() throws ParseException {
		Assert.assertEquals(5, StringUtilization.stringToLong("005"));
	}

	/**
	 * Test for input string not only contains "-" but also contains more than
	 * one "zero" after "-".
	 * 
	 * @throws ParseException
	 */
	@Test
	public void zeroTest3() throws ParseException {
		Assert.assertEquals(-5, StringUtilization.stringToLong("-005"));
	}

	/**
	 * Test for zero which contains minus in the beginning.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void minusZeroTest() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong("-0"));
	}

	/**
	 * Test for input string which contains "-" and more than one zero.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void minusZeroTest2() throws ParseException {
		Assert.assertEquals(0, StringUtilization.stringToLong("-00"));
	}

	/**
	 * Test input string which is equal to the maximum long value.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void maxTest() throws ParseException {
		long max = Long.MAX_VALUE;
		Assert.assertEquals(max, StringUtilization.stringToLong("" + max));
	}

	/**
	 * Test for input string which contains minimum value.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void minTest() throws ParseException {
		long min = Long.MIN_VALUE;
		Assert.assertEquals(min, StringUtilization.stringToLong("" + min));
	}

	/**
	 * Test for input string which is overflow to convert to be a long value.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void overflowTest() throws ParseException {

		Assert.assertEquals(Long.MIN_VALUE + 1,
				StringUtilization.stringToLong("9223372036854775809"));
	}

	/**
	 * Test for input string which is underflow to convert to be a long value.
	 * 
	 * @throws ParseException
	 */
	@Test
	public void underflowTest() throws ParseException {

		Assert.assertEquals(Long.MAX_VALUE - 1,
				StringUtilization.stringToLong("-9223372036854775810"));
	}

	/**
	 * Test for input string which contains empty space.
	 * 
	 * @throws ParseException
	 *             when meet space in the input string, throws it
	 */
	@Test(expected = ParseException.class)
	public void spaceTest() throws ParseException {
		StringUtilization.stringToLong("  234");
	}

	/**
	 * Test for input string contains "*" before digit.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void startTest1() throws ParseException {
		StringUtilization.stringToLong("*1");
	}

	/**
	 * Test for input string contains "*" after digit.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void startTest2() throws ParseException {
		StringUtilization.stringToLong("1*");
	}

	/**
	 * Test for input string contains "," before digit.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void commaTest1() throws ParseException {
		StringUtilization.stringToLong(",1");
	}

	/**
	 * Test for input string contains "," after digit.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void commaTest2() throws ParseException {
		StringUtilization.stringToLong("1,");
	}

	/**
	 * Test for input string contains two minus.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void minusTest() throws ParseException {
		StringUtilization.stringToLong("--1");
	}

	/**
	 * Test for input string contains a space after minus.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void minusTest1() throws ParseException {
		StringUtilization.stringToLong("- 1");
	}

	/**
	 * Test for input string contains plus.
	 * 
	 * @throws ParseException
	 */
	@Test(expected = ParseException.class)
	public void plusTest() throws ParseException {
		StringUtilization.stringToLong("+1");
	}

}
