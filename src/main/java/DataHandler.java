import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class DataHandler {
    private final String filePath;
    public DataHandler(String filePath) {
        this.filePath = filePath;
    }

    public ArrayList<Task> loadData() {
        ArrayList<Task> tasks = new ArrayList<>();
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
        return tasks;
    }

    public void saveData(ArrayList<Task> tasks) throws IOException {
        FileWriter fw = new FileWriter(filePath, false);
        for (int i = 0; i < tasks.size(); i++) {
            fw.write(tasks.get(i).generateTextToFile() + System.lineSeparator());
        }
        fw.close();
    }


}
