package com.example.wbdvCS5610sp20am3yserverjava.repositories;

import com.example.wbdvCS5610sp20am3yserverjava.models.Topic;
import com.example.wbdvCS5610sp20am3yserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TopicRepository
        extends CrudRepository<Topic, Integer> {

    @Query("SELECT topic FROM Topic topic WHERE topic.id=:topicId")
    public Topic findTopicById(
            @Param("topicId") Integer tid);

    @Query("SELECT topic FROM Topic topic")
    public List<Topic> findAllTopics();

    @Query("SELECT topic FROM Topic topic where topic.lessonId=:lessonId")
    public List<Topic> findTopicsForLesson(@Param("lessonId") String lessonId);

}
