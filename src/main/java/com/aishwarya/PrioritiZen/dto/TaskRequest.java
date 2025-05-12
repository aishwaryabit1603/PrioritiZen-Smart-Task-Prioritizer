package com.aishwarya.PrioritiZen.dto;

import com.aishwarya.PrioritiZen.entity.RepeatCycle;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TaskRequest {
    private String title;
    private String description;
    private int urgency;
    private int importance;
    private LocalDate dueDate;
    private RepeatCycle repeatCycle;
    private String tags;
    private List<Long> dependsOn;
}
