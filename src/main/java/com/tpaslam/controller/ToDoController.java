package com.tpaslam.controller;

import com.tpaslam.dal.model.ToDo;
import com.tpaslam.dal.repository.ToDoRepository;
import com.tpaslam.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoService toDoService;

    @RequestMapping(value = "/fetchall", method = RequestMethod.GET)
    public List<ToDo> getToDoList(){		
        return toDoService.fetchAll();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public Long getToDoList(@PathVariable("id") Long id){
        return toDoService.deleteRecord(id);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ToDo getToDoList(@RequestBody ToDo toDo){
        return toDoService.save(toDo);
    }
}
