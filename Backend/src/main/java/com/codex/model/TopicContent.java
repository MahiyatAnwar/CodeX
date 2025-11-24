package com.codex.learning.model;

import jakarta.persistence.*;

@Entity
@Table(name = "topic_content")
public class TopicContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "topic_name")
    private String topicName;

    private String level;

    @Column(name = "content_type")
    private String contentType;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String language;

    // Default constructor
    public TopicContent() {}

    // Getters and Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTopicName() { return topicName; }
    public void setTopicName(String topicName) { this.topicName = topicName; }

    public String getLevel() { return level; }
    public void setLevel(String level) { this.level = level; }

    public String getContentType() { return contentType; }
    public void setContentType(String contentType) { this.contentType = contentType; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public String getLanguage() { return language; }
    public void setLanguage(String language) { this.language = language; }

    @Override
    public String toString() {
        return "TopicContent{id=" + id + ", topic='" + topicName + "', level='" + level + "'}";
    }
}