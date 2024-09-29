class Calculator {
    // Method to add two integers
    public int add(int a, int b) {
        return a + b;
    }

    // Overloaded method to add three integers
    public int add(int a, int b, int c) {
        return a + b + c;
    }

    // Overloaded method to add two double values
    public double add(double a, double b) {
        return a + b;
    }
}
public class CompiletimePolymorphism {
       
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        // Calling different overloaded methods
        int sum1 = calc.add(10, 20);           // Calls the method with two int parameters
        int sum2 = calc.add(10, 20, 30);       // Calls the method with three int parameters
        double sum3 = calc.add(5.5, 3.5);      // Calls the method with two double parameters

        // Displaying results
        System.out.println("Sum1 (int, int): " + sum1);   // Output: 30
        System.out.println("Sum2 (int, int, int): " + sum2);  // Output: 60
        System.out.println("Sum3 (double, double): " + sum3); // Output: 9.0
}

}
