public class CatLauncher{
  public static void main(String[] args) {

    Cat a = new Cat("Cream", "Meow!");
    //create a Cat object with name Cream and static variable noise is Meow

    Cat b = new Cat("Tubbs", "Nyan!");
    //create a Cat object with name Tubbs and static variable noise is Nyan
    //NOW static field Cat.noise is Nyan
    a.play();
    //Nyan! I'm Cream the cat!
    b.play();
    //Nyan! I'm Tubbs the cat!
    Cat.anger();
    //Cat.noise is NYAN
    a.calm();
    //noise is nyan
    a.play();
    //nyan! I'm Cream the cat!
    b.play();
    //nyan! I'm Tubbs the cat!
  }
}
