//hashmap缺点是 所需要的storage space一直会增长
//tc o(1)
//sc o(n)

class Logger {
	HashMap<String, Integer> map;

	public Logger() {
		map = new HashMap<String, Integer>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		if(map.containsKey(message)) {
			if(timestamp - map.get(message)<10) return false;
			else {
				map.put(message, timestamp);
				return true;
			}
		}
		else {
			map.put(message, timestamp);
			return true;
		}
	}
}

//use set+queue
//tc: o(n)
//sc: o(n) - o(2n)

class Logger {
	private Set<String> messages;
	private Queue<Log> queue;

	public Logger() {
		messages = new HashSet<String>();
		queue = new LinkedList<>();
	}

	public boolean shouldPrintMessage(int timestamp, String message) {
		//确保queue和set中都去除了timestamp差>=10的message
		//这样如果新加入的message 已经存在于set中说明，timestamp差一定<10
		while(!queue.isEmpty() && (timestamp - queue.peek().timestamp>=10)){
			messages.remove(queue.poll().message);
		}

		if(messages.contains(message)) return false;

		queue.offer(new Log(timestamp, message));
		messages.add(message);
		return true;
	}
}

class Log{
	String message;
	int timestamp;

	public Log(int timestamp, String message){
		this.timestamp = timestamp;
		this.message = message;
	}
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
