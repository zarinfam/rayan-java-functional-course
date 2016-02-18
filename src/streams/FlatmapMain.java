package streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Created by saeed on 2/16/16.
 */
public class FlatmapMain {


    public static void main(String[] args) {
        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);
        numbers1.stream()
                        .flatMap(i -> numbers2.stream()
                                .map(j -> new int[]{i, j})
                        )
                        .collect(toList())
                .forEach(s -> System.out.println(s[0] + "" + s[1]));


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
