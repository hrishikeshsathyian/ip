package softess;

public class Event extends Task {
    protected String from;
    protected String to;

    public Event(String description, String from, String to, boolean isDone) {
        super(description);
        super.isDone = isDone;
        this.from = from;
        this.to = to;

    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (from: " + from + " to: " + to + ")";
    }

    @Override
    public void markAsDone() {
        super.isDone = true;
        System.out.println("Nice! I've marked this task as done: \n " + this.toString());
    }
    @Override
    public void markAsUnDone() {
        super.isDone = false;
        System.out.println("Nice! I've marked this task as undone: \n " + this.toString());
    }
    @Override
    public String generateTextToFile() {
        int status = this.isDone ? 1 : 0;
        String result = "EVENT|%d|%s|%s|%s".formatted(status,this.description,this.from,this.to);
        return result;
    }
}
