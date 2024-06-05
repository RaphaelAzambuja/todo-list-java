package com.todolist.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tasks")
public class TaskEntity extends EntityId {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Boolean checked = false;

    @ManyToOne
    @JoinColumn(name = "list", nullable = false)
    private ListEntity listEntity;

    private TaskEntity() {}

    private TaskEntity(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
        this.checked = builder.checked;
        this.listEntity = builder.listEntity;
    }

    public String getTitle() {
        return title;
    }

    public ListEntity getListEntity() {
        return listEntity;
    }

    public String getDescription() {
        return description;
    }

    public Boolean getChecked() {
        return checked;
    }

    public static Builder builder(TaskEntity task) {
        return new Builder(task);
    }

    public static class Builder {
        private String title;
        private ListEntity listEntity;
        private String description;
        private Boolean checked;

        public Builder() {}

        public Builder(TaskEntity task) {
            this.title = task.title;
            this.description = task.description;
            this.listEntity = task.listEntity;
            this.checked = task.checked;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder listEntity(ListEntity listEntity) {
            this.listEntity = listEntity;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder checked(Boolean checked) {
            this.checked = checked;
            return this;
        }

        public TaskEntity build() {
            return new TaskEntity(this);
        }
    }
}
