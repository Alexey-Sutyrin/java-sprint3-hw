import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        Subtask subtask1 = new Subtask("Subtask 1", "Description subtask 1", "s1", TaskStatus.NEW);
        Subtask subtask2 = new Subtask("Subtask 2", "Description subtask 2", "s2", TaskStatus.NEW);
        Subtask subtask3 = new Subtask("Subtask 3", "Description subtask 3", "s3", TaskStatus.NEW);
        Subtask subtask4 = new Subtask("Subtask 4", "Description subtask 4", "s4", TaskStatus.NEW);

        Task task1 = new Task("Task 1", "Description 1", "t1", TaskStatus.NEW, Arrays.asList(subtask1, subtask2));
        Task task2 = new Task("Task 2", "Description 2", "t2", TaskStatus.NEW, Arrays.asList(subtask3, subtask4));

        Epic epic1 = new Epic("Epic 1", "Description epic 1", "e1", TaskStatus.NEW, Arrays.asList(task1, task2));

        taskManager.addEpic(epic1);

        System.out.println("Все задачи:");
        for (Epic epic : taskManager.getAllEpics()) {
            epic.updateStatus();
            System.out.println(epic.getTitle() + " - " + epic.getStatus());
            for (Task epicTask : epic.getTasks()) {
                epicTask.updateStatus();
                System.out.println("  " + epicTask.getTitle() + " - " + epicTask.getStatus());
                if (epicTask instanceof Task) {
                    Task taskWithSubtasks = (Task) epicTask;
                    for (Subtask subtask : taskWithSubtasks.getSubtasks()) {
//                        subtask.updateStatus();
                        System.out.println("    " + subtask.getTitle() + " - " + subtask.getStatus());
                    }
                }
            }
        }

        System.out.println("--------------------------------------------");

        subtask3.updateStatus(TaskStatus.DONE);
        subtask4.updateStatus(TaskStatus.DONE);


        task2.updateStatus(); // Тестовая проверка - изменение Subtask 3 и Subtask 4



        System.out.println("Все задачи - сверка изменения статуса:");
        for (Epic epic : taskManager.getAllEpics()) {
            epic.updateStatus();
            System.out.println(epic.getTitle() + " - " + epic.getStatus());
            for (Task epicTask : epic.getTasks()) {
                epicTask.updateStatus();
                System.out.println("  " + epicTask.getTitle() + " - " + epicTask.getStatus());
                if (epicTask instanceof Task) {
                    Task taskWithSubtasks = (Task) epicTask;
                    for (Subtask subtask : taskWithSubtasks.getSubtasks()) {
//                      subtask.updateStatus();
                        System.out.println("    " + subtask.getTitle() + " - " + subtask.getStatus());
                    }
                }
            }
        }
    }
}


