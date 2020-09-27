package com.example.wbdvCS5610sp20am3yserverjava.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
@Table(name = "widgets")
public class Widget {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;
    private String type = "HEADING";
    private int size = 2;
    private int orderWidget;

    public int getOrderWidget() {
        return orderWidget;
    }

    public void setOrderWidget(int orderWidget) {
        this.orderWidget = orderWidget;
    }

    @ManyToOne
    @JsonIgnore
    private Topic topic;

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Widget(Integer id, String title, String type) {
        this.id = id;
        this.title = title;
        this.type = type;
    }

    public Widget() {
    }

}
