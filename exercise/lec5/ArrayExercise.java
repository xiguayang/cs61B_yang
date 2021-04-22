public class ArrayExercise{

  /**DISC03 EXERCISE 2.1
  *Consider a method that inserts an int item into an int[] arr at the given position.
  *The method should return the resulting array.
  *For example, if x = [5, 9, 14, 15],item = 6, and position = 2,
  *then the method should return [5, 9, 6, 14, 15].
  *If position is past the end of the array, insert item at the end of the array.
  *Is it possible to write a version of this method that returns void and changes arr in
  *place (i.e., destructively)? Hint: These arrays are filled meaning an array containing
  *n elements will have length n.
  *No, because arrays have a fixed size, so to add an element, you need to create a
  *new array.*/
  public static int[] insert(int[] arr, int item, int position) {
    int[] result = new int[arr.length+1];
    if(position>=arr.length){
      position = arr.length;
    }
    if(position ==0){
      result[position]=item;
      System.arraycopy(arr,0,result,1,arr.length);
    }else{
      System.arraycopy(arr,0,result,0,position);
      result[position]=item;
      System.arraycopy(arr,position,result,position+1,arr.length-position);
    }
    return result;
  }

  /**DISC03 EXERCISE 2.2
  *Consider a method that destructively reverses the items in arr.
  *For example calling reverse on an array [1, 2, 3] should change the array to be [3, 2, 1]. */

  public static void reverse(int[] arr){
    for(int i =0;i<=arr.length/2;i++){
      int temp=arr[i];
      arr[i]=arr[arr.length-1-i];
      arr[arr.length-1-i]=temp;
    }
  }

  public static void main(String[] args) {
    int[] a = {1,3,6,3,7,8};
    int[] b = insert(a,100,0);
    int[] c = insert(a,200,4);
    int[] d = insert(a,400,10);
  }
}
