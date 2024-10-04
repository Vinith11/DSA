
public class _sortColors {

    //Store variables of ones and twos
    public static void sortColors1(int[] nums) {

        int arr[] = {0,0,0};
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                arr[0]++;
            } else if(nums[i] == 1){
                arr[1]++;
            } else{
                arr[2]++;
            }
        }

        int index = 0;

        while(arr[0] !=0){
            nums[index] = 0;
            arr[0]--;
            index++;
        }

        while(arr[1] !=0){
            nums[index] = 1;
            arr[1]--;
            index++;
        }

        while(arr[2] !=0){
            nums[index] = 2;
            arr[2]--;
            index++;
        }

    }





    public static void main(String args[]) {
        int n = 6;
        int arr[] = { 0, 2, 1, 2, 0, 1 };
        sortColors1(arr);
        System.out.println("After sorting:");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

    }

}
