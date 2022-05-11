class Solution {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if(s.length()<=3 || s.length()>=13) return res;
		backtrack(res, new ArrayList<>(), s, 0);
		return res;
	}
	//我们需要不断将string进行分割，长度1-3
	//start是每小节的起点
	private void backtrack(List<String>res, List<String> str, String s, int start){
		//valid
		if(str.size()==4 && start==s.length()){
			String tmp = str.get(0);
			for(int i=1;i<str.size();i++){
				tmp = tmp + '.' + str.get(i);
			}
			res.add(tmp);
			return;
		}
		//invalid， 剩余字符
		if(str.size()==4 && start<s.length()){
			return;
		}
		//len是每小节的长度
		for(int len=1;len<=3;len++){
			//保证后续s.substring(begin,begin+len)合法
			if(start+len>s.length()){
				break;
			}
			//截取并保存字符串
			String currentStr = s.substring(start, start+len);
			//保证不包含0开头但非0字符串
			if(currentStr.charAt(0)=='0' && len!=1){
				break;
			}
			//截取的字符串长度为3时，大小不能超过255
			if(len==3 && Integer.parseInt(currentStr)>255){
				break;
			}
			str.add(currentStr);
			backtrack(res, str, s, start+len);
			str.remove(str.size()-1);
		}
	}
}