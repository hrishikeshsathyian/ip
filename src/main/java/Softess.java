import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Softess {
    public static void main(String[] args) throws SoftessException {
        System.out.println("Hello! I'm Softess");
        System.out.println("What can I do for you?\n");
        ArrayList<Task> tasks = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        try {
            while (true) {
                String fullUserInput = scanner.nextLine();
                String[] userInput = fullUserInput.split(" ");

                if (Objects.equals(userInput[0], "bye")) {
                    System.out.println("Softess: Bye. Hope to see you again soon noob!");
                    break;
                } else if (Objects.equals(userInput[0], "list")) {
                    for (int i = 0; i < tasks.size(); i++) {
                        System.out.println(String.format("%d. %s", (i + 1), tasks.get(i).toString()));
                    }
                } else if (Objects.equals(userInput[0], "mark")) {
                    int num = Integer.valueOf(userInput[1]);
                    tasks.get(num-1).markAsDone();
                } else if (Objects.equals(userInput[0], "unmark")) {
                    int num = Integer.valueOf(userInput[1]);
                    tasks.get(num-1).markAsUnDone();
                } else if (Objects.equals(userInput[0], "deadline")) {
                    userInput = fullUserInput.split("/by");
                    String description = userInput[0].split("deadline")[1];
                    tasks.add(new Deadline(description, userInput[1]));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                } else if (Objects.equals(userInput[0], "event")) {
                    userInput = fullUserInput.split("/from");
                    String description = userInput[0].split("event")[1];
                    String[] time = userInput[1].split("/to");
                    tasks.add(new Event(description, time[0], time[1]));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                } else if (Objects.equals(userInput[0], "todo")) {
                    String[] split = fullUserInput.split("todo");
                    if (split.length == 1 || split[1].trim() == "") {
                        throw new SoftessException.InvalidTodoException();
                    }
                    tasks.add(new ToDo(fullUserInput.split("todo")[1]));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                } else if (Objects.equals(userInput[0], "delete")) {
                    int num = Integer.valueOf(userInput[1]);
                    System.out.println("Got it. I've deleted this task:\n" + tasks.get(num - 1).toString() + "\n Now you have " + (tasks.size() - 1) + " tasks in the list");
                    tasks.remove(num - 1);
                    count--;
                } else {
                    throw new SoftessException.InvalidCommandException();
                }
            }

        } catch (SoftessException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}