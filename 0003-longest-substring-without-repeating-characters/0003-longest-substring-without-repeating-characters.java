class Solution {
    public int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int max_sub = 0;
    int n = s.length();
    int left = 0;
    for(int right = 0; right < n; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            max_sub = Math.max(max_sub,set.size());
    }
    return max_sub;
    }
}