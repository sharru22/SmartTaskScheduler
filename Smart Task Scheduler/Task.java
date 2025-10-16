
import java.io.Serializable;
import java.time.LocalDateTime;

public class Task implements Comparable<Task>, Serializable {
    private String title;
    private int priority; // 1 = High, 2 = Medium, 3 = Low
    private LocalDateTime deadline;

    public Task(String title, int priority, LocalDateTime deadline) {
        this.title = title;
        this.priority = priority;
        this.deadline = deadline;
    }

    public String getTitle() { return title; }
    public int getPriority() { return priority; }
    public LocalDateTime getDeadline() { return deadline; }

    @Override
    public int compareTo(Task other) {
        // Sort by priority first, then by deadline
        if (this.priority != other.priority) {
            return Integer.compare(this.priority, other.priority);
        }
        return this.deadline.compareTo(other.deadline);
    }

    @Override
    public String toString() {
        return "Task: " + title + " | Priority: " + priority + " | Deadline: " + deadline;
    }
}
