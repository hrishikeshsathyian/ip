package softess;

public abstract class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void markAsDone() {
        this.isDone = true;
        System.out.println("Nice! I've marked this task as done: \n [X] " + this.description);
    }

    public void markAsUnDone() {
        this.isDone = false;
        System.out.println("Nice! I've marked this task as undone: \n [ ] " + this.description);
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", this.getStatusIcon(), this.description);
    }

    public abstract String generateTextToFile();



}
