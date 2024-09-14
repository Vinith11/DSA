public class _rotateString {

    public static Boolean rotateString1(String s, String goal) {
        return (s.length() == goal.length()) && (s + s).contains(goal);
    }

    public static Boolean rotateString2(String s, String goal) {

        if (s.length() != goal.length()) {
            return false;
        }

        for (int i = 0; i < goal.length(); i++) {
            if (rortateStr(s, goal, i)) {
                return true;
            }
        }

        return false;
    }

    public static Boolean rortateStr(String s,String goal,int rotate){
        for (int i = 0; i < goal.length(); i++) {
            if (s.charAt(i) != goal.charAt((i + rotate)%goal.length())) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "defdefdefabcabc";
        String goal = "defdefdefabcabc";

        Boolean ans = rotateString2(s, goal);

        System.out.println(ans);
    }

}
