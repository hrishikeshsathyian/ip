import java.util.Objects;
import java.util.Scanner;

public class Softess {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Softess");
        System.out.println("What can I do for you?\n");
        Task[] tasks = new Task[100];
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (true) {
            String fullUserInput = scanner.nextLine();
            String[] userInput = fullUserInput.split(" ");

            if (Objects.equals(userInput[0], "bye")) {
                System.out.println("Softess: Bye. Hope to see you again soon noob!");
                break;
            } else if (Objects.equals(userInput[0], "list")) {
                for (int i = 0; i < count; i++) {
                    System.out.println(String.format("%d. [%s] %s", (i + 1), tasks[i].getStatusIcon(), tasks[i].description));
                }
            } else if (Objects.equals(userInput[0], "mark")) {
                int num = Integer.valueOf(userInput[1]);
                tasks[num - 1].markAsDone();
            } else if (Objects.equals(userInput[0], "unmark")) {
                int num = Integer.valueOf(userInput[1]);
                tasks[num - 1].markAsUnDone();
            } else {
                System.out.println("added: " + fullUserInput + "\n");
                tasks[count] = new Task(fullUserInput);
                count++;
            }

        }

        scanner.close();
    }
}