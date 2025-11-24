package com.codex.repository;

import com.codex.entity.TopicContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicContentRepository extends JpaRepository<TopicContent, Integer> {
    List<TopicContent> findByTopicNameAndLevel(String topicName, String level);

    @Query("SELECT tc FROM TopicContent tc WHERE tc.topicName = :topicName AND tc.contentType = 'raw_code'")
    List<TopicContent> findRawCodeExamples(@Param("topicName") String topicName);

    @Query("SELECT tc FROM TopicContent tc WHERE tc.topicName = :topicName AND tc.contentType = 'tips'")
    List<TopicContent> findTips(@Param("topicName") String topicName);
}