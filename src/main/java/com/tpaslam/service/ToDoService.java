package com.tpaslam.service;

import com.tpaslam.dal.model.ToDo;
import com.tpaslam.dal.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class ToDoService {

    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> fetchAll(){
        return toDoRepository.findAll();
    }

    @Transactional
    public Long deleteRecord(Long id){
        return toDoRepository.deleteById(id);
    }

    @Transactional
    public ToDo save(ToDo toDo){
        return toDoRepository.save(toDo);
    }
}
