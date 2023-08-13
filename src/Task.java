import java.util.List;

public class Task {
    protected String title;
    protected String description;
    protected String id;
    protected TaskStatus status;
    protected List<Subtask> subtasks;

    public Task(String title, String description, String id, TaskStatus status, List<Subtask> subtasks) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
        this.subtasks = subtasks;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getId() {
        return id;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public List<Subtask> getSubtasks() {
        return subtasks;
    }

    public void updateStatus() {
        boolean allDone = true;
        boolean hasInProgress = false;

        for (Subtask subtask : subtasks) {
            if (subtask.getStatus() != TaskStatus.DONE) {
                allDone = false;
                if (subtask.getStatus() == TaskStatus.IN_PROGRESS) {
                    hasInProgress = true;
                }
            }
        }

        if (allDone) {
            status = TaskStatus.DONE;
        } else if (hasInProgress) {
            status = TaskStatus.IN_PROGRESS;
        } else {
            status = TaskStatus.NEW;
        }
    }
}
