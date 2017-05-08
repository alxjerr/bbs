<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>主题列表</title>
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
    <div class="menubar"></div>

    <!-- 主题列表 -->

    <table cellspacing="0">
        <tbody class="list topicList">
            <!--显示表头-->
            <tr class="title">
                <td width="25">编号</td>
                <td width="25">回复</td>
                <td width="500">标题</td>
                <td width="110">作者</td>
                <td width="145">最后回复时间</td>
            </tr>

            <!-- 显示部门列表 -->
            <s:iterator value="allTopic" status="vs"> <%-- 遍历每一个topic压入栈顶了 --%>
                <tr class="data">
                    <td class="num"><s:property value="#vs.count"></s:property></td>
                    <td class="num"><s:property value="replySet.size()"></s:property></td>
                    <td>
                        <%-- 查询详情 --%>
                        <s:a namespace="/" action="topicAction_findById">
                            <s:property value="title"></s:property>
                            <s:param name="id" value="id"></s:param>
                        </s:a>
                    </td>
                    <td class="info"><s:property value="ipAddr"/></td>
                    <td class="info"><s:property value="lastRelyDate"/></td>
                </tr>
            </s:iterator>

            <tr>
                <td colspan="5" class="num">
                    共有主题数
                    <font color="red"><s:property value="allTopic.size()"/></font>
                </td>
            </tr>
        </tbody>
    </table>

    <div style="margin-bottom: 15px"></div>

    <!-- 发表主题表单 -->
    <s:form namespace="/" action="topicAction_add" cssClass="addNewTopicForm">
        <table class="publishArticleForm">
            <tr>
                <td>标 题</td>
                <td>
                    <s:textfield name="title" cssClass="title"></s:textfield>
                </td>
            </tr>
            <tr>
                <td>内 容：</td>
                <td>
                    <s:textarea name="topicContent" cssClass="content"></s:textarea>
                </td>
            </tr>
            <tr>
                <td></td>
                <td><s:submit value="发　表"></s:submit> </td>
            </tr>
        </table>
    </s:form>
</body>
</html>
