package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository     // 通过spring注解定义一个DAO
public class UserDao {

    /**
     * 查询用户数量sql语句
     */
    private final String QUERY_COUNT_SQL = "SELECT count(*) FROM t_user WHERE user_name = ? AND password = ?";

    /**
     * 查询玩家sql语句
     */
    private final String FIND_USER_SQL = "SELECT user_id,user_name,credits FROM t_user WHERE user_name =? ";

    /**
     * 更新玩家信息
     */
    private final String UPDATE_LOGIN_INFO_SQL = "UPDATE t_user SET last_visit=?,last_ip=?,credits=?  WHERE user_id =?";

    private JdbcTemplate jdbcTemplate;

    @Autowired      // 自动注入JdbcTemplate的Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 查询匹配的用户数量
     * @param userName      用户名
     * @param password      密码
     * @return              返回用户数量
     */
    public int getMatchCount(String userName, String password)
    {
        return jdbcTemplate.queryForObject(QUERY_COUNT_SQL, new Object[]{userName, password}, Integer.class);
    }

    /**
     * 根据用户名称查询用户
     * @param userName      用户名
     * @return               用户
     */
    public User findUserByUserName(final String userName)
    {
        final User user = new User();
        jdbcTemplate.query(FIND_USER_SQL, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    /**
     * 更新玩家状态
     * @param user
     */
    public void updateLoginInfo(User user)
    {
        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL, new Object[]{user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId()});
    }

}
