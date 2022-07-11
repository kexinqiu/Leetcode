//抽象成一个tree

//DFS recursion
//tc: o(n)
//sc: o(n)
class Solution {
	Map<Integer, Employee> map = new HashMap<>();

	public int getImportance(List<Employee> employees, int id) {
		for(Employee e : employees){
			map.put(e.id, e);
		}
		return getValue(id);
	}

	public int getValue(int id){
		Employee master = map.get(id);
		int total = master.importance;

		for(int o : master.subordinates){
			total += getValue(o);
		}
		return total;
	}
}

//BFS
class Solution {
	Map<Integer, Employee> map = new HashMap<>();

	public int getImportance(List<Employee> employees, int id) {
		for(Employee e: employees){
			map.put(e.id, e);
		}

		Queue<Employee> queue = new LinkedList<>();

		queue.offer(map.get(id));

		int total = 0;

		while(!queue.isEmpty()){
			Employee e = queue.poll();

			//operation
			total += e.importance;

			//traverse all child nodes
			for(int i : e.subordinates){
				queue.offer(map.get(i));
			}
		}
		return total;

	}
}
