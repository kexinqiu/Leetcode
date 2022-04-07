import java.util.Arrays;
import java.util.Comparator;

//tc:O(nlogn)

class Solution {
	public String[] reorderLogFiles(String[] logs) {
		//Arrays.sort(logs, (log1,log2)->{
		//
	    //});
		Comparator<String> myComp = new Comparator<String>(){
			@Override
			public int compare(String log1, String log2){
				//split each log into two parts [identifier, content]
				String[] split1 = log1.split(" ", 2);
				String[] split2 = log2.split(" ", 2);
				//check if is digit
				boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
				boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
				//case 1: both are letter-log
				if(!isDigit1 && !isDigit2){
					int cmp = split1[1].compareTo(split2[1]);
					//logs of same content, compare the identifiers
					if(cmp==0) return split1[0].compareTo(split2[0]);
					else return cmp;
				}
				//case 2: one of the logs is digit-log
				else if(isDigit1 && !isDigit2){
					return 1;
				}
				else if(!isDigit1 && isDigit2){
					return -1;
					//case 3: both are digit-log
				}else{
					return 0;
				}
			}
		};
		Arrays.sort(logs, myComp);
		return logs;
	}
}