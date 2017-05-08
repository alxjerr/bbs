package com.tieba.dao.impl;

import com.tieba.dao.TopicDao;
import com.tieba.domain.Topic;
import com.tieba.utils.H3Utils;

import java.util.List;

public class TopicDaoImpl implements TopicDao{

    @Override
    public List<Topic> findAll() {
        return H3Utils.getCurrentSession().createQuery("from Topic order by lastRelyDate desc").list();
    }

    @Override
    public void save(Topic topic) {
        H3Utils.getCurrentSession().save(topic);
    }

    @Override
    public Topic findById(Integer id) {
        return (Topic) H3Utils.getCurrentSession().get(Topic.class,id);
    }
}
