package com.todolist.api.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lists")
public class ListEntity extends EntityId {
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "listEntity")
    private List<TaskEntity> tasks;

    private ListEntity() {}

    private ListEntity(Builder builder) {
        this.title = builder.title;
        this.description = builder.description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static Builder builder(ListEntity listEntity) {
        return new Builder(listEntity);
    }

    public static class Builder {
        private String title;
        private String description;

        public Builder() {}

        public Builder(ListEntity listEntity) {
            this.title = listEntity.title;
            this.description = listEntity.description;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ListEntity build() {
            return new ListEntity(this);
        }
    }
}
