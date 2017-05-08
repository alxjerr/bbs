package com.tieba.service;

import com.tieba.domain.Reply;
import com.tieba.domain.Topic;

import java.util.List;

/**
 * Created by hou on 2017/5/7.
 */
public interface BusinessService {

    List<Topic> findAll();

    void addTopic(Topic topic);

    Topic findTopicById(Integer id);

    void addReply(Reply reply);
}
