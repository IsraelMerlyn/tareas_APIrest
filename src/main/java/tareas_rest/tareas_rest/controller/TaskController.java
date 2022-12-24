package tareas_rest.tareas_rest.controller;


import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import tareas_rest.tareas_rest.persistence.entity.Task;
import tareas_rest.tareas_rest.persistence.entity.TaskStatus;
import tareas_rest.tareas_rest.service.TaskService;
import tareas_rest.tareas_rest.service.dto.TaskDTO;

@RestController
@RequestMapping("/tasks")
@CrossOrigin("http:localhost:8080/")
public class TaskController {

    private  final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskDTO taskDTO){
        return this.taskService.createTask(taskDTO);
    }

    @GetMapping
    public List <Task> findAll() {
        return this.taskService.finAll();   
    }

    @GetMapping("/status/{status}")
    public List <Task> findAllByStatus(@PathVariable ("status") TaskStatus status) {
        return this.taskService.finAllByTaskStatus(status);
    }

    @PatchMapping ("/mark_as_finished/{id}")
    public ResponseEntity <Void> maskAsFinished (@PathVariable("id") Long id) {
        this.taskService.updateTaskFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity <Void> deleteTask (@PathVariable("id") Long id) {
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
