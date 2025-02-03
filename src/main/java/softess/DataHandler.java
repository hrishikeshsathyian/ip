package softess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * Handles reading and writing task data to a file.
 * This class provides methods to load tasks from a file and save tasks to a file,
 * ensuring persistence of task data.
 *
 * The file format follows a structured approach where each task is stored in a
 * line-separated manner with pipe ("|") delimiters.
 *
 * Supported task types:
 * <ul>
 *     <li>TODO</li>
 *     <li>DEADLINE</li>
 *     <li>EVENT</li>
 * </ul>
 *
 * The task completion status is represented as:
 * <ul>
 *     <li>"1" for completed</li>
 *     <li>"0" for not completed</li>
 * </ul>
 *
 * @author Hrishikesh Sathyian
 */
public class DataHandler {
    private final String filePath;

    /**
     * Constructs a new {@code DataHandler} with the specified file path.
     *
     * @param filePath the path to the file where tasks are stored
     */
    public DataHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Loads task data from the specified file and returns a list of tasks.
     *
     * @return an {@code ArrayList} containing the loaded tasks
     */
    public ArrayList<Task> loadData() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File taskFile = new File(filePath);
            Scanner s = new Scanner(taskFile);
            while (s.hasNext()) {
                String[] taskData = s.nextLine().split("\\|");
                boolean status = Objects.equals(taskData[1], "1");

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
        return tasks;
    }

    /**
     * Saves the list of tasks to the specified file.
     *
     * @param tasks the list of tasks to be saved
     * @throws IOException if an I/O error occurs while writing to the file
     */
    public void saveData(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath, false);
        for (Task task : tasks) {
            fw.write(task.generateTextToFile() + System.lineSeparator());
        }
        fw.close();
    }
}
