package com.aishwarya.PrioritiZen.service;

import com.aishwarya.PrioritiZen.dto.TaskRequest;
import com.aishwarya.PrioritiZen.entity.Task;
import com.aishwarya.PrioritiZen.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TaskService {

    // ALl Tasks
    // 1. Creating tasks
    // 2. Auto-scoring priorities
    // 3. Handling soft delete
    // 4. Filtering by tags
    // 5. Updating recurring task
    // 6. Supporting undo delete

    private final TaskRepository taskRepository;

    public Task createTask(TaskRequest request){
        Task task = Task.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .urgency(request.getUrgency())
                .importance(request.getImportance())
                .dueDate(request.getDueDate())
                .repeatCycle(request.getRepeatCycle())
                .tags(request.getTags())
                .dependsOn(request.getDependsOn())
                .createdAt(LocalDateTime.now())
                .priorityScore(calculatePriority(request.getUrgency(), request.getImportance(), request.getDueDate()))
                .deleted(false)
                .completed(false)
                .build();

        return taskRepository.save(task);
    }

    public List<Task> getAllActiveTasks() {
        return taskRepository.findAllByDeletedFalse();
    }

}
