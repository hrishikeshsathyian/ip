import java.util.Objects;
import java.util.Scanner;

public class Softess {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Softess");
        System.out.println("What can I do for you?\n");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String userInput = scanner.nextLine();
            if (Objects.equals(userInput, "bye")) {
                System.out.println("Softess: Bye. Hope to see you again soon noob!");
                break;
            }
            System.out.println(userInput + "\n");
        }

        scanner.close();
    }
}

