public class _minWindow{
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];
        int count = t.length();

        for(char c: t.toCharArray()){
            freq[c]++;
        }

        int start = 0, end = 0, minLen = Integer.MAX_VALUE, i = 0;

        char[] charS = s.toCharArray();

        while(end < charS.length){
            if(freq[charS[end++]]-- > 0){
                count--;
            }

            while(count == 0){
                if(end - start < minLen){
                    i=start;
                    minLen = end - start;
                }

                if(freq[charS[start++]]++ == 0){
                    count++;
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" :
                s.substring(i, i+minLen);
    }
}