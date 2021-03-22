import java.util.*;

public class UserInput {
    static Scanner input = new Scanner(System.in);
    public static double getDouble() { return Double.parseDouble(input.nextLine()); }

    public static boolean getExitKey() {
        System.out.print("Press q-key to exit or enter-key to continue: ");
        String s = input.nextLine();
        if (s.contentEquals("q")) {
            return true;
        }
        else {
            return false;
        }
    }
}