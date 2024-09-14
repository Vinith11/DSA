
import java.util.ArrayList;

public class _factorialNumbers {
    
    static ArrayList<Long> factorialNumbers(long n) {
        ArrayList<Long> ans = new ArrayList<>();
        recursive(1,1,ans,n);

        return ans;
    }

    static void recursive(long temp, long fact, ArrayList<Long> ans, long n){
        if(fact > n){
            return;
        }
        fact*=temp;
        if(fact<=n){
            ans.add(fact);
        }

        temp++;
        recursive(temp,fact,ans,n);
    }
    
    public static void main(String[] args) {
        int n = 3;
        System.out.println(factorialNumbers(n));
    }
}
