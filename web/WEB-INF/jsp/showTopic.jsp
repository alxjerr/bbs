<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>详情专区</title>
    <link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
    <!-- 简单搜索表单 -->
    <div style="margin: 15px auto; " >
        <!-- 搜索表单 -->
        <form action="" class="simpleSearchForm" onsubmit="alert('暂不支持此功能！');return false;">
            <font class="logoLabel">山科大贴吧</font>
            <input type="text" name="queryString" class="queryString"/>
            <input type="submit" value="搜 索" />
        </form>
    </div>

    <!-- 菜单 -->
    <div class="menubar">
        <s:a namespace="/" action="topicAction_findAll">主题列表 </s:a>
    </div>

    <!-- 当前主题帖数 -->
    <div style="padding: 10px 30px; font-size: 12px; font-family:'宋体'">
        共有<font color="red"><s:property value="#findTopic.replySet.size() + 1"/></font>篇帖子
    </div>

    <!-- 显示主题 -->
    <table class="postList" cellspacing="0">
        <tr class="title">
            <td width="20" class="num">1</td>
            <td><s:property value="#findTopic.title"/></td>
        </tr>
        <tr class="info">
            <td></td>
            <td>
                作者：
                <font color="blue"><s:property value="#findTopic.ipAddr"/></font> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <font color="999999">发帖时间：<s:date name="#findTopic.createDate"/></font>
            </td>
        </tr>
    </table>

    <!-- 显示回复列表 -->
    <s:iterator value="#findTopic.replySet" var="reply" status="vs">
        <table color="postList" cellpadding="0">
            <tr class="title">
                <td width="20" class="num"><s:property value="#vs.count + 1"/></td>
                <td></td>
            </tr>
            <tr class="content">
                <td></td>
                <td><pre><s:property value="#reply.replyContent"/></pre></td>
            </tr>
            <tr class="info">
                <td></td>
                <td>
                    作者：
                    <font color="blue"><s:property value="#reply.ipAddr"/></font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                    <font color="#999999">回帖时间:<s:date name="#reply.createDate"/></font>
                </td>
            </tr>
        </table>
    </s:iterator>

    <div style="margin-bottom:20px"></div>
    <!-- 发表回复表单 -->
    <s:form namespace="/" action="replyAction_add" cssClass="addNewTopicForm">
        <%-- 确定当前主题 --%>
        <s:hidden name="topic.id" value="%{#findTopic.id}"></s:hidden>
        <table class="publishArticleForm">
            <tr>
                <td class="label">内 容：</td>
                <td>
                    <s:textfield name="replyContent" cssClass="content"></s:textfield>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><s:submit value="回  帖"></s:submit> </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
