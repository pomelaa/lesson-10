import java.util.ArrayList;

class Task {
    private String title;
    private String description;
    private boolean isCompleted;
    private String owner;

    public Task(String title, String description, String owner) {
        this.title = title;
        this.description = description;
        this.isCompleted = false;
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        isCompleted = true;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", owner='" + owner + '\'' +
                '}';
    }
}

class User {
    private String name;
    private ArrayList<Task> tasks;

    public User(String name) {
        this.name = name;
        this.tasks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void createTask(String title, String description) {
        Task task = new Task(title, description, name);
        tasks.add(task);
        System.out.println("Task created successfully.");
    }

    public void editTask(int index, String newTitle, String newDescription) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.title = newTitle;
            task.description = newDescription;
            System.out.println("Task edited successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task index.");
        }
    }

    public void displayTasks() {
        System.out.println("Tasks for user " + name + ":");
        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        User user1 = new User("John Doe");

        user1.createTask("Complete Java Assignment", "Finish the coding tasks for Java course");
        user1.createTask("Read Book", "Read 'The Great Gatsby' for literature class");

        user1.displayTasks();

        user1.editTask(0, "Complete Java Assignment", "Finish the coding tasks for Java course and submit");
        user1.deleteTask(1);

        user1.displayTasks();
    }
}

