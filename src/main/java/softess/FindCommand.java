package softess;

public class FindCommand extends Command{

    private TaskList tasks;
    private String query;
    public FindCommand(UserInterface ui, TaskList tasks, String query) {
        super(ui);
        this.tasks = tasks;
        this.query = query;
    }

    @Override
    public void trigger() {
        this.tasks.findTasks(query);
    }
}
