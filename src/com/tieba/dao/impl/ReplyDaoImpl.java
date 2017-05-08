package com.tieba.dao.impl;

import com.tieba.dao.ReplyDao;
import com.tieba.domain.Reply;
import com.tieba.utils.H3Utils;

/**
 * Created by hou on 2017/5/7.
 */
public class ReplyDaoImpl implements ReplyDao{

    @Override
    public void save(Reply reply) {
        H3Utils.getCurrentSession().save(reply);
    }
}
