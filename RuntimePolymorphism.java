// Base class
class Animal {
    // Method to be overridden
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}

// Derived class 1
class Dog extends Animal {
    // Overriding the sound method
    public void sound() {
        System.out.println("Dog barks");
    }
}

// Derived class 2
class Cat extends Animal {
    // Overriding the sound method
    public void sound() {
        System.out.println("Cat meows");
    }
}

// Main class
public class RuntimePolymorphism {
    public static void main(String[] args) {
        // Creating reference of Animal type and assigning derived class objects
        Animal myAnimal = new Animal();  // Animal reference to Animal object
        Animal myDog = new Dog();        // Animal reference to Dog object
        Animal myCat = new Cat();        // Animal reference to Cat object

        // Calling the sound method (runtime polymorphism)
        myAnimal.sound();  // Output: Animal makes a sound
        myDog.sound();     // Output: Dog barks
        myCat.sound();     // Output: Cat meows
    }
}
