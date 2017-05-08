package com.tieba.dao;

import com.tieba.domain.Topic;

import java.util.List;

/**
 * Created by hou on 2017/5/7.
 */
public interface TopicDao {

    List<Topic> findAll();

    void save(Topic topic);

    Topic findById(Integer id);

}
