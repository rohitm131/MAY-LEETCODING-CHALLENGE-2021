class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        
        String res = help(pattern);
        
        List<String> ans = new ArrayList<String>();
        
        for (String word : words)
            if (res.equals(help(word))) ans.add(word);
        
        return ans;
        
    }
    
    public String help(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        String p = "";
        
        for(int i=0; i<s.length(); i++) {
            map.putIfAbsent(s.charAt(i), map.size());
            p += map.get(s.charAt(i));
        }
        return p;
    }
    
}
