//list
Collections.sort(list, Comparator.comparingInt(a -> a.get(0)));


//array
Arrays.sort(array, (a1, a2)-> Integer.compare(a1[0], a2[0]);


 Arrays.sort(trips, new Comparator<int[]>(){
     public int compare(int[] i1, int[] i2) {
         return i1[1] - i2[1];
     }
 });

class MyCompare implements Comparator<int[]>{
	public int compare(int[] int1, int[] int2){
		return int1[2]-int2[2];
	}
}
