public class Piece{
  public int longitude;
  public int latitude;
  public Piece(int x, int y){
    longitude = x;
    latitude = y;
  }
  /**take the Pieces in the given 1D Piece array,
  * where Pieces are in no particular order,
  * and put it into a 2D array
  * where each row filled with Pieces that have the same latitude.*/
  public Piece[][] groupByLat(Piece[] p){
    int width = (int)Math.sqrt(p.length);
    Piece [][] latGroup = new Piece[width][width];
    for(int i= 0; i<p.length;i++){
      for(int j =0;j<width;j++){
        if(latGroup[j][i].latitude==p[i].latitude){

        }
      }
    }
  }
}
