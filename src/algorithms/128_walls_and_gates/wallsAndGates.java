//和leetcode 417 思路相似，从目标地开始往外遍历，即从门开始往边界遍历
//value不断+1， 若遇到比value值更小的，则意味着遇到了gate或wall，需要return
//保留值更小的路径，比如两条路径经过同一个cell，保留较小的value，也就是说只有当原来的value值比当前value大时，才需要重置

//rooms[ i ][ j ]<=d && d != 0 solves 3 problems: (1) do not update walls & gates (-1 & 0s); (2) distinguish the visited and not-visited nodes (the visited can only have smaller or equal distance); (3) set a smaller value

//dfs
//tc: o(n)
//sc: o(1)
 class Solution{
     public void wallsAndGates(int[][] rooms) {
         if(rooms == null || rooms.length == 0) return;
         for (int i = 0; i < rooms.length; i++)
             for (int j = 0; j < rooms[0].length; j++)
                 //确保从gate开始
                 if (rooms[i][j] == 0) dfs(rooms, i, j, 0);
     }

     private void dfs(int[][] rooms, int i, int j, int d) {
         if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[0].length || (rooms[i][j] <= d && d!=0)) return;
         rooms[i][j] = d;

         dfs(rooms, i - 1, j, d + 1);
         dfs(rooms, i + 1, j, d + 1);
         dfs(rooms, i, j - 1, d + 1);
         dfs(rooms, i, j + 1, d + 1);
     }
  }

//bfs
//tc o(n) n is the number of cells 1. iterate over all cells and add gate to queue 2.look at each cell once
//sc o(n) size of queue
class Solution{

	public void wallsAndGates(int[][] rooms) {

		if(rooms == null || rooms.length == 0) return;

		int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < rooms.length; i++){
			for (int j = 0; j < rooms[0].length; j++){
				//确保从gate开始
				if (rooms[i][j] == 0) queue.offer(new int[]{i , j});
			}
		}

		while(!queue.isEmpty()){
			int[] tmp = queue.poll();
			for(int[] d: directions){
				int newI = tmp[0] + d[0];
				int newJ = tmp[1] + d[1];

				if(newI>=0 && newI<rooms.length && newJ>=0 && newJ<rooms[0].length && rooms[newI][newJ]>rooms[tmp[0]][tmp[1]]){
					rooms[newI][newJ] = rooms[tmp[0]][tmp[1]] + 1;
					queue.offer(new int[] {newI, newJ});
				}
			}
		}
	}
}