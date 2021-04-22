public class Deck{
  public static int[] cards;
  Deck(){
    cards =[1,3,4,10];
  }
  public static void main(String[] args) {
    Deck dingie = new Deck();
    dingie.cards[3] = 3;
    //dingie: 1,3,4,3
    Deck pilates = new Deck();
    pilates.cards[1] =2;
    //dingie: 1,2,4,10
    //pilates: 1,2,4,10

    int[] newArrWhoDis = {2, 2, 4, 1, 3};
    dingie.cards = pilates.cards;
    pilates.cards = newArrWhoDis;
    //both dingie and pilates is {2, 2, 4, 1, 3}
    newArrWhoDis = null;
  }


}
