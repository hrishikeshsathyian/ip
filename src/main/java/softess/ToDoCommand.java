package softess;

public class ToDoCommand extends Command {

    public TaskList tasks;
    public String description;
    public ToDoCommand(UserInterface ui, TaskList tasks, String description) {
        super(ui);
        this.tasks = tasks;
        this.description = description;
    }
    @Override
    public void trigger() {
        this.tasks.addTask(new ToDo(description,false));
    }
}