class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        //sliding window
        int sum = 0;
        for(int i=0; i<k; i++) {
            sum += cardPoints[i];
        }
        
        int n = cardPoints.length;
        int max = sum;
        
        //2-pointer
        int i = 0;
        while(i < k) {
            sum = sum - cardPoints[k-i-1] + cardPoints[n-i-1];
            max = Math.max(sum, max);
            i++;
        }
        
        return max;
        
    }
}
