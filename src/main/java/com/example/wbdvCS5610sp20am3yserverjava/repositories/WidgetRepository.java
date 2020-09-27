package com.example.wbdvCS5610sp20am3yserverjava.repositories;

import com.example.wbdvCS5610sp20am3yserverjava.models.Widget;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

    @Query("SELECT widget FROM Widget widget WHERE widget.id=:widgetId")
    public Widget findWidgetById(
            @Param("widgetId") int wid);

    @Query("SELECT widget FROM Widget widget")
    public List<Widget> findAllWidgets();

    @Query(value = "SELECT * FROM widgets WHERE topic_id=:tid", nativeQuery = true)
    public List<Widget> findWidgetsForTopic(@Param("tid") Integer topicId);

}
