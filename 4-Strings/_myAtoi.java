public class _myAtoi {
    public static int myAtoi(String s) {
        long ans = 0;
        int neg = 1;
        s=s.trim();

        for(int i=0; i<s.length(); i++){
            if(i==0 && s.charAt(i) == '-'){
                neg = -1;
            } else if(i==0 && s.charAt(i) == '+'){
                neg = 1;
            }else if(Character.isDigit(s.charAt(i))){
                ans = ans * 10 + (s.charAt(i) - '0');
                if (ans * neg <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
                if (ans * neg >= Integer.MAX_VALUE) return Integer.MAX_VALUE;

            }  else if(Character.isAlphabetic(s.charAt(i)) || s.charAt(i) == '-' || s.charAt(i) == '+' || s.charAt(i) == '.' || s.charAt(i) == ' '){
                break;
            }
            
        }

        return (int)ans * neg;
    }

    public static void main(String[] args) {
        String s = "   +0 10";
        System.out.println(myAtoi(s));
    }
}
