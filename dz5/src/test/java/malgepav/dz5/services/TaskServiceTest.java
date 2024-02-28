package malgepav.dz5.services;

import malgepav.dz5.model.Task;
import malgepav.dz5.model.TaskStatus;
import malgepav.dz5.repositories.TaskRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

import static org.mockito.Mockito.mock;


class TaskServiceTest {
    @Test
    public void taskUpdateTaskStatusTest() {
        //Предпосылка
        TaskRepository taskRepository = mock(TaskRepository.class);
        TaskService taskService = new TaskService(taskRepository);
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