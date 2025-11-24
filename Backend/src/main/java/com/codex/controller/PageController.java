package com.codex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String home() {
        return "pages/home";  // Make sure this matches your file location
    }

    @GetMapping("/learning-plan")
    public String learningPlan() {
        return "pages/learning-plan";
    }

    @GetMapping("/problems")
    public String problems() {
        return "pages/problems";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "pages/dashboard";
    }

    @GetMapping("/topics")
    public String topics() {
        return "pages/topics";
    }

    @GetMapping("/login")
    public String login() {
        return "pages/auth/login";
    }

    @GetMapping("/register")
    public String register() {
        return "pages/auth/register";
    }
    package com.codex.learning.controller;

import com.codex.learning.model.Topic;
import com.codex.learning.model.TopicContent;
import com.codex.learning.repository.TopicRepository;
import com.codex.learning.repository.TopicContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

    @Controller
    public class PageController {

        @Autowired
        private TopicRepository topicRepository;

        @Autowired
        private TopicContentRepository topicContentRepository;

        // 1. Show learning plan page
        @GetMapping("/learning-plan")
        public String showLearningPlan(Model model) {
            List<Topic> topics = topicRepository.findAll();
            model.addAttribute("topics", topics);
            return "learning-plan"; // Returns learning-plan.html
        }

        // 2. Show topic main page
        @GetMapping("/topics/{topicName}")
        public String showTopic(@PathVariable String topicName, Model model) {
            Optional<Topic> topic = topicRepository.findByName(topicName);

            if (topic.isPresent()) {
                model.addAttribute("topic", topic.get());
                return "topics/topic"; // Returns topics/topic.html
            } else {
                return "error"; // You can create an error page
            }
        }

        // 3. Show basic level content
        @GetMapping("/topics/{topicName}/basic")
        public String showBasicContent(@PathVariable String topicName, Model model) {
            return showContent(topicName, "basic", model);
        }

        // 4. Show intermediate level content
        @GetMapping("/topics/{topicName}/intermediate")
        public String showIntermediateContent(@PathVariable String topicName, Model model) {
            return showContent(topicName, "intermediate", model);
        }

        // 5. Show advanced level content
        @GetMapping("/topics/{topicName}/advanced")
        public String showAdvancedContent(@PathVariable String topicName, Model model) {
            return showContent(topicName, "advanced", model);
        }

        // 6. Show code examples
        @GetMapping("/topics/{topicName}/code")
        public String showCodeExamples(@PathVariable String topicName, Model model) {
            Optional<Topic> topic = topicRepository.findByName(topicName);
            if (topic.isPresent()) {
                List<TopicContent> codeExamples = topicContentRepository.findRawCodeExamples(topicName);
                model.addAttribute("topic", topic.get());
                model.addAttribute("codeExamples", codeExamples);
                return "topics/content/code"; // Returns code examples page
            }
            return "error";
        }

        // 7. Show tips
        @GetMapping("/topics/{topicName}/tips")
        public String showTips(@PathVariable String topicName, Model model) {
            Optional<Topic> topic = topicRepository.findByName(topicName);
            if (topic.isPresent()) {
                List<TopicContent> tips = topicContentRepository.findTips(topicName);
                model.addAttribute("topic", topic.get());
                model.addAttribute("tips", tips);
                return "topics/content/tips"; // Returns tips page
            }
            return "error";
        }

        // Helper method to load content
        private String showContent(String topicName, String level, Model model) {
            Optional<Topic> topic = topicRepository.findByName(topicName);
            if (topic.isPresent()) {
                List<TopicContent> contents = topicContentRepository.findByTopicNameAndLevel(topicName, level);

                model.addAttribute("topic", topic.get());
                model.addAttribute("level", level);
                model.addAttribute("contents", contents);

                return "topics/content/" + level; // Returns basic.html, intermediate.html, etc.
            }
            return "error";
        }
    }
}