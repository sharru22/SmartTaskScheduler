

import java.io.*;
import java.util.PriorityQueue;

public class TaskManager {
    private PriorityQueue<Task> taskQueue;
    private final String FILE_NAME = "tasks.dat";

    public TaskManager() {
        taskQueue = new PriorityQueue<>();
        loadTasks();
    }

    public void addTask(Task task) {
        taskQueue.add(task);
        saveTasks();
    }

    public void removeTask(Task task) {
        taskQueue.remove(task);
        saveTasks();
    }

    public PriorityQueue<Task> getTasks() {
        return taskQueue;
    }

    // Save tasks to file
    private void saveTasks() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(new PriorityQueue<>(taskQueue));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load tasks from file
    private void loadTasks() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            taskQueue = (PriorityQueue<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            taskQueue = new PriorityQueue<>();
        }
    }
}
