package malgepav.dz5.services;

import malgepav.dz5.model.Task;
import malgepav.dz5.model.TaskStatus;
import malgepav.dz5.repositories.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@SpringBootTest
public class TaskServiceIntegratedTest {
    @MockBean
    private TaskRepository taskRepository;

    @Autowired
    private TaskService taskService;

    @Test
    public void taskUpdateTaskStatusTest() {
        //Предпосылка

        Task task = new Task();
        task.setId(1L);
        task.setTaskStatus(TaskStatus.NOT_STARTED);

        given(taskRepository.findById(1L)).willReturn(Optional.of(task));

        //Вызов

        taskService.updateTaskStatus(TaskStatus.IN_PROGRESS, 1L);

        //Проверка

        assertEquals(TaskStatus.IN_PROGRESS, taskRepository.findById(1L).get().getTaskStatus());

    }
}
