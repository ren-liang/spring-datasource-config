package com.dcits.szsqwfw.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.dcits.szsqwfw.model.User;
/***
 * Dao实现类
 * @author 任亮
 *
 */
@Repository("userDao")
public class UserDaoImpl implements UserDao {
	@Resource(name="jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

/*    @Autowired//自动按照类型注入数据源
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }*/
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
    /***
     * 根据Id查找用户
     */
    public User findUserById(int id) {
    	User user = jdbcTemplate.queryForObject(
    	        "SELECT * FROM user where id= ?",
    	        new Object[]{id},
    	        new RowMapper<User>() {
    	            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
    	            	User user = new User();
    	            	user.setName(rs.getString("name"));
    	                return user;
    	            }
    	        });
    	return user;
        }
    /***
     * 查询所有用户
     */
    public List<User> findAllUsers() {
    	
        return this.jdbcTemplate.query( "select u.name,u.password from user u", new UserMapper());
    }
  //使用自定义类实现RowMapper接口，实现映射
    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        	User user = new User();
        	user.setName(rs.getString("name"));
        	user.setPassword(rs.getString("password"));
            return user;
        }
    }
    /***
     * 获取用户数量
     */
    public int getUserCount(){
    	int rowCount = jdbcTemplate.queryForObject("select count(*) from user", Integer.class);
    	return rowCount;
    }
    /***
     * 获取姓名模糊查询的用户数
     */
    public int getSomeUserCount(String name){
    	int countOfuser = jdbcTemplate.queryForObject("select count(*) from user where name like ?", Integer.class, "%"+name+"%");
    	return countOfuser;
    	
    }
    /***
     * 更新用户
     */
    public void updateUser(User user){
    	jdbcTemplate.update("update user set name = ? where id = ?",user.getName(), user.getId());
    }
    /***
     * 保存用户
     */
    public void saveUser(User user){
    	jdbcTemplate.update("insert into user (name, password) values (?, ?)",
    	        user.getName(), user.getPassword());
    }
    /***
     * 删除用户
     */
    public void deleteUser(User user){
    	int id = user.getId();
    	jdbcTemplate.update("delete from user where id = ?",Integer.valueOf(id));
    }
}
