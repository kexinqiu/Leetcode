//始终去有序的那个范围内去找target，不在就去另一半无序的找，但是要将无序再次划分成有序然后再找
//先判断出mid在哪个部分

class SearchRotatedSortedArray {
     public int search(int[] nums, int target) {

         if(nums.length==1 && nums[0]!=target) return -1;

         int l = 0;
         int r = nums.length-1;

         while(l<=r){

             int mid = l + (r-l)/2;

             if(nums[mid]==target) return mid;

             if(nums[mid]<nums[r]){//有序部分为后半段，在后半段判断
                 if(target>nums[mid] && target<=nums[r]){
                     l = mid+1;
                 }else{
                     r = mid-1;
                 }
             }

             else{//前半部分有序，在前半段判断
                 if(target<nums[mid] && target>=nums[l]){
                     r = mid-1;
                 }else{
                     l = mid+1;
                 }
             }

         }
         return -1;
     }
 }