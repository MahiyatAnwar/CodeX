package com.codex.repository;

import com.codex.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {
    Optional<Topic> findByName(String name);
    List<Topic> findByPhase(String phase);
}package com.codex.repository;

public class TopicRepository {
}
