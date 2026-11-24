import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private final int id;
    private final String title;
    private boolean completed;

    public Task(int id, String title) {
        this.id = id;
        this.title = title;
        this.completed = false;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void markCompleted() {
        completed = true;
    }

    @Override
    public String toString() {
        String status = completed ? "Completed" : "Pending";
        return String.format("%-6d %-35s %s", id, title, status);
    }
}

// Custom singly linked list used to store tasks.
class TaskLinkedList {
    private static class Node {
        Task data;
        Node next;

        Node(Task data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;

    public void add(Task task) {
        Node newNode = new Node(task);

        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public boolean remove(int id) {
        if (head == null) {
            return false;
        }

        if (head.data.getId() == id) {
            head = head.next;
            size--;
            return true;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getId() == id) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public Task findById(int id) {
        Node current = head;
        while (current != null) {
            if (current.data.getId() == id) {
                return current.data;
            }
            current = current.next;
        }
        return null;
    }

    public ArrayList<Task> searchByTitle(String keyword) {
        ArrayList<Task> results = new ArrayList<>();
        Node current = head;

        while (current != null) {
            if (current.data.getTitle().toLowerCase()
                    .contains(keyword.toLowerCase())) {
                results.add(current.data);
            }
            current = current.next;
        }
        return results;
    }

    public ArrayList<Task> getAllTasks() {
        ArrayList<Task> tasks = new ArrayList<>();
        Node current = head;

        while (current != null) {
            tasks.add(current.data);
            current = current.next;
        }
        return tasks;
    }

    public int getSize() {
        return size;
    }
}

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskLinkedList taskList = new TaskLinkedList();
    private static int nextId = 1;

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("==================================");
        System.out.println("       SIMPLE TO-DO MANAGER       ");
        System.out.println("==================================");

        while (running) {
            showMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    searchTasks();
                    break;
                case 4:
                    markTaskCompleted();
                    break;
                case 5:
                    deleteTask();
                    break;
                case 6:
                    System.out.println("Thank you for using To-Do Manager!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1 to 6.");
            }
        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n------------- MENU --------------");
        System.out.println("1. Add a task");
        System.out.println("2. View all tasks");
        System.out.println("3. Search task by title");
        System.out.println("4. Mark task as completed");
        System.out.println("5. Delete a task");
        System.out.println("6. Exit");
        System.out.println("---------------------------------");
    }

    private static void addTask() {
        System.out.print("Enter task title: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Task title cannot be empty.");
            return;
        }

        Task task = new Task(nextId++, title);
        taskList.add(task);
        System.out.println("Task added successfully. Task ID: " + task.getId());
    }

    private static void viewTasks() {
        ArrayList<Task> tasks = taskList.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        printTasks(tasks);
        System.out.println("\nTotal tasks: " + taskList.getSize());
    }

    private static void searchTasks() {
        System.out.print("Enter title keyword to search: ");
        String keyword = scanner.nextLine().trim();

        if (keyword.isEmpty()) {
            System.out.println("Search keyword cannot be empty.");
            return;
        }

        ArrayList<Task> results = taskList.searchByTitle(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching tasks found.");
        } else {
            System.out.println("\nMatching tasks:");
            printTasks(results);
            System.out.println("Results found: " + results.size());
        }
    }

    private static void markTaskCompleted() {
        int id = readInt("Enter task ID to mark as completed: ");
        Task task = taskList.findById(id);

        if (task == null) {
            System.out.println("Task ID not found.");
        } else if (task.isCompleted()) {
            System.out.println("This task is already completed.");
        } else {
            task.markCompleted();
            System.out.println("Task marked as completed.");
        }
    }

    private static void deleteTask() {
        int id = readInt("Enter task ID to delete: ");

        if (taskList.remove(id)) {
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Task ID not found.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static void printTasks(ArrayList<Task> tasks) {
        System.out.printf("%-6s %-35s %s%n", "ID", "TASK TITLE", "STATUS");
        System.out.println("---------------------------------------------------------------");

        for (Task task : tasks) {
            System.out.println(task);
        }
    }
}
