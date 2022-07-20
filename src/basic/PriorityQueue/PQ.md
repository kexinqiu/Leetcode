//Pair / List
Queue<Pair<>> pq = new PriorityQueue<Pair<>>(Comparator.comparing(p->p.getKey())


//array
Queue<String> pq = new PriorityQueue<String>(new Comparator<String>(){
			@Override
			public int comapre(String s1, String s2){
				return s1.length()-s2.length();
			}
		}
)

Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[0], b[0])));