package com.smart.service;

import com.smart.dao.LoginLogDao;
import com.smart.dao.UserDao;
import com.smart.domain.LoginLog;
import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private UserDao userDao;
    private LoginLogDao loginLogDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setLoginLogDao(LoginLogDao loginLogDao) {
        this.loginLogDao = loginLogDao;
    }

    /**
     * 是否有满足条件的用户
     * @param userName
     * @param password
     * @return
     */
    public boolean hasMatchUser(String userName, String password)
    {
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    /**
     * 根据用户名获取用户
     * @param userName
     * @return
     */
    public User findUserByUserName(String userName)
    {
        return userDao.findUserByUserName(userName);
    }

    /**
     * 登陆成功记录用户状态
     * @param user
     */
    @Transactional      //事务注解，让该方法运行在事务环境中
    public void loginSuccess(User user)
    {
        user.setCredits(user.getCredits() + 5);     // 用户积分增加5
        LoginLog loginLog = new LoginLog();
        loginLog.setUserId(user.getUserId());
        loginLog.setIp(user.getLastIp());
        loginLog.setLoginDate(user.getLastVisit());
        userDao.updateLoginInfo(user);              //更新用户登陆信息
        loginLogDao.insertLoginLog(loginLog);       //记录用户登陆log
    }
}
