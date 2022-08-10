//tc:O(n∗m)
//sc:O(n∗m)
class Solution {
	public int[][] updateMatrix(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		Queue<int[]> queue = new LinkedList<>();

		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(mat[i][j]==0){
					queue.add(new int[]{i, j});
				}else{
					mat[i][j] = -1;
				}
			}
		}

		while(!queue.isEmpty()){
			int size = queue.size();

			for(int i=0;i<size;i++){
				int[] tmp = queue.poll();

				int r = tmp[0];
				int c = tmp[1];

				for(int[] d:directions){
					int newR = r + d[0];
					int newC = c + d[1];

					if(newR>=0 && newR<n &&
						newC>=0 && newC<m &&
						mat[newR][newC]==-1){
						mat[newR][newC] = mat[r][c]+1;
						queue.add(new int[]{newR, newC});

					}
				}
			}
		}
		return mat;

	}
}