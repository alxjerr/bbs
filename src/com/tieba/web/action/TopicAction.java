package com.tieba.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tieba.domain.Topic;
import com.tieba.service.BusinessService;
import com.tieba.service.impl.BusinessServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.Date;
import java.util.List;

/**
 * Created by hou on 2017/5/7.
 */
public class TopicAction extends ActionSupport implements ModelDriven<Topic> {
    //封装参数：添加主题内容、通过id查询
    private Topic topic = new Topic();

    @Override
    public Topic getModel() {
        return this.topic;
    }

    /****************************************************/

    //声明service
    //action多例，请求一次new一个，每一个线程都使用自己成员遍历，不会出现线程并发问题
    //servlet 单例
    private BusinessService businessService = new BusinessServiceImpl();

    /**
     * 查询所有主题
     *
     * @return
     */
    public String findAll() {
        //1.查询所有
        List<Topic> allTopic = businessService.findAll();
        //将查询数据存到值栈中，root/context
        // * root ,1 push 压入栈顶，jsp页面 使用关键字top
        //         2 set(key,value),jsp通过"key"获得
        ActionContext.getContext().getValueStack().set("allTopic", allTopic);
        return "findAll";
    }

    /**
     * 添加主题
     *
     * @return
     */
    public String add() {
        //生成服务器端数据
        //1.1 创建时间
        topic.setCreateDate(new Date());
        //1.2 最后回复时间
        topic.setLastRelyDate(topic.getCreateDate());
        //1.3 ip地址
        topic.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());

        //添加
        businessService.addTopic(topic);
        return "add";
    }

    /**
     * 通过id查询主题
     *
     * @return
     */
    public String findById() {
        //通过id查询
        Topic findTopic = businessService.findTopicById(topic.getId());
        //将结果存放到值栈中，存放content.put(key,value),jsp 通过"#key"获得
        ActionContext.getContext().put("findTopic", findTopic);
        return "findById";
    }
}