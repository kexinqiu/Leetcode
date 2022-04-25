//tc: o(n^2)


//return int, so there is no need to get all results
//get the total number is enough
//use .size()
//cannot use Set<int[]>, because arrays are treated the same only if they have the same memory address
class Solution {
	public int countLatticePoints(int[][] circles) {
		HashSet<String> set = new HashSet<>();
		for(int[] circle:circles){
			int x = circle[0];
			int y = circle[1];
			int r = circle[2];

			for(int i=x-r;i<=x+r;i++){
				for(int j=y-r;j<=y+r;j++){
					if((x-i)*(x-i)+(y-j)*(y-j)<=r*r){
						set.add(i+" "+j);
					}
				}
			}
		}
		return set.size();
	}
}