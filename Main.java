
public class Main {

  public static void main(String[] args) {

    /* Upcast Dog object to Animal */
    Animal pet = new Dog();
    pet.name = "Charlie";
    pet.doTrick();

    /* Section 5 */
    Animal Wanda = new Cat();
    Wanda.name = "Wanda";
    Wanda.doTrick();

    /* Section 7 */
    makeAnimalSpeak(pet);

    /* Section 9 */
    makeAnimalSpeak(Wanda);
  }

  /* Section 6 */
  public static void makeAnimalSpeak(Animal animal) {
    if (animal instanceof Dog) {
      Dog dog = (Dog) animal;
      dog.bark();
    } else if (animal instanceof Cat) { /* Section 8 */
      Cat cat = (Cat) animal;
      cat.meow();
    }
  }

}
