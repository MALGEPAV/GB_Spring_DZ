package malgepav.dz5.services;

import lombok.RequiredArgsConstructor;
import malgepav.dz5.model.Task;
import malgepav.dz5.model.TaskStatus;
import malgepav.dz5.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> getTasksByStatus(TaskStatus taskStatus) {
        return taskRepository.findByTaskStatus(taskStatus);
    }

    public Task updateTaskStatus(TaskStatus taskStatus, Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task retrievedTask = optionalTask.get();
            retrievedTask.setTaskStatus(taskStatus);
            taskRepository.save(retrievedTask);
            return retrievedTask;
        } else {
            return null;
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
