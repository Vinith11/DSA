
import java.util.ArrayList;
import java.util.List;

public class _arrLeaders {

    public static ArrayList<Integer> arrLeaders1(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = 0; i<arr.length; i++){
            boolean leader = true;
            for(int j = i; j<arr.length; j++){
                if(arr[i]<arr[j]){
                    leader = false;
                    break;
                }
            }
            if(leader){
                ans.add(arr[i]);
            }
        }
        return ans;
    }

    public static ArrayList<Integer> arrLeaders2(int[] arr){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int max = arr[n-1];

        ans.add(max);

        for(int i = n-2; i>=0; i--){
            if(arr[i]>=max){
                ans.add(arr[i]);
                max = arr[i];
            }
            
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {16,17, 4, 3, 5, 2};
        List<Integer> ans = arrLeaders2(arr);
        for(int i: ans){
            System.out.print(i + " ");
        }
    }
}
