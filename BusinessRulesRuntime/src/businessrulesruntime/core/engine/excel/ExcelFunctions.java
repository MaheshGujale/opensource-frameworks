package businessrulesruntime.core.engine.excel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.log4j.Logger;
import org.joda.time.LocalDate;

public class ExcelFunctions {
	private static Logger logger = Logger.getLogger(ExcelFunctions.class);

	/**
	 * function used to find the sum of arguments
	 * 
	 * @param params
	 *            - Variable argument
	 * @return
	 */
	public static Object SUM(int[] params) {
		Integer lRet = 0;

		int size = params.length;
		for (int index = 0; index < size; index++) {
			lRet = lRet + params[index];
		}

		return String.valueOf(lRet);
	}

	/**
	 * Used to convert the string values into integer
	 * 
	 * @param pInput
	 * @return
	 */
	public static Integer INT(String pInput) {
		if (pInput != null) {
			int lConvertedValue = Integer.parseInt(pInput);
			return lConvertedValue;
		}
		return 0;
	}

	/**
	 * 
	 * LUHN of card number
	 * 
	 * @param pInput
	 * @return
	 */
	public static boolean LUHN(String pInput) {
		int sum = 0;
		boolean alternate = false;
		for (int i = pInput.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(pInput.substring(i, i + 1));
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		return (sum % 10 == 0);
	}

	/**
	 * Used to convert the string values into float
	 * 
	 * @param pInput
	 * @return
	 */
	public static Float FLOAT(String pInput) {
		if (pInput != null) {
			float lConvertedValue = Float.parseFloat(pInput);
			return lConvertedValue;
		}
		return Float.valueOf(0);
	}

	/**
	 * Used to get the substring
	 * 
	 * @param value
	 * @param pStartPosition
	 * @param pEndPosition
	 * @return
	 */
	public static String SUBSTR(String value, int pStartPosition, int pEndPosition) {
		return value.substring(pStartPosition - 1, pEndPosition);
	}

	/**
	 * Used to get the length oof a string
	 * 
	 * @param value
	 * @return
	 */
	public static Integer LENGTH(String value) {
		return value.length();
	}

	/**
	 * Used to concatenate strings
	 * 
	 * @param pField
	 * @param pConcatVal
	 * @param pPadingType
	 * @return
	 */
	public static String CONCAT(String pField, String pConcatVal, String pPadingType) {
		String lConcatinatedValue = "";
		if (pPadingType.equalsIgnoreCase("left")) {
			lConcatinatedValue = pConcatVal + pField;
			return lConcatinatedValue;
		}
		if (pPadingType.equalsIgnoreCase("right")) {
			lConcatinatedValue = pField + pConcatVal;
			return lConcatinatedValue;
		}
		return lConcatinatedValue;
	}

	/**
	 * Used to concatenate strings
	 * 
	 * @param pField
	 * @param params
	 * @return
	 */
	public static String CONCATENATE(String[] params) {
		StringBuilder strBuilder = new StringBuilder();

		int size = params.length;
		for (int index = 0; index < size; index++) {
			strBuilder.append(params[index]);
		}
		return strBuilder.toString();
	}

	public static String STR(Object param1) {
		if (param1 != null) {
			return param1.toString();
		}
		return "";
	}

	/**
	 * gives the position of character or substring in a string
	 * 
	 * @param pField
	 * @param indChar
	 * @return
	 */
	public static Integer INDEXOF(String pField, String indChar) {
		return pField.indexOf(indChar);
	}

	/**
	 * Converts a date in one format to another format
	 * 
	 * @param pField
	 * @param pIncomingFormat
	 * @param pOutgoingFormat
	 * @return
	 */
	public static String DATEFORMAT(String pField, String pIncomingFormat, String pOutgoingFormat) {

		String lOutputDate = null;
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(pIncomingFormat);
		try {
			date = dateFormat.parse(pField);
		} catch (Exception e) {
			logger.error(e);
		}
		dateFormat = new SimpleDateFormat(pOutgoingFormat);
		lOutputDate = dateFormat.format(date);
		return lOutputDate;
	}

	public static Long LONG(String pInput) {
		if (pInput != null) {
			long lConvertedValue = Long.parseLong(pInput);
			return lConvertedValue;
		}
		return Long.valueOf(0);
	}

	public static Double DOUBLE(String pInput) {
		if (pInput != null) {
			double lConvertedValue = Double.parseDouble(pInput);
			return lConvertedValue;
		}
		return Double.valueOf(0);
	}

	public static String MID(String value, int pos, int len) {
		return StringUtils.mid(value, pos - 1, len);
	}

	public static String LEFT(String value, int len) {
		return StringUtils.left(value, len);
	}

	public static String RIGHT(String value, int len) {
		return StringUtils.right(value, len);
	}

	public static String SUBSTITUTE(String value, String repl, String with) {
		return StringUtils.replace(value, repl, with);
	}

	public static String REPLACE(String value, int start, int len, String overlay) {
		return StringUtils.overlay(value, overlay, start - 1, start - 1 + len);
	}

	public static Boolean EXACT(Object _a, Object _b) {
		return _a == null ? _b == null : _a.equals(_b);
	}

	public static Integer SEARCH(String _what, String _within, int _startingAt) {
		if (_within == null || _within.equals(""))
			fun_ERROR("#VALUE! because no result in SEARCH");
		if (_what == null || _what.equals(""))
			return 1;
		if (_startingAt > _within.length())
			fun_ERROR("#VALUE! because start is past end in SEARCH");

		final Pattern pattern = patternFor(_what.toLowerCase());
		final Matcher matcher = pattern.matcher(_within.toLowerCase());
		if (matcher.find(_startingAt - 1)) {
			return matcher.start() + 1;
		} else {
			throw new RuntimeException("#VALUE! because no result in FIND");
		}
	}

	/**
	 * Strips leading and trailing blanks, and collapses runs of multiple blanks
	 * to just one.
	 */
	public static String TRIM(String value) {
		return StringUtils.trim(value);
	}

	public static Date NOW() {
		return new Date();
	}

	public static Date TODAY() {
		return LocalDate.now().toDate();
	}

	public static Object TODATE(String strValue, String pattern, String timeZone) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
		try {
			return sdf.parse(strValue);
		} catch (ParseException exp) {
			throw new RuntimeException(exp);
		}
	}

