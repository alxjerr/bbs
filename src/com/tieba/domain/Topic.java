package com.tieba.domain;


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Topic {

    private Integer id;

    private String ipAddr;  //IP地址(表示作者)
    private String title;   //标题
    private Date lastRelyDate; //最后回复时间
    private String topicContent; //主题内容
    private Date createDate;  //发帖时间

    //一对多：一个主题 拥有多个回复
    private Set<Reply> replySet = new HashSet<Reply>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getLastRelyDate() {
        return lastRelyDate;
    }

    public void setLastRelyDate(Date lastRelyDate) {
        this.lastRelyDate = lastRelyDate;
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<Reply> getReplySet() {
        return replySet;
    }

    public void setReplySet(Set<Reply> replySet) {
        this.replySet = replySet;
    }
}
