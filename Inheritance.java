
class Animal {
    // Field (attribute)
    String name;

    // Method (behavior)
    public void eat() {
        System.out.println(name + " is eating.");
    }
}

// Derived class (Child)
class Dog extends Animal {
    // Additional method specific to Dog
    public void bark() {
        System.out.println(name + " is barking.");
    }
}

// Main class
public class Inheritance {
    public static void main(String[] args) {
        // Creating an object of the Dog class
        Dog myDog = new Dog();

        // Accessing fields and methods from the base class
        myDog.name = "Buddy";
        myDog.eat();  // Inherited from Animal class

        // Accessing methods from the derived class
        myDog.bark();  // Specific to Dog class
    }
}
