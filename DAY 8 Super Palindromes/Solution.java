class Solution {
    public int superpalindromesInRange(String left, String right) {
        
        List<Long> palindrome = new ArrayList<Long>();
        
        Long leftNo = Long.parseLong(left);
        Long rightNo = Long.parseLong(right);
        
        int cnt = 0;
        
        for(long i=1; i<10; i++) {
            palindrome.add(i);
        }
        
        for(long i=1; i<10000; i++) {
            String leftPart = Long.toString(i);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            
            palindrome.add(Long.parseLong(leftPart + rightPart));
            
            for(int digit=0; digit<10; digit++) {
                palindrome.add(Long.parseLong(leftPart + digit + rightPart));
            }
        }
        
        for(long no : palindrome) {
            long squareNo = no * no;
            if(leftNo <= squareNo && rightNo >= squareNo && isPalindrome(Long.toString(squareNo))) {
                cnt++;
            }
        }
        
        return cnt;
        
    }
    
    private boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) return false;
            else {
                i++;j--;
            }
        }
        
        return true;
    }
    
}
