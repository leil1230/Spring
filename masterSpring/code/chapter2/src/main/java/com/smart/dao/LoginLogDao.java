package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    /**
     * 保存登陆日志sql
     */
    private final String INSERT_LOGIN_LOG_SQL = "INSERT INTO t_login_log(user_id, ip, login_datetime) VALUES(?, ?, ?)";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 插入登陆日志
     * @param loginLog
     */
    public void insertLoginLog(LoginLog loginLog)
    {
        Object[] args = {loginLog.getUserId(), loginLog.getIp(), loginLog.getLoginDate()};
        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL, args);
    }
}
