class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        
        HashSet<Integer> s = new HashSet<>();
        int sum = 0, max = 0;
        int start = 0, end = 0;
        
        while(end < nums.length) {
            int num = nums[end];
            if(!s.contains(num)) {
                s.add(num);
                sum += num;
                max = Math.max(max, sum);
                end++;
            } else {
                s.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
        }
        return max;
    }
}
