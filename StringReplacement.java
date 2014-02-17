public class StringReplacement{
	// check if str matches the pattern from the first letter
	// none of the strings could be null
	private static boolean isMatch(String str, String pattern){
		if(str == null || pattern == null) return false;
		int str_len = str.length();
		int pattern_len = pattern.length();
		if(str_len < pattern_len) return false;
		else if(pattern_len == 0) return true;
		else if(str.charAt(0) != pattern.charAt(0)) return false;
		else return isMatch(str.substring(1, str_len), pattern.substring(1, pattern_len));
	}
	public static String replaceString(String str, String pattern, String replace){
		if(str == null || pattern == null || replace == null) throw new NullPointerException();
		String copy = "";
		boolean isContinuous = false;
		int str_len = str.length();
		int pattern_len = pattern.length();
		if(pattern_len == 0) pattern_len = 1;
		int i = 0;
		while(i < str_len){
			String substr = str.substring(i, str_len);
			if(isMatch(substr, pattern) && !isContinuous){
				copy = copy + replace;
				isContinuous = true;
				i += pattern_len;
			}
			else if(isMatch(substr, pattern)){
				i += pattern_len;
			}
			else{
				copy = copy + str.charAt(i);
				i++;
				isContinuous = false;
			}
		}	
		return copy;
	}
	public static void main(String[] args){
		String str = "aaaaabbbbb";
		String pattern = "a";
		String replace = "X";
		String result = replaceString(str, pattern, replace);
		System.out.println(result);
	}
}