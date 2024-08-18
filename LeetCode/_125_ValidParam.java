public class _125_ValidParam {

    /*
     * Tweo pointer approach
     * 
     * Steps:
     * 1. If the string is empty, return true
     * 2. Initialize two pointers, start and last, to point to the start and end of the string
     * 3. While the start pointer is less than or equal to the last pointer, do the following:
     * 4. If the character at the start pointer is not a letter or digit, move the start pointer to the right
     * 5. If the character at the last pointer is not a letter or digit, move the last pointer to the left
     * 6. If the characters at the start and last are not equal, return false
     * 7. If equal then Move the start pointer to the right and the last pointer to the left
     * 8. If the loop completes, return true
     */
    public static boolean method1(String s) {
        if(s.isEmpty()){
            return true;
        }
        int start=0;
        int last = s.length() - 1;
        while(start<=last){
            char f = s.charAt(start);
            char l = s.charAt(last);
            if(!Character.isLetterOrDigit(f )){
                start++;
            } else if(!Character.isLetterOrDigit(l)){
                last --;
            } else{
                if(Character.toLowerCase(f) != Character.toLowerCase(l)){
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String vp = "A man, a plan, a canal: Panama";
        System.out.println(method1(vp));
    }
}
