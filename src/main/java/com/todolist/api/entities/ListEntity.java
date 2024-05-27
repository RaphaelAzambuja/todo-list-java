package com.todolist.api.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Lists")
public class ListEntity extends EntityId{
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    private ListEntity() {}

    private ListEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder {
        private String title;
        private String description;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public ListEntity build() {
            return new ListEntity(title, description);
        }
    }

}
