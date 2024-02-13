package malgepav.dz5.controllers;

import lombok.RequiredArgsConstructor;
import malgepav.dz5.model.Task;
import malgepav.dz5.model.TaskStatus;
import malgepav.dz5.services.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/add")
    public Task addTask(@RequestBody Task task) {
        return taskService.addTask(task);
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable(name = "status") TaskStatus taskStatus) {
        return taskService.getTasksByStatus(taskStatus);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteTaskById(@PathVariable(name = "id") Long id) {
        taskService.deleteTask(id);
    }

    @PutMapping("update/{id}/{status}")
    public Task updateTaskStatus(@PathVariable(name = "id") Long id,
                                 @PathVariable(name = "status") TaskStatus taskStatus) {
        return taskService.updateTaskStatus(taskStatus, id);
    }

}
