package apple;

import com.sun.scenario.effect.InvertMask;
import functional.Transaction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
                new Apple(GREEN, 160), new Apple(YELLOW, 130), new Apple(RED, 200)
                , new Apple(GREEN, 100)));


        filterApples(inventory, apple -> apple.getWeight() > 15);


        filterApples(inventory, new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return (apple.getColor().equals(MainApple.GREEN)
                        && apple.getWeight() > 150);
            }
        });


        inventory.sort(
                (Apple a1, Apple a2) -> (int)(a1.getWeight() - a2.getWeight()));

        inventory.sort(comparing((a) -> a.getWeight()));

        Predicate<Apple> redApple = (a -> a.getColor().equals(RED));

        Predicate<Apple> redAndGreenApple = redApple.or(a -> a.getColor().equals(GREEN));

        inventory.sort(comparing(Apple::getWeight));
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

    public static List<Apple> filterApples(List<Apple> inventory
            , ApplePredicate predicate) {

        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (predicate.test(apple)) {
                result.add(apple);
            }
        }

        return result;
    }

}
