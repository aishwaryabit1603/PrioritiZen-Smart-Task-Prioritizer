package com.aishwarya.PrioritiZen.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String title;
    private String description;

    private int urgency;
    private int importance;

    private LocalDateTime createdAt;
    private LocalDate dueDate;

    // specify how field should be stored in DB
    // Stores values like "DAILY" , "WEEKLY" , "MONTHLY" in DB
    // instead of storing 0 , 1, 2;

    @Enumerated(EnumType.STRING)
    private RepeatCycle repeatCycle;

    private boolean completed;
    private boolean deleted;

    @ElementCollection
    private List<Long> dependsOn;

    private int priorityScore;

    @ElementCollection
    private List<String> tags;
}
