// Floor is the largerst no. in array <=x;
// Ceil is the smallest number that is >= x;
public class _getFloorAndCeil {


    public static int findfloor(int[] a, int n, int x){
        int l = 0;
        int h = n-1;
        int ans = -1;

        while (l<=h) {
            int m = (l + h)/2;
            int ele = a[m];

            if(ele<=x){
                ans = ele;
                l = m+1;
            } else{
                h = m-1;
            }
        }

        return ans;
    }

    public static int findceil(int[] a, int n, int x){
        int l = 0;
        int h = n-1;
        int ans = -1;

        while (l<=h) {
            int m = (l + h)/2;
            int ele = a[m];

            if(ele>=x){
                ans = ele;
                h = m-1;
            } else{
                l = m+1;
            }
        }

        return ans;
    }

    public static int[] getFloorAndCeil(int[] a, int n, int x) {
        int f = findfloor(a, n, x);
        int c =  findceil(a, n, x);

        return new int[] {f,c};
    }

    public static void main(String[] args) {
        int[] arr = {3,4,7,8,8,10};
        int n = arr.length;
        int x = 5;
        int ans[] = getFloorAndCeil(arr, n, x);

        System.out.println("The floor and ceil are: " + ans[0] + " " + ans[1]);
    }    
}
