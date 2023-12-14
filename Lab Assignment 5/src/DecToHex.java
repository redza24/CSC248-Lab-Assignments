import java.util.Stack;
import java.util.Scanner;

public class DecToHex {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();

        System.out.print("Enter a decimal number: ");
        int dec = in.nextInt();
        int dec2 = dec;
        int quo = 0;
        int rem = 0;
        String hex = "";
        
        System.out.printf("\n%10s  %3s\n", "QUO", "REM");
        System.out.printf("%10s, %3s\n", dec, "---");
        while (dec > 0) {
            quo = dec / 16;
            rem = dec % 16;
            dec = quo;
            stack.push(rem);
            System.out.printf("%10d, %3d\n", quo, stack.peek());
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (num < 10) {
                hex += num;
            } else {
                switch (num) {
                    case 10:
                        hex += "A";
                        break;
                    case 11:
                        hex += "B";
                        break;
                    case 12:
                        hex += "C";
                        break;
                    case 13:
                        hex += "D";
                        break;
                    case 14:
                        hex += "E";
                        break;
                    case 15:
                        hex += "F";
                        break;
                }
            }
        }
        System.out.println("\nDecimal    : " + dec2);
        System.out.println("Hexadecimal: " + hex);

        
    }
}
