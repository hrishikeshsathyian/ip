package softess;

import java.util.Objects;

public class Parser {

    public UserInterface ui;
    public TaskList tasks;
    public Parser(UserInterface ui, TaskList tasks) {
        this.ui = ui;
        this.tasks = tasks;
    }

    public Command parseCommand(String fullUserInput) throws SoftessException {
        String[] userInput = fullUserInput.split(" ");
        if (Objects.equals(userInput[0], "bye")) {
            return new ExitCommand(ui);
        } else if (Objects.equals(userInput[0], "list")) {
            return new ListCommand(ui, tasks);
        } else if (Objects.equals(userInput[0], "mark")) {
            int num = Integer.valueOf(userInput[1]);
            return new MarkCommand(ui, tasks, num, true);
        } else if (Objects.equals(userInput[0], "unmark")) {
            int num = Integer.valueOf(userInput[1]);
            return new MarkCommand(ui, tasks, num, false);
        } else if (Objects.equals(userInput[0], "deadline")) {
            userInput = fullUserInput.split("/by");
            String description = userInput[0].split("deadline")[1];
            return new DeadlineCommand(ui, tasks, description, userInput[1]);
        } else if (Objects.equals(userInput[0], "event")) {
            userInput = fullUserInput.split("/from");
            String description = userInput[0].split("event")[1];
            String[] time = userInput[1].split("/to");
            return new EventCommand(ui, tasks, description, time[0], time[1]);
        } else if (Objects.equals(userInput[0], "todo")) {
            String[] split = fullUserInput.split("todo");
            if (split.length == 1 || split[1].trim() == "") {
                throw new SoftessException.InvalidTodoException();
            }
            return new ToDoCommand(ui, tasks, fullUserInput.split("todo")[1]);
        } else if (Objects.equals(userInput[0], "delete")) {
            int num = Integer.valueOf(userInput[1]);
            return new DeleteCommand(ui, tasks, num);
        } else {
            throw new SoftessException.InvalidCommandException();
        }
    }
}
