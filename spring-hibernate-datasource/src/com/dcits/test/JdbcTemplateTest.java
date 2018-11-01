package com.dcits.test;

import java.util.Collection;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")//加载ApplicationContext.xml文件
public class JdbcTemplateTest {
	
    private SessionFactory sessionFactory;
    @Resource(name="sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
	/***
     * 获取用户数量
     */
	@Test
    public Collection  getUserCount(){
        return this.sessionFactory.getCurrentSession().createQuery("from test.Product product where product.category=?").setParameter(0, "1").list();
		
    }
}
