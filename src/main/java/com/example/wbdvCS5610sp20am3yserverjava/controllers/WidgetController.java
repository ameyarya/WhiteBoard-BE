package com.example.wbdvCS5610sp20am3yserverjava.controllers;

import com.example.wbdvCS5610sp20am3yserverjava.models.Widget;
import com.example.wbdvCS5610sp20am3yserverjava.services.TopicService;
import com.example.wbdvCS5610sp20am3yserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService widgetService;

    @Autowired
    TopicService topicService;

    @PostMapping("topics/{tid}/widgets")
    public Widget createWidgetForTopic(
            @PathVariable("tid") Integer tid,
            @RequestBody Widget newWidget) {
        return widgetService.createWidgetForTopic(tid, newWidget);
    }

    @GetMapping("/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer wid) {
        return widgetService.findWidgetById(wid);
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }

    @GetMapping("/topics/{tid}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("tid") Integer topicId) {
        return widgetService.findWidgetsForTopic(topicId);
    }

    @PutMapping("/widgets/{widgetId}")
    public int updateWidget(
            @PathVariable("widgetId") Integer wid,
            @RequestBody Widget updatedWidget) {
        return widgetService.updateWidget(wid, updatedWidget);
    }

    @DeleteMapping("/widgets/{widgetId}")
    public int deleteWidget(
            @PathVariable("widgetId") Integer wid) {
        return widgetService.deleteWidget(wid);
    }

}
