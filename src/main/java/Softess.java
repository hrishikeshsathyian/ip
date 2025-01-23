import java.util.Objects;
import java.util.Scanner;

public class Softess {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Softess");
        System.out.println("What can I do for you? \n");
        String[] tasks = new String[100];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String userInput = scanner.nextLine();
            if (Objects.equals(userInput, "bye")) {
                System.out.println("Softess: Bye. Hope to see you again soon noob!");
                break;
            } else if (Objects.equals(userInput, "list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println((i + 1) + ". " + tasks[i]);
                }
                System.out.println("\n");
            } else {
                System.out.println("added: " + userInput + "\n");
                tasks[count] = userInput;
                count++;
            }

        }

        scanner.close();
    }
}

