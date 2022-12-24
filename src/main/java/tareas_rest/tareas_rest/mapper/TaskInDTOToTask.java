package tareas_rest.tareas_rest.mapper;

import org.springframework.stereotype.Component;
import tareas_rest.tareas_rest.persistence.entity.Task;
import tareas_rest.tareas_rest.persistence.entity.TaskStatus;
import tareas_rest.tareas_rest.service.dto.TaskDTO;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements  IMapper<TaskDTO, Task>{


    @Override
    public Task map(TaskDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setEta(in.getEta());
        task.setCreatedDate(LocalDateTime.now());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
