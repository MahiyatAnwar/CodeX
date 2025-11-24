package com.codex.learning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String title;

    private String description;
    private String difficulty;
    private String duration;
    private String phase;

    // Default constructor (required by JPA)
    public Topic() {}

    // Constructor with parameters
    public Topic(String name, String title, String description, String difficulty, String duration, String phase) {
        this.name = name;
        this.title = title;
        this.description = description;
        this.difficulty = difficulty;
        this.duration = duration;
        this.phase = phase;
    }

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    public String getDuration() { return duration; }
    public void setDuration(String duration) { this.duration = duration; }

    public String getPhase() { return phase; }
    public void setPhase(String phase) { this.phase = phase; }

    // toString method for debugging
    @Override
    public String toString() {
        return "Topic{id=" + id + ", name='" + name + "', title='" + title + "'}";
    }
}