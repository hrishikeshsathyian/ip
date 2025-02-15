package softess;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * A command that checks and lists all deadline tasks that are due within the next 3 days.
 */
public class RemindCommand extends Command {

    private TaskList tasks;
    private static final DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd HHmm");

    public RemindCommand(UserInterface ui, TaskList tasks) {
        super(ui);
        this.tasks = tasks;
    }

    @Override
    public String trigger() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime threeDaysLater = now.plusDays(3);
        List<String> upcomingDeadlines = new ArrayList<>();

        for (Task task : this.tasks.getTasks()) {
            if (task instanceof Deadline) {
                Deadline deadlineTask = (Deadline) task;
                try {
                    System.out.println(deadlineTask.by);
                    LocalDateTime deadlineDate = LocalDateTime.parse(deadlineTask.by.trim(), INPUT_FORMAT);
                    if (!deadlineDate.isAfter(threeDaysLater)) {
                        upcomingDeadlines.add(deadlineTask.toString());
                    }
                } catch (DateTimeParseException e) {
                    System.out.println("Skipping invalid deadline format for task: " + deadlineTask.description);
                }
            }
        }

        if (upcomingDeadlines.isEmpty()) {
            return "No deadlines are due within the next 3 days.";
        }

        StringBuilder result = new StringBuilder("Here are your upcoming deadlines:\n");
        for (String deadline : upcomingDeadlines) {
            result.append(deadline).append("\n");
        }

        return result.toString();
    }
}
