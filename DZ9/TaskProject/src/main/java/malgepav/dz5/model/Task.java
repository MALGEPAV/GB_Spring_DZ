package malgepav.dz5.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private TaskStatus taskStatus;

    @Column(nullable = false)
    private final LocalDateTime creationTime = LocalDateTime.now();

    //    public Task(String description, TaskStatus taskStatus){
//        this.description = description;
//        this.taskStatus = taskStatus;
//        this.creationTime = LocalDateTime.now();
//    }
    private Task() {

    }
}
