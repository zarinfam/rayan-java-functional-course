package buffer;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by saeed on 2/17/16.
 */
@FunctionalInterface
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
