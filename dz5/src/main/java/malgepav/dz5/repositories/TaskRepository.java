package malgepav.dz5.repositories;

import malgepav.dz5.model.Task;
import malgepav.dz5.model.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByTaskStatus(TaskStatus taskStatus);
}
