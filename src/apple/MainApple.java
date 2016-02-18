package apple;

import functional.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Created by saeed on 2/14/16.
 */
public class MainApple {

    public static final String GREEN = "green";
    public static final String RED = "red";
    public static final String YELLOW = "yellow";

    public static void main(String[] args) {

        ArrayList<Apple> inventory = new ArrayList<>(Arrays.asList(
                new Apple(GREEN), new Apple(YELLOW), new Apple(RED), new Apple(GREEN)));


        inventory.sort(
                (Apple a1, Apple a2) -> (int)(a1.getWeight() - a2.getWeight()));

        inventory.sort(comparing((a) -> a.getWeight()));

        inventory.sort(comparing(Apple::getWeight));


        Predicate<Apple> redApple = (a -> a.getColor().equals(RED));

        Predicate<Apple> redAndGreenApple = redApple.or(a -> a.getColor().equals(GREEN));
    }

    public static List<Apple> filterApplesByColor(List<Apple> inventory, String color) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }

        return result;
    }

    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate predicate) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}
