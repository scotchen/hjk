package utils;


public class StringUtil {

    public static final String EMPTY_STRING = "";

    public String nullToEmpty(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    public static String defaultIfNull(String str) {
        return (str == null) ? EMPTY_STRING : str;
    }

    public static String defaultIfNull(String str, String defaultStr) {
        return (str == null) ? defaultStr : str;
    }

    public static boolean isEmpty(String str) {
        return ((str == null) || (str.length() == 0));
    }

    public static boolean isNotEmpty(String str) {
        return ((str != null) && (str.length() > 0));
    }

    public static boolean isBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return true;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNotBlank(String str) {
        int length;
        if ((str == null) || ((length = str.length()) == 0)) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }


}
