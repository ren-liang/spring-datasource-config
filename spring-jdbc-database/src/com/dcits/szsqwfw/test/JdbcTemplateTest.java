package com.dcits.szsqwfw.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ApplicationContext.xml")//加载ApplicationContext.xml文件
public class JdbcTemplateTest {
	
	@Resource(name="jdbcTemplate")
	private JdbcTemplate jdbcTemplate;
    /***
     * 获取用户数量
     */
	@Test
    public void getUserCount(){
    	int rowCount = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    	System.out.println("总用户数："+rowCount);;
    }
}
