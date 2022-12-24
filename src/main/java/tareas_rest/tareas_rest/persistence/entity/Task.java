package tareas_rest.tareas_rest.persistence.entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    private  String title;
    private  String description;
    private LocalDateTime createdDate;
    private  LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;




}
