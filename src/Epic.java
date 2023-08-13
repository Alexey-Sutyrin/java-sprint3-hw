import java.util.List;

public class Epic {
    protected String title;
    protected String description;
    protected String id;
    protected TaskStatus status;
    protected List<Task> tasks;

    public Epic(String title, String description, String id, TaskStatus status, List<Task> tasks) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void updateStatus() {
        boolean allDone = true;
        boolean hasInProgress = false;

        for (Task task : tasks) {
            task.updateStatus();
            if (task.getStatus() != TaskStatus.DONE) {
                allDone = false;
                if (task.getStatus() == TaskStatus.IN_PROGRESS) {
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
