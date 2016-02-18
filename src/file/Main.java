package file;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.util.Arrays;

/**
 * Created by saeed on 2/14/16.
 */
public class Main {

    public static void main(String[] args) {

        File[] hiddenFiles = new File(".").listFiles(File::isHidden);

        Arrays.asList(hiddenFiles).forEach((x) -> System.out.println(x));
    }
}
