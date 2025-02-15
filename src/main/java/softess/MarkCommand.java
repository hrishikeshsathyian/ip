package softess;

public class MarkCommand extends Command {

    public TaskList tasks;
    public int index;
    public boolean shouldMark;
    public MarkCommand(UserInterface ui, TaskList tasks, int index, boolean shouldMark) {
        super(ui);
        this.tasks = tasks;
        this.index = index;
        this.shouldMark = shouldMark;
    }
    @Override
    public String trigger() {
        if (shouldMark) {
            return this.tasks.markTaskAsDone(this.index);
        } else {
            return this.tasks.markTaskAsUndone(this.index);
        }
    }
}
