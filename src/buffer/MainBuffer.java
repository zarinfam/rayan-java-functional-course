package buffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.function.Function;

/**
 * Created by saeed on 2/17/16.
 */
public class MainBuffer {

    public static void main(String[] args) throws IOException {
        System.out.println(processFile());

        System.out.println(processFile((BufferedReader br) ->
                br.readLine() + br.readLine()));
    }

    public static String processFile() throws IOException{
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("java-functional.iml"))){
            return bufferedReader.readLine();
        }
    }

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader bufferedReader =
                     new BufferedReader(new FileReader("java-functional.iml"))){
            return p.process(bufferedReader);
        }

    }


}
