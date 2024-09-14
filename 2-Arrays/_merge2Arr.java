public class _merge2Arr {
    
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int i=0;
        int j=0;
        int k=0;

        int[] ans = new int[n+m];


        while(i<m && j<n){
            if(nums1[i]<= nums2[j]){
                ans[k]=nums1[i];                
                i++;
            } else{
                ans[k]=nums2[j];            
                j++;
            }
            k++;
        }

        while(i<m){
            ans[k]=nums1[i];
            i++;
            k++;
        }

        while(j<n){
            ans[k]=nums2[j];
            j++;
            k++;
        }

        for (int x = 0; x < m + n; x++) {
            nums1[x] = ans[x];
        }
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        int m = 3;
        int n = 3;
        merge(num1, m,num2, n);
        for(int i: num1){
            System.out.print(i + " ");
        }
    }
}
