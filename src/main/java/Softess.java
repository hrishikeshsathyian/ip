import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
public class Softess {

    private static void writeToFile(String filePath, ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath, false);

        for (int i = 0; i < tasks.size(); i++) {
            fw.write(tasks.get(i).generateTextToFile() + System.lineSeparator());

        }
        fw.close();
    }
    public static void main(String[] args)  {
        System.out.println("Hello! I'm Softess");
        System.out.println("What can I do for you?\n");
        ArrayList<Task> tasks = new ArrayList<Task>();
        String filePath = "src/main/data/softess.txt";
        try {
            File taskFile = new File(filePath);
            Scanner s = new Scanner(taskFile);
            while (s.hasNext()) {
                String[] taskData = s.nextLine().split("\\|");
                boolean status = Objects.equals(taskData[1], "1") ? true : false;
                switch (taskData[0]) {
                    case "TODO":
                        tasks.add(new ToDo(taskData[2], status));
                        break;
                    case "DEADLINE":
                        tasks.add(new Deadline(taskData[2], taskData[3], status));
                        break;
                    case "EVENT":
                        tasks.add(new Event(taskData[2], taskData[3], taskData[4], status));
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        Scanner scanner = new Scanner(System.in);
        int count = tasks.size();
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
                    writeToFile(filePath, tasks);
                } else if (Objects.equals(userInput[0], "unmark")) {
                    int num = Integer.valueOf(userInput[1]);
                    tasks.get(num-1).markAsUnDone();
                    writeToFile(filePath, tasks);
                } else if (Objects.equals(userInput[0], "deadline")) {
                    userInput = fullUserInput.split("/by");
                    String description = userInput[0].split("deadline")[1];
                    tasks.add(new Deadline(description, userInput[1], false));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                    writeToFile(filePath, tasks);
                } else if (Objects.equals(userInput[0], "event")) {
                    userInput = fullUserInput.split("/from");
                    String description = userInput[0].split("event")[1];
                    String[] time = userInput[1].split("/to");
                    tasks.add(new Event(description, time[0], time[1], false));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                    writeToFile(filePath, tasks);
                } else if (Objects.equals(userInput[0], "todo")) {
                    String[] split = fullUserInput.split("todo");
                    if (split.length == 1 || split[1].trim() == "") {
                        throw new SoftessException.InvalidTodoException();
                    }
                    tasks.add(new ToDo(fullUserInput.split("todo")[1], false));
                    System.out.println("Got it. I've added this task:\n" + tasks.get(count).toString() + "\n Now you have " + tasks.size() + " tasks in the list");
                    count++;
                    writeToFile(filePath, tasks);
                } else if (Objects.equals(userInput[0], "delete")) {
                    int num = Integer.valueOf(userInput[1]);
                    System.out.println("Got it. I've deleted this task:\n" + tasks.get(num - 1).toString() + "\n Now you have " + (tasks.size() - 1) + " tasks in the list");
                    tasks.remove(num - 1);
                    count--;
                    writeToFile(filePath, tasks);
                } else {
                    throw new SoftessException.InvalidCommandException();
                }
            }

        } catch (SoftessException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }
    }
}