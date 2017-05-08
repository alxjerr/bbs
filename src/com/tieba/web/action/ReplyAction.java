package com.tieba.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.tieba.domain.Reply;
import com.tieba.service.BusinessService;
import com.tieba.service.impl.BusinessServiceImpl;
import org.apache.struts2.ServletActionContext;

import java.util.Date;

/**
 * Created by hou on 2017/5/7.
 */
public class ReplyAction extends ActionSupport implements ModelDriven<Reply>{
    //封装参数：添加主题内容、通过id查询
    private Reply reply = new Reply();

    @Override
    public Reply getModel() {
        return this.reply;
    }

    /*************************************/

    //声明service(action多例，请求一次new一个，每一个线程都使用自己成员遍历，不会出现线程并发问题)
    private BusinessService businessService = new BusinessServiceImpl();

    public String add(){
        //服务器生成数据
        //1.1 IP地址
        reply.setIpAddr(ServletActionContext.getRequest().getRemoteAddr());
        //1.2 创建时间
        reply.setCreateDate(new Date());

        //操作
        businessService.addReply(reply);
        return "add";
    }

}
