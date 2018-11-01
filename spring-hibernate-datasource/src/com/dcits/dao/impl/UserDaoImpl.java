package com.dcits.dao.impl;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.dcits.dao.UserDao;
import com.dcits.model.User;
/***
 * Dao实现类
 * @author 任亮
 *
 */
@Repository("userDao")
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	@Resource(name="hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

/*    @Autowired//自动按照类型注入数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
	public void setJdbcTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	public User findUserById(int id){
		return null;
	}
	/***
	 * 查询某个人员信息
	 * 
	 * @param object
	 */
	public Object getUsers(final String HQL) {
		return super.getHibernateTemplate().execute(
				new HibernateCallback<Object>() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery(HQL).uniqueResult();
					}
				});
	}
    /***
     * 查询多个用户
     */
    public List<?> findUsers(final String HQL) {
		return super.getHibernateTemplate().executeFind(
				new HibernateCallback<List<?>>() {
					public List<?> doInHibernate(Session session)
							throws HibernateException, SQLException {
						return session.createQuery(HQL).list();
					}
				});
    }
    
	/***
	 * 添加人员信息
	 * 
	 * @param object
	 */
	public void addUsers(Object object) {
		super.getHibernateTemplate().save(object);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	
	/***
	 * 更新人员信息
	 * 
	 * @param object
	 */
	public void updateUsers(Object object) {
		super.getHibernateTemplate().update(object);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}
	
	/***
	 * 删除人员信息
	 * 
	 * @param object
	 */
	public void deleteUsers(Object object) {
		super.getHibernateTemplate().delete(object);
		super.getHibernateTemplate().flush();
		super.getHibernateTemplate().clear();
	}


}
