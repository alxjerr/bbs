package com.tieba.service.impl;

import com.tieba.dao.ReplyDao;
import com.tieba.dao.TopicDao;
import com.tieba.dao.impl.ReplyDaoImpl;
import com.tieba.dao.impl.TopicDaoImpl;
import com.tieba.domain.Reply;
import com.tieba.domain.Topic;
import com.tieba.service.BusinessService;

import java.util.List;

/**
 * Created by hou on 2017/5/7.
 */
public class BusinessServiceImpl implements BusinessService{
    //生命dao
    private TopicDao topicDao = new TopicDaoImpl();
    private ReplyDao replyDao = new ReplyDaoImpl();

    /**
     * 查询所有主题
     * @return
     */
    @Override
    public List<Topic> findAll() {
        return topicDao.findAll();
    }

    /**
     * 添加主题
     * @param topic
     */
    @Override
    public void addTopic(Topic topic) {
        topicDao.save(topic);
    }

    /**
     * 通过id查询主题
     * @param id
     * @return
     */
    @Override
    public Topic findTopicById(Integer id) {
        return topicDao.findById(id);
    }

    /**
     * 添加回复
     * @param reply
     */
    @Override
    public void addReply(Reply reply) {
        //修改主题的最后回复时间lastReplyDate 为reply的创建时间
        Topic topic = topicDao.findById(reply.getTopic().getId());//执行select语句，topic为持久态
        topic.setLastRelyDate(reply.getCreateDate()); //修改一级缓存,提交时快照对比，自动update
        //保存回复
        replyDao.save(reply);
    }
}
