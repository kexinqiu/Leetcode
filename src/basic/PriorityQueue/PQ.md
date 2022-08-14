//Pair / List
Queue<Pair<>> pq = new PriorityQueue<Pair<>>(Comparator.comparing(p->p.getKey())

//map
PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
(a,b)-> a.getValue()==b.getValue()?b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
);   //a.getValue()-b.getValue() =》 从小到大
     //b.getKey().compareTo(a.getKey()) =》从大到小


//array
Queue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
			@Override
			public int comapre(String s1, String s2){
				return s1.length()-s2.length();
			}
		}
)

Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));