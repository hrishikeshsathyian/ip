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
                    System.out.println(String.format("%d. %s", (i + 1), tasks[i].toString()));
                }
            } else if (Objects.equals(userInput[0], "mark")) {
                int num = Integer.valueOf(userInput[1]);
                tasks[num - 1].markAsDone();
            } else if (Objects.equals(userInput[0], "unmark")) {
                int num = Integer.valueOf(userInput[1]);
                tasks[num - 1].markAsUnDone();
            } else if (Objects.equals(userInput[0], "deadline")) {
                userInput = fullUserInput.split("/by");
                String description = userInput[0].split("deadline")[1];
                tasks[count] = new Deadline(description, userInput[1].strip());
                System.out.println("Got it. I've added this task: \n" + tasks[count].toString() + "\n Now you have " + (count + 1) + " tasks in the list");
                count++;
            } else if (Objects.equals(userInput[0], "event")) {
                userInput = fullUserInput.split("/from");
                String description = userInput[0].split("event")[1];
                String[] time = userInput[1].split("/to");
                tasks[count] = new Event(description, time[0].strip(), time[1].strip());
                System.out.println("Got it. I've added this task: \n" + tasks[count].toString() + "\n Now you have " + (count + 1) + " tasks in the list");
                count++;
            } else if (Objects.equals(userInput[0], "todo")) {
                tasks[count] = new ToDo(fullUserInput);
                System.out.println("Got it. I've added this task: \n" + tasks[count].toString() + "\n Now you have " + (count + 1) + " tasks in the list");
                count++;
            }

        }

        scanner.close();
    }
}