//N be the total number of integers within the nested list,
//L be the total number of lists within the nested list,
//D be the maximum nesting depth

//dfs
//constructor:
//tc:o(N+L)
//sc:o(N+D) N for res list, D for recursion
public class NestedIterator implements Iterator<Integer> {

	private List<Integer> res = new ArrayList<>();
	int position = 0;

	public NestedIterator(List<NestedInteger> nestedList) {
		dfs(nestedList);
	}

	private void dfs(List<NestedInteger> nestedList){
		for(NestedInteger nested : nestedList){
			if(nested.isInteger()){
				res.add(nested.getInteger());
			}else{
				dfs(nested.getList());
			}
		}
	}

	@Override
	public Integer next() {
		if(hasNext()){
			return res.get(position++);
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		if(position<res.size()) return true;
		return false;
	}
}

//deque
//N be the total number of integers within the nested list,
//L be the total number of lists within the nested list,
//D be the maximum nesting depth
//constructor:
//tc:o(N+L)
//sc:o(N+L)
public class NestedIterator implements Iterator<Integer> {

	Deque<NestedInteger> deque = new ArrayDeque<>();

	public NestedIterator(List<NestedInteger> nestedList) {
		prepare(nestedList);
	}

	private void prepare(List<NestedInteger> nestedList){
		for(int i=nestedList.size()-1;i>=0;i--){
			deque.push(nestedList.get(i));
		}
	}

	@Override
	public Integer next() {
		if(hasNext()){
			return deque.pop().getInteger();
		}
		return null;
	}

	@Override
	public boolean hasNext() {
		while(!deque.isEmpty() && !deque.peek().isInteger()){
			List<NestedInteger> list = deque.pop().getList();
			prepare(list);
		}
		return !deque.isEmpty();
	}
}