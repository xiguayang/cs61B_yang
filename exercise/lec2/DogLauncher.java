public class DogLauncher{
  public static void main(String[] args) {
    Dog d = new Dog(25);
    //d.weightInPounds = 25;
    //d.makeNoise();

    Dog d2 = new Dog(100);

    //use the static method get the bigger dog
    Dog bigger = Dog.maxDog(d,d2);
    bigger.makeNoise();

    //use non-static method, compare the dog2 with itself,
    d = d.maxDog(d2);
    d.makeNoise();

    //Dog test = Dog.maxDog_2(d,d2);
    //test.makeNoise();

  }
}
