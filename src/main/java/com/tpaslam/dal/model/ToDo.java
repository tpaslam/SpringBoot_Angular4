package com.tpaslam.dal.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;

@Entity
@Table(name = "TO_DO_LIST")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "todotext",
        "status"
})
public class ToDo {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    @JsonProperty("id")
    private Long id;

    @Column(name = "TO_DO")
    @JsonProperty("todotext")
    private String todoText;

    @Column(name = "STATUS")
    @JsonProperty("status")
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTodoText() {
        return todoText;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", todoText='" + todoText + '\'' +
                ", status=" + status +
                '}';
    }
}
