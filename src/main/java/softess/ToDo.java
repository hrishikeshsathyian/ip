package softess;

public class ToDo extends Task {


    public ToDo(String description, boolean isDone) {
        super(description);
        super.isDone = isDone;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String markAsDone() {
        super.isDone = true;
        return "Nice! I've marked this task as done: \n " + this.toString();
    }

    @Override
    public String markAsUnDone() {
        super.isDone = false;
        return "Nice! I've marked this task as undone: \n " + this.toString();
    }

    @Override
    public String generateTextToFile() {
        int status = this.isDone ? 1 : 0;
        String result = "TODO|%d|%s".formatted(status,this.description);
        return result;
    }
}
