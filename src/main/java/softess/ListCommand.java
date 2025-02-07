package softess;

public class ListCommand extends Command {

    public TaskList tasks;
    public ListCommand(UserInterface ui, TaskList tasks) {
        super(ui);
        this.tasks = tasks;
    }
    @Override
    public String trigger() {
        return this.tasks.listTasks();
    }
}