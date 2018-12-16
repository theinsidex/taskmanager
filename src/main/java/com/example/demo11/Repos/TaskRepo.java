package com.example.demo11.Repos;

import com.example.demo11.domain.Task;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepo extends CrudRepository<Task,Long> {

}
