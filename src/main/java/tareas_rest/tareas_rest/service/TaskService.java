package tareas_rest.tareas_rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import tareas_rest.tareas_rest.exeptions.TodoExeptions;
import tareas_rest.tareas_rest.mapper.TaskInDTOToTask;
import tareas_rest.tareas_rest.persistence.entity.Task;
import tareas_rest.tareas_rest.persistence.entity.TaskStatus;
import tareas_rest.tareas_rest.persistence.repository.TaskRepository;
import tareas_rest.tareas_rest.service.dto.TaskDTO;

@Service
public class TaskService {

    private  final TaskRepository taskRepository;
    private  final TaskInDTOToTask mapper;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapper) {
        this.taskRepository = taskRepository;
        this.mapper = mapper;
    }

    public Task createTask(TaskDTO taskDTO){
        Task task = mapper.map(taskDTO);
        return this.taskRepository.save(task);
    }

    public List <Task> finAll() {
        return taskRepository.findAll();
    }

    public List<Task> finAllByTaskStatus(TaskStatus status) {
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskFinished(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TodoExeptions("No se encuentra la tarea", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskFinished(id);
    }

  
    public void deleteById(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TodoExeptions("No se encuentra la tarea", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }


}
