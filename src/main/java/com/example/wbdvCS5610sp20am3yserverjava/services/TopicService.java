package com.example.wbdvCS5610sp20am3yserverjava.services;

import com.example.wbdvCS5610sp20am3yserverjava.models.Topic;
import com.example.wbdvCS5610sp20am3yserverjava.models.Widget;
import com.example.wbdvCS5610sp20am3yserverjava.repositories.TopicRepository;
import com.example.wbdvCS5610sp20am3yserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    TopicRepository topicRepository;

    @Autowired
    WidgetRepository widgetRepository;

    public Topic createTopic(Topic newTopic) {
        return topicRepository.save(newTopic);
    }

    public List<Topic> findAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }

    public Topic findTopicById(int tid) {
        return topicRepository.findById(tid).get();
    }

    public List<Topic> findTopicsForLesson(String lessonId) {
        return topicRepository.findTopicsForLesson(lessonId);
    }

    public Integer updateTopic(Integer tid, Topic newTopic) {
        Topic oldTopic = topicRepository.findTopicById(tid);
        oldTopic.setTitle(newTopic.getTitle());
        topicRepository.save(oldTopic);
        return 1;
    }

    public int deleteTopic(int tid) {
        topicRepository.deleteById(tid);
        return 1;
    }

}
