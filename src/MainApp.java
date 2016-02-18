import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

/**
 * Created by saeed on 2/16/16.
 */
public class MainApp {


    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList()).forEach(s -> System.out.println(s));

    }
}
