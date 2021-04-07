public class Triangle{
  private static void drawTriangle(int line){
    for (int i = 1;i<=line;i+=1){
      for(int j= 1;j<=i;j+=1){
        System.out.print("*");
      }
      System.out.println();
    }
  }
  public static void main(String[] args) {
    drawTriangle(10);
  }
}
