public class Pokemon{
  public String name;
  public int level;

  public Pokemon(String name, int level){
    this.name = name;
    this.level = level;
  }

  public static void main(String[] args){
    Pokemon p = new Pokemon("Pikachu", 17);
    int level = 100;
    change(p, level);
    System.out.println("Name: " + p.name + ", Level: "+ p.level);
  }

  public static void change(Pokemon poke, int level){
    poke.level = level;
    level = 50;
    poke = new Pokemon("Gengar",1);
  }
}

/**
(a) What would Java display?
Name: Pikachu, Level: 100
(b) Draw the box-and-pointer diagram after Java evaluates the main method
level of object p change to 100
create a new Pokemon object namede Gengar and leve 1
(c) On line 19, we set level equal to 50. What level do we mean? An instance
variable of the Pokemon class? The local variable containing the parameter to
the change method? The local variable in the main method? Something else?
just the local variable inside the method changed to 50
*/
