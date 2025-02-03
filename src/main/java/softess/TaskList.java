package softess;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> tasks;
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public TaskList() {
        this.tasks = new ArrayList<Task>();
    }

    public ArrayList<Task> getTasks() {
        return this.tasks;
    }

    public void listTasks() {
        for (int i = 0; i < this.tasks.size(); i++) {
            System.out.println(String.format("%d. %s", (i + 1), this.tasks.get(i).toString()));
        }
    }

    public void markTaskAsDone(int index) {
        this.tasks.get(index - 1).markAsDone();
    }

    public void markTaskAsUndone(int index) {
        this.tasks.get(index - 1).markAsUnDone();
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        System.out.println("Got it. I've added this task:\n" + task.toString() + "\n Now you have " + tasks.size() + " tasks in the list");
    }

    public void removeTask(int index) {
        System.out.println("Got it. I've deleted this task:\n" + this.tasks.get(index - 1).toString() + "\n Now you have " + (tasks.size() - 1) + " tasks in the list");
        tasks.remove(index - 1);
    }

    public void findTasks(String query) {
        ArrayList<Task> matchingTasks = new ArrayList<>();
        for (Task task : this.tasks) {
            if (task.toString().toLowerCase().contains(query.toLowerCase())) {
                matchingTasks.add(task);
            }
        }

        if (matchingTasks.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("Here are the tasks that contained the word you searched for: ");
            for (int i = 0; i < matchingTasks.size(); i++) {
                System.out.println(String.format("%d. %s", (i + 1), matchingTasks.get(i).toString()));
            }
        }
    }


}