	public static boolean ISVALIDDATE(String format, String date) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		Date testDate = null;
		try {
			testDate = simpleDateFormat.parse(date);
		} catch (ParseException e) {
			return false;
		}
		if (!simpleDateFormat.format(testDate).equals(date)) {
			return false;
		}
		return true;
	}

	public static boolean ISNUMBER(String value) {
		return NumberUtils.isNumber(value);
	}

	public static boolean ISALPHANUMERIC(String value) {
		return StringUtils.isAlphanumeric(value);
	}

	public static boolean ISPATTERN(String value) {
		return Pattern.matches("[a-zA-Z0-9#$]*", value);
	}

	public static boolean ISALPHA(String value) {
		return StringUtils.isAlpha(value);
	}

	public static boolean ISEMPTY(String value) {
		return StringUtils.isEmpty(value);
	}

	public static boolean ISBLANK(String value) {
		return StringUtils.isBlank(value);
	}

	public static boolean ISVALID(String pInput, String patternString) {
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(pInput);
		if (matcher.matches()) {
			return true;
		}
		return false;
	}

	private static final Pattern patternFor(String _stringWithWildcards) {
		final StringBuilder src = new StringBuilder(); // using "(?i)" has
		// trouble with umlauts
		int i = 0;
		while (i < _stringWithWildcards.length()) {
			char c = _stringWithWildcards.charAt(i++);
			switch (c) {
			case '*':
				src.append(".*");
				break;
			case '?':
				src.append(".");
				break;
			case '~':
				if (i < _stringWithWildcards.length()) {
					final char cc = _stringWithWildcards.charAt(i++);
					appendLiteral(src, cc);
				} else {
					appendLiteral(src, c);
				}
				break;
			default:
				appendLiteral(src, c);
			}
		}
		return Pattern.compile(src.toString());
	}

	private static final void appendLiteral(final StringBuilder _src, char _char) {
		_src.append("\\u");
		_src.append(Integer.toHexString(0x10000 | _char).substring(1));
	}

	public static String LOWER(String value) {
		return value.toLowerCase();
	}

	public static String UPPER(String value) {
		return value.toUpperCase();
	}

	public static void fun_ERROR(String _message) {
		throw new RuntimeException(_message);
	}

	public static Boolean STARTSWITH(String _within, String _what, int start) {
		return _within.startsWith(_what, start);
	}

	public static boolean NOT(boolean value) {
		return !value;
	}

	public static int INTVAL(AtomicInteger value) {
		return value.get();
	}

	public static int INTINC(AtomicInteger value, int incrementVal) {
		return value.addAndGet(incrementVal);
	}

	public static long LONGVAL(AtomicLong value) {
		return value.get();
	}

	public static long LONGINC(AtomicLong value, double incrementVal) {
		return value.addAndGet((long) incrementVal);
	}

	public static double DBLVAL(Double value) {
		synchronized (value) {
			return value.doubleValue();
		}
	}

	public static double DBLINC(Double value, double incrementVal) {
		synchronized (value) {
			value = value + incrementVal;
		}
		return value;
	}

	public static String LEFTPAD(String value, int size) {
		return StringUtils.leftPad(value, size);
	}

	public static String LEFTPAD(String value, int size, char padChar) {
		return StringUtils.leftPad(value, size, padChar);
	}

	public static String LEFTPAD(String value, int size, String padString) {
		return StringUtils.leftPad(value, size, padString);
	}

	public static String RIGHTPAD(String value, int size) {
		return StringUtils.rightPad(value, size);
	}

	public static String RIGHTPAD(String value, int size, char padChar) {
		return StringUtils.rightPad(value, size, padChar);
	}

	public static String RIGHTPAD(String value, int size, String padString) {
		return StringUtils.rightPad(value, size, padString);
	}

	public static boolean ISNULL(Object value) {
		return (value == null);
	}
}