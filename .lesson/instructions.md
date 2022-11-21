# Instructions  
### Description:
You've previously learned to cast primitive values. Recall that an object's class is also considered its type. We can also do **object type casting**, which is where we change the type of the reference variable that is pointing to an object. We are able to do this by taking advantage of Inheritance: if you have a subtype object, you can reference it using a reference variable that is of its own type, or that of a parent type. There are two ways to cast with object types:

**Upcasting**: Having a supertype reference variable point to a subtype object.

**Downcasting**: Changing a supertype reference variable to a subtype reference variable.

In this activity you will learn how to cast objects. Please follow the steps below:

### Steps:
1. Add the following code into Animal.java:
```Java
public class Animal {

  String name;

  public void doTrick() {
    System.out.println(this.name + " sits on command.");
  }
  
}
```
We added the Animal class. It defines an instance variable named *name* and an instance method named *doTrick()* that prints the object's name concatenated to a String. 

2. Next, add in the following code to Dog.java:
```Java
public class Dog extends Animal {

    public void bark() {
    System.out.println(this.name + " the dog barks several times.");
  }
  
}
```
Because the Dog class extends the Animal class, it inherits the *name* and *doTrick()* class members. The Dog class also defines the *bark()* method. This means that dog objects will have a name and are able to doTrick() and bark(). 

3. Let's start with an example of upcasting. In the main() method, add in the following code:
```Java
Animal anim = new Dog();
anim.name = "Charlie";
anim.doTrick();
```
The first statement assigns an Animal type reference variable to a Dog object. Recall that because of inheritance, the dog *is an* animal, so this works. The next statement gives the Dog the name `Charlie`.

The next statement has the reference variable call doTrick(). The Dog object is guaranteed to inherit whatever state and behavior an Animal needs to have, including the doTrick() method, so this also works. 

You can consider upcasting as viewing the subtype object through the "lens" of the parent class. If you are using an Animal type reference variable, you can view and access the name and doTrick() members that the Dog object inherits. Something you can't do is access bark() though, because the parent type reference variable doesn't "see" subtype members.

Run the program. You should see the following output: `Charlie sits on command.`

4. Now it's your turn. Create a Cat class in Cat.java that extends Animal and has a *meow()* method that does the following:
  - it is publicly accessible
  - it returns nothing
  - it prints the following to the console: `this.name + " the cat meows loudly."`
    
5. Next, in the *main()* method below any code you have so far, create another Animal type reference variable, assign it new cat object, name the cat `Wanda`, and have animal call doTrick().
    
6. Let's move on to downcasting. Add in the following method to the Main class, below the *main()* method:
```Java
  public static void makeAnimalSpeak(Animal animal){

    if (animal instanceof Dog){
      Dog dog = (Dog) animal;
      dog.bark();
    }
   
  }
```
This method is static, which means we can directly call it in the main() method without creating an object of the class. The method takes in an Animal object, so you can pass in objects of the Animal class or any of its subtypes. 

The `if` statement checks if the object is an **instanceof** Dog, meaning if it is an object of the Dog class. If it is, we downcast the object from the Animal type to the Dog type: `Dog dog = (Dog) animal;` and then we have the dog bark(). Note that neither downcasting nor upcasting change the object. We change the "lens" that we are looking at the object through. In this case, we are changing from the Animal "lens" to the Dog "lens". This allows the reference variable to "see" the object's Dog class members and as well as its inherited Animal members.

7. In the *main()* method below any code you have so far, add the following statement:
```Java
makeAnimalSpeak(anim);
```
Run the program and notice the output. You should see the new output: `Charlie the dog barks several times.`

8. In the *makeAnimalSpeak()* method, add in an `else if` statement that checks if the animal is an instance of Cat. If it is, downcast the object to the Cat type and have the cat call meow().
   
9. Next, in the *main()* method below any code you have so far, call the *makeAnimalSpeak()* method and pass in the reference variable you created that is pointing to the Cat object. Run the program and observe the output.

### Test:
Use the test provided. 

#### Sample output:
```
Charlie sits on command.
Wanda sits on command.
Charlie the dog barks several times.
Wanda the cat meows loudly.
```