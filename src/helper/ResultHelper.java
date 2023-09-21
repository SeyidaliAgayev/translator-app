package helper;

public class ResultHelper {
    public static void levelGenerator(int point){
        if (point <= 2) {
            System.out.println("Your English level is A0");
        } else if (point == 3 || point == 4) {
            System.out.println("Your English level is A1");
        } else if (point == 5 || point == 6) {
            System.out.println("Your English level is B1");
        } else if (point == 7 || point == 8) {
            System.out.println("Your English level is C1");
        } else {
            System.out.println("Your English level is C2");
        }
    }
}
