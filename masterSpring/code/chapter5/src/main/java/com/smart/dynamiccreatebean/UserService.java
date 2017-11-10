package com.smart.dynamiccreatebean;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }
}
