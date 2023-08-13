import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {
    public Map<String, Epic> epicsMap;

    public TaskManager() {
        epicsMap = new HashMap<>();
    }

    public void addEpic(Epic epic) {
        epicsMap.put(epic.getId(), epic);
    }

    public void removeEpic(String epicId) {
        epicsMap.remove(epicId);
    }

    public Epic getEpicById(String epicId) {
        return epicsMap.get(epicId);
    }

    public List<Epic> getAllEpics() {
        return new ArrayList<>(epicsMap.values());
    }

    public void updateEpic(Epic updatedEpic) {
        epicsMap.put(updatedEpic.getId(), updatedEpic);
    }
}
