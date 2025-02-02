import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Deadline extends Task {

    protected String by;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");
    private static final DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("MMM dd yyyy, h:mm a");

    public Deadline(String description, String by, boolean isDone) {
        super(description);
        super.isDone = isDone;
        try {
            this.by = LocalDateTime.parse(by, INPUT_FORMAT).format(OUTPUT_FORMAT);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd HHmm format.");
            this.by = LocalDateTime.now().format(OUTPUT_FORMAT);
        }
    }


    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + by + ")";
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
        String result = "DEADLINE|%d|%s|%s".formatted(status,this.description,this.by);
        return result;
    }
}