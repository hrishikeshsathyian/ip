public class ToDo extends Task {


    public ToDo(String description) {
        super(description);
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
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
}
