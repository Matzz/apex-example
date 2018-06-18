package aptest;

import java.time.LocalDateTime;
import java.util.Random;

public class FailureGenerator {
    static class ExpectedException extends RuntimeException {
    }
    static private Double threshold = 0.1d;

    static void failOrNot(String what) {
        Random rnd = new Random();
        double generated = rnd.nextDouble();
        WriteToTmp.write(generated);
        if (generated <= threshold) {
            WriteToTmp.write("Failing " + what + "! " + LocalDateTime.now());
            throw new ExpectedException();
        }
    }

}
