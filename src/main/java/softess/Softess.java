package softess;

import java.io.IOException;
import java.util.Scanner;

public class Softess {

    private DataHandler dataHandler;
    private TaskList tasks;
    private UserInterface ui;

    public Softess(String filePath) {
        this.ui  = new UserInterface();
        this.dataHandler = new DataHandler(filePath);
        this.tasks = new TaskList(dataHandler.loadData());
    }

    public void run() {
        this.ui.showWelcomeMessage();
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser(ui, tasks);
        try {
            while (true) {
                Command c = parser.parseCommand(scanner.nextLine());
                c.trigger();
                dataHandler.saveData(tasks.getTasks());
            }
        } catch (SoftessException e) {
            ui.showErrorMessage(e.getMessage());
        } catch (IOException e) {
            ui.showErrorMessage(e.getMessage());
        } finally {
            scanner.close();
        }
    }
    public static void main(String[] args)  {
        new Softess("src/main/data/softess.txt").run();
    }
}