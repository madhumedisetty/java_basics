import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class LamdaExample {

    public static void main(String[] args){
        //basic synatx

        Runnable runnable= () -> System.out.println("Hello Worlds");
        runnable.run();

        Predicate<String> isLong= s->s.length()>2;
        System.out.println(isLong.test("Gitesh"));

        List<Integer> numbers= Arrays.asList(1,2,3,4,5);
        numbers.forEach(n->System.out.println("number is: "+n));

        Function<Integer, Integer> sqaure= x-> x*x;
        numbers.stream().map(sqaure).forEach(System.out::println);

        Function<Integer, Boolean> isEven= getIsEvenLambda();
        System.out.println(isEven.apply(5));
    }

    private static Function<Integer, Boolean> getIsEvenLambda() {
        return x -> x % 2 == 0;

    }
}