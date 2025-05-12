package com.aishwarya.PrioritiZen.repository;

import com.aishwarya.PrioritiZen.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// repository interface for atsk entity
// we don't need to write SQL Queries manually

public interface TaskRepository extends JpaRepository<Task, Long> {

    // CUSTOM FEATURES BEYONG BASIC CRUD
    // findAllByDeletedFalse() : perform soft delete that is when user deletes
    // a task , we are not removing it from DB we are just marking it deleted = true

    List<Task> findAllByDeletedFalse();


    // suppprt tag based Filtering
    // user wants to filter all tasks regarding a string
    // so it will be a substring match

    List<Task> findByTagsContaining(String tag);
}
