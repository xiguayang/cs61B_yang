public class Exercise {
    /** Returns the maximum value from m. */
    /** forloop */
    public static int max(int[] m) {
      int max_value = m[0];
      for(int i = 1;i<m.length;i+=1){
        if(max_value<m[i]){
          max_value= m[i];
        }
      }
      return max_value;
    }
    /** while loop*/
    public static int whileMax(int[]m){
      int max_value = m[0];
      int i = 1;
      while(i<m.length){
        if(max_value<m[i]){
          max_value=m[i];
        }
        i+=1;
      }
      return max_value;
    }
    /**a demo used to understand statement continue used for;
    * continue will skip the current iteration of the loop
    * and jumping to the increment condition
    */
    public static void continueDemo(String[] demo){
      for(int i = 0;i<demo.length;i+=1){
        if(demo[i].contains("horse")){
          continue;
        }
        for(int j=0;j<3;j+=1){
          System.out.println(demo[i]);
        }
      }
    }

    /**used to understand how statement break works;
    * break will completely terminates the innermost loop when it is called
    */
    public static void breakDemo(String[] demo){
      for(int i = 0;i<demo.length;i+=1){
        for(int j = 0 ; j<3;j+=1){
          System.out.println(demo[i]);
          if (demo[i].contains("horse")){
            break;
          }
        }
      }
    }

    /**a function that replaces each element a[i]
    *with the sum of a[i] throngh a[i+n], but only if a[i] is positive
    *if there's not enough values in the array, only sum as many values as we have
    */
    public static int[] windowPosSum(int[]a, int n){
      int temp = 0;
      for(int i = 0;i<a.length;i+=1){
        //use continue to skip the negative value
        if(a[i]<0){
          continue;
        }
        for(int j = 0;j<=n;j+=1){
          //use break to avoid going over the end of the array
          if(i+j>a.length-1){
            break;
          }
          temp = temp + a[i+j];
        }
        a[i]=temp;
        temp = 0;
      }
      return a;
    }


    public static void main(String[] args) {
       int[] numbers = new int[]{9, 2, 15, 2, 22, 10, 6};
       System.out.println(max(numbers));
       System.out.println(whileMax(numbers));

       String[] a = {"cat", "dog", "laser horse", "ketchup", "horse", "horbse"};
       continueDemo(a);
       breakDemo(a);

       int[] x = {1, 2, -3, 4, 5, 4};
       int n = 3;
       windowPosSum(x, n);
       // Should print 4, 8, -3, 13, 9, 4
       int[] y= {1, -1, -1, 10, 5, -1};
       int m = 2;
       windowPosSum(y,m);
       System.out.println(java.util.Arrays.toString(x));
       System.out.println(java.util.Arrays.toString(y));

    }
}
