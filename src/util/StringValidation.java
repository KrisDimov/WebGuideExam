package util;

public class StringValidation {

	public static boolean isEmpty(String source) {
		if (source == null) {
			return true;
		}
		if (source.trim().length() == 0) {
			return true;
		}
		return false;
	}
	
}
