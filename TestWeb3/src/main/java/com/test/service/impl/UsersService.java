package com.test.service.impl;

import com.test.dao.IUsersDao;
import com.test.dao.impl.UsersDao;
import com.test.pojo.Users;
import com.test.service.IUsersService;

public class UsersService implements IUsersService {

    private IUsersDao usersDao=new UsersDao();
    @Override
    public int addUsers(Users users) {
        //1.验证手机

        //2.验证邮箱

        //3.调用dao层做添加
        return usersDao.addUsers(users);
    }
}
