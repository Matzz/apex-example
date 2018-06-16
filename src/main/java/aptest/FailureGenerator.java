package aptest;

import java.time.LocalDateTime;
import java.util.Random;

public class FailureGenerator {
    static class ExpectedException extends RuntimeException {
    }

    static Random rnd = new Random();

    static private Double threshold = 0.1d;

    static void failOrNot(String what) {
        if (rnd.nextDouble() <= threshold) {
            WriteToTmp.write("Failing " + what + "! " + LocalDateTime.now());
            throw new ExpectedException();
        }
    }

}
