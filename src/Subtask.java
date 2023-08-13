public class Subtask {
    protected String title;
    protected String description;
    protected String id;
    protected TaskStatus status;

    public Subtask(String title, String description, String id, TaskStatus status) {
        this.title = title;
        this.description = description;
        this.id = id;
        this.status = status;
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

    public void updateStatus(TaskStatus newStatus) {
        // апдейт статуса для Subtask
        this.status = newStatus;
    }
}
