import java.util.InputMismatchException;
import java.util.Scanner;
public class ValueVerifier {
    private static final Scanner scanner = new Scanner(System.in);
    public static int intInput(String input_message){
        int input = 0;
        System.out.println(input_message);
        while(true) {
            try {
                input = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println(ErrorMsg.INT_INCORRECT);
            }
        }
        return input;
    }

    public static int intInput (int left_border, int right_border, String input_message){
        int input=intInput(input_message);
        while(input<left_border||input>right_border){
            System.out.println(ErrorMsg.OVER_BORDERS_INT_PT1+left_border+ErrorMsg.OVER_BORDERS_INT_PT2+right_border);
            input=intInput(input_message);
        }
        return input;
    }
    public static int intInput (int left_border, String input_message){
        int input=intInput(input_message);
        while(input<left_border){
            System.out.println(ErrorMsg.OVER_LEFT_BORDER_INT+left_border);
            input=intInput(input_message);
        }
        return input;
    }
}
