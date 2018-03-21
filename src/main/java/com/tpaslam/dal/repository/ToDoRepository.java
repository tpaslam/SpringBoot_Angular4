package com.tpaslam.dal.repository;

import com.tpaslam.dal.model.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    List<ToDo> findAll();
    Long deleteById(Long id);
}
