class temp {

    public static void main(String[] args) throws Exception {
        pattern6();
    }

    static void pattern1(){
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                System.out.print("*");
            }
            System.out.println();
        }  
    }

    static void pattern2(){
        for(int i=0; i<5; i++){
            for(int j=0; j<i+1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern3(){
        for(int i=5; i>=0; i--){
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern4(){
        for(int i=0; i<5; i++){
            for(int j=0; j<i+1; j++){
                System.out.print(j+1);
            }
            System.out.println();
        }
    }


    static void pattern5(){
        int n = 4; 
        for(int i=0; i<2*n-1; i++){
            for(int j=0; j<5; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void pattern6(){
        int n = 4; 
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i <= 0 || j<=0 || j==n-1|| i==n-1){
                    System.out.print("*");
                } else{
                    System.out.print(" ");
                }
            }    
            System.out.println();
        }
    }
}