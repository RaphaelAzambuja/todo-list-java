package com.todolist.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class Task extends EntityId{
    @Column(nullable = false)
    private String title;
    
    @ManyToOne
    @JoinColumn(name="list_id", nullable = false)
    private List listEntity;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean checked = false;

    public Task() {}

    public Task(String title, List listEntity, String description, Boolean checked) {
        this.title = title;
        this.listEntity = listEntity;
        this.description = description;
        this.checked = checked;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List getListEntity() {
        return listEntity;
    }

    public void setListEntity(List listEntity) {
        this.listEntity = listEntity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getChecked() {
        return checked;
    }

    public void setChecked(Boolean checked) {
        this.checked = checked;
    }
}
