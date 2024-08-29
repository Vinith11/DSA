public class _largestOddNumber {

    public static String largestOddNumber(String num){
        for(int i=num.length() - 1; i>=0; i--){
            if(Character.getNumericValue(num.charAt(i)) %2 != 0){
                return num.substring(0, i+1);
            }
        }

        return "";
    }

    public static void main(String[] args) {
        String num = "3542";
        System.out.println(largestOddNumber(num));
    }
    
}
