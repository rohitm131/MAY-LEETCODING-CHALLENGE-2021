class Solution {
    public int jump(int[] nums) {
      int n = nums.length;
      int jumps = 1;
      
      if(n == 1 || nums[0] == 0) return 0;
      
      int farthest = nums[0];
      int cur = nums[0];
      
      for(int i=0; i<n; i++) {
        if(i == n-1) return jumps;
        
        farthest = Math.max(farthest, i+nums[i]);
        if(i == cur) {
          jumps++;
          cur = farthest;
        }
        
      }
      
      return jumps;
      
    }
}
