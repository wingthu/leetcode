//Given a set T of characters and a string S, find the minimum window in S which will contain all the characters in T in complexity O(n).

//eg,
//S = “ADOBECODEBANC”
//T = “ABC”

//Minimum window is “BANC”.


//found a window first
//after that, keep the window
class FindingMinWindow{
	public static char[] findWindow(char[] str, char[] pattern){
		int str_len = str.length;
		int pattern_len = pattern.length;
		//if(str_len == 0) return null;
		if(str_len == 0 || pattern_len == 0) return new char[0];
		int[] needToFind = new int[256];
		int count = 0;
		for(int i = 0; i < pattern_len; i++){
			needToFind[(int) pattern[i]]++;
			count++;
		}
		int begin_index = 0;
		int end_index = 0;
		int final_begin_index = 0;
		int final_end_index = 0;
		int min_window = str_len;
		boolean isBeginFound = false;
		//boolean isEndFound = false;
		int[] alreadyFind = new int[256];
		int local_count = 0;
		for(int i = 0; i < str_len; i++){
			char a = str[i];
			if(needToFind[(int) a] == 0) continue;
			else{
				if(!isBeginFound) {
					isBeginFound = true;
					begin_index = i;
				}
				alreadyFind[(int) a]++;
				end_index = i;
				if(alreadyFind[(int) a] <= needToFind[(int) a]){
					local_count++;
				}
				else{
					if(str[begin_index] == str[end_index]){
						int tmp_index = begin_index;
						char tmp = str[tmp_index];
						while(alreadyFind[(int) tmp] > needToFind[(int) tmp] || needToFind[tmp] == 0){
							if(alreadyFind[(int) tmp] > needToFind[(int) tmp]){
								alreadyFind[(int) tmp]--;
							}
							tmp_index++;
							tmp = str[tmp_index];
						}
						begin_index = tmp_index;
					}
				}
				if(local_count == count){
					int window_length = end_index - begin_index;
					if(window_length <= min_window){
						min_window = window_length;
						final_begin_index = begin_index;
						final_end_index = end_index;
					}
				}
			}
		}
		if(local_count < count) return new char[0];
		else{
			char[] window = new char[min_window + 1];
			for(int i = final_begin_index; i <= final_end_index; i++){
				window[i-final_begin_index] = str[i];
			}
			return window;
		}
	}
		public static void main(String[] args){
			String str = "CAABBDBADBCE";
			String pattern = "ABC";
			String sol = new String(findWindow(str.toCharArray(), pattern.toCharArray()));
			System.out.println(sol);
		}
}