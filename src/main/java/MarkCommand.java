public class MarkCommand extends Command {

    public TaskList tasks;
    public int index;
    public boolean toMark;
    public MarkCommand(UserInterface ui, TaskList tasks, int index, boolean toMark) {
        super(ui);
        this.tasks = tasks;
        this.index = index;
        this.toMark = toMark;
    }
    @Override
    public void trigger() {
        if (toMark) {
            this.tasks.markTaskAsDone(this.index);
        } else {
            this.tasks.markTaskAsUndone(this.index);
        }

    }
}
