package com.codex.controller;

import com.codex.entity.Topic;
import com.codex.entity.TopicContent;
import com.codex.repository.TopicRepository;
import com.codex.repository.TopicContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Autowired
    private TopicContentRepository topicContentRepository;

    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @GetMapping("/{topicName}")
    public ResponseEntity<?> getTopic(@PathVariable String topicName) {
        Optional<Topic> topic = topicRepository.findByName(topicName);

        if (topic.isPresent()) {
            Map<String, Object> response = new HashMap<>();
            response.put("topic", topic.get());
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{topicName}/content/{level}")
    public ResponseEntity<?> getTopicContent(
            @PathVariable String topicName,
            @PathVariable String level) {

        Optional<Topic> topic = topicRepository.findByName(topicName);
        if (topic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TopicContent> contents = topicContentRepository.findByTopicNameAndLevel(topicName, level);

        Map<String, Object> response = new HashMap<>();
        response.put("topic", topic.get());

        for (TopicContent content : contents) {
            response.put(content.getContentType(), content.getContent());
        }

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{topicName}/code-examples")
    public ResponseEntity<?> getCodeExamples(@PathVariable String topicName) {
        Optional<Topic> topic = topicRepository.findByName(topicName);
        if (topic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TopicContent> codeExamples = topicContentRepository.findRawCodeExamples(topicName);

        Map<String, Object> response = new HashMap<>();
        response.put("topic", topic.get());
        response.put("codeExamples", codeExamples);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{topicName}/tips")
    public ResponseEntity<?> getTips(@PathVariable String topicName) {
        Optional<Topic> topic = topicRepository.findByName(topicName);
        if (topic.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        List<TopicContent> tips = topicContentRepository.findTips(topicName);

        Map<String, Object> response = new HashMap<>();
        response.put("topic", topic.get());
        response.put("tips", tips);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/health")
    public String healthCheck() {
        return "✅ CodeX Backend is running!";
    }
}package com.codex.controller;

public class TopicController {
}
