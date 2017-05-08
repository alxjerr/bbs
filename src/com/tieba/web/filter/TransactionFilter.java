package com.tieba.web.filter;


import com.tieba.utils.H3Utils;
import org.hibernate.Session;

import javax.servlet.*;
import java.io.IOException;

public class TransactionFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //1.获得session
        Session session = H3Utils.getCurrentSession();
        try {
            //2. 开启事务
            session.beginTransaction();

            //放行
            filterChain.doFilter(servletRequest,servletResponse);
            //3.1提交事务
            session.getTransaction().commit();
        }catch (Exception e){
            //3.2 回滚事务
            session.getTransaction().rollback();
            //友好页面(抛)
            throw new RuntimeException(e);
        }
    }

    @Override
    public void destroy() {

    }
}
