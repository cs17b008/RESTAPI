package com.example.demo1.run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class RunRepository {

    private List<Run> runs = new ArrayList<>();

    //get all runs
    List<Run> findAll() {
        return runs;
    }


    //find by id
    Optional<Run> findById(Integer id) {
        return runs.stream().filter(run -> run.id().equals(id)).findFirst();
    }

    //adding runs
    void create(Run run) {
        runs.add(run);
    }

    //updating
    void update(Run run, Integer id) {
        Optional<Run> existingRun = findById(id);
        if (existingRun.isPresent()) {
            runs.set(runs.indexOf(existingRun.get()), run);
        }
    }

    //deleting
    void delete(Integer id) {
        runs.removeIf(run -> run.id().equals(id));
    }


    //intializing the runs
    @PostConstruct
    private void init(){
        runs.add(new Run(1,"Monday R", LocalDateTime.now(), LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 2, Location.INDOOR));
        runs.add(new Run(2,"Tuesday R", LocalDateTime.now(), LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 6, Location.INDOOR));
    
    }

}       
