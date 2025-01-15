package com.springboot.SpringbootDockerk8.job;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "job")
public class Job {

    private Long id;
    private String title;
    private String description;

    private String minSalary;

    private String maxSalary;

    private String location;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMinSalary() {
        return this.minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getMaxSalary() {
        return this.maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
