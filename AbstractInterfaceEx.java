interface LivingBeing{
    void eat();
} 
abstract class Human implements LivingBeing{
    @Override
    public void eat(){
        System.out.println("Human is eating");
    }
}
class Male extends Human{
}
abstract class Animal implements LivingBeing{
    abstract void makeSound();

    @Override
    public void eat(){
        System.out.println("Animal is eating");
    }
}
class Dog extends Animal{
    @Override
    void makeSound(){
        System.out.println("Bark");
    }
}

public class AbstractInterfaceEx {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.eat();
        dog.makeSound();
        Male Jack = new Male();
        Jack.eat();
    }
}
