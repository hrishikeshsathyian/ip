package softess;

public class DeleteCommand extends Command {

    public TaskList tasks;
    public int index;
    public DeleteCommand(UserInterface ui, TaskList tasks, int index) {
        super(ui);
        this.tasks = tasks;
        this.index = index;
    }
    @Override
    public String trigger() {
        return this.tasks.removeTask(this.index);
    }
}