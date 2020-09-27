package com.example.wbdvCS5610sp20am3yserverjava.services;

import com.example.wbdvCS5610sp20am3yserverjava.models.Topic;
import com.example.wbdvCS5610sp20am3yserverjava.models.Widget;
import com.example.wbdvCS5610sp20am3yserverjava.repositories.TopicRepository;
import com.example.wbdvCS5610sp20am3yserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository widgetRepository;

    @Autowired
    TopicRepository topicRepository;

    public Widget createWidget(Integer topicId, Widget widget) {
        Topic topic = topicRepository.findById(topicId).get();
        List<Widget> listWid = widgetRepository.findWidgetsForTopic(topicId);
        widget.setTopic(topic);
        widget.setOrderWidget(listWid.size() + 1);
        return widgetRepository.save(widget);
    }

    public Widget createWidgetForTopic(
            Integer tid,
            Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        List<Widget> listWid = widgetRepository.findWidgetsForTopic(tid);
        newWidget.setTopic(topic);
        newWidget.setOrderWidget(listWid.size() + 1);
        return widgetRepository.save(newWidget);
    }

    public Widget findWidgetById(Integer wid) {
        return widgetRepository.findById(wid).get();
    }

    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    public List<Widget> findWidgetsForTopic(Integer topicId) {
        Topic topic = topicRepository.findById(topicId).get();
        return topic.getWidgets();
    }

    public Integer updateWidget(Integer widgetId, Widget updatedWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(widgetId);
        oldWidget.setTitle(updatedWidget.getTitle());
        oldWidget.setSize(updatedWidget.getSize());
        oldWidget.setType(updatedWidget.getType());
        oldWidget.setOrderWidget(updatedWidget.getOrderWidget());
        widgetRepository.save(oldWidget);
        return 1;
    }

    public Integer deleteWidget(Integer wid) {
        widgetRepository.deleteById(wid);
        return 1;
    }

}
