package com.example.wbdvCS5610sp20am3yserverjava.controllers;

import com.example.wbdvCS5610sp20am3yserverjava.models.Topic;
import com.example.wbdvCS5610sp20am3yserverjava.services.TopicService;
import com.example.wbdvCS5610sp20am3yserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;

    @Autowired
    WidgetService widgetService;

    @PostMapping("lessons/{lid}/topics")
    public Topic createTopicForLesson(
            @PathVariable("lid") String lessonId,
            @RequestBody Topic newTopic
    ) {
        newTopic.setLessonId(lessonId);
        return topicService.createTopic(newTopic);
    }

    @GetMapping("topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }

    @GetMapping("lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") String lessonId) {
        return topicService.findTopicsForLesson(lessonId);
    }

    @GetMapping("/topics/{topicId}")
    public Topic findTopicById(
            @PathVariable("topicId") Integer topicId) {
        return topicService.findTopicById(topicId);
    }

    @PutMapping("/topics/{topicId}")
    public int updateTopic(
            @PathVariable("topicId") Integer topicId,
            @RequestBody Topic updateTopic) {
        return topicService.updateTopic(topicId, updateTopic);
    }

    @DeleteMapping("/topics/{topicId}")
    public int deleteTopic(
            @PathVariable("topicId") Integer tid) {
        return topicService.deleteTopic(tid);
    }

}
