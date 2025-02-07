package softess;

public class DeadlineCommand extends Command {

    public TaskList tasks;
    public String description;
    public String by;
    public DeadlineCommand(UserInterface ui, TaskList tasks, String description, String by) {
        super(ui);
        this.tasks = tasks;
        this.description = description;
        this.by = by;
    }
    @Override
    public String trigger() {
        return this.tasks.addTask(new Deadline(description, by, false));
    }
}
