package softess;

public class EventCommand extends Command {

    public TaskList tasks;
    public String description;
    public String from;
    public String to;
    public EventCommand(UserInterface ui, TaskList tasks, String description, String from, String to) {
        super(ui);
        this.tasks = tasks;
        this.description = description;
        this.from = from;
        this.to = to;
    }
    @Override
    public String trigger() {
        return this.tasks.addTask(new Event(description, from, to, false));
    }
}
