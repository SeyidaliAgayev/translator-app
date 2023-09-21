package helper;

import java.util.Random;

public class RandomHelper {
    public static int randomIndexGenerator(int wordSize) {
        Random random = new Random();
        return random.nextInt(wordSize);
    }
}
