public class _reverseWords {

    /*
     * 1. s.trim() is used to trim spaces
     * 2. s.trim().split("\\s+"): trims the words that are seorated by 1 spaces or multiple space in string
     * 
     */
    public static String reverseWords1(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder ans = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            ans.append(words[i]);
            if (i != 0) {
                ans.append(" ");
            }
        }
        return ans.toString();
    }

    /*
     * Steps:
     * 
     * 1. Use s.trim() to remove extra spaces from the string
     * 2. Now we will count the spaces between the words and create an array words[n+1]
     * 3. Iterate over the stringn from i to s.length()  and seprate the words
     * 4. Now Iterate the words array from n= words.length - 1 to 0 and append the words to ans
     *    if i>0 only then append " "
     */
    public static String reverseWords2(String s) {
        // removes extra spaces from start of string and end of the string
        s=s.trim();

        //count extra spaces between the words
        int n = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                n++;
            }
        }

        //No. of words in S will be n+1
        String[] words = new String[n+1];
        int j = 0;
        for(int i=0; i<s.length(); i++){
            String word = "";
            while(i < s.length() && s.charAt(i) != ' '){
                word += s.charAt(i);
                i++;
            }
            words[j] = word;
            j++;
        }

        // Revesing the string
        StringBuilder ans = new StringBuilder();
        for(int i= words.length - 1; i>=0; i--){
            if(words[i] == ""){
                continue;
            }
            ans.append(words[i]);
            if(i>0){
                ans.append(" ");
            }
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "   hello    world  ";
        // System.out.println(reverseWords1(s));
        System.out.println(reverseWords2(s));
        System.out.println(reverseWords2(s).length());
    }
}
