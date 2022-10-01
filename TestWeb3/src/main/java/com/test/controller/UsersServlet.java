package com.test.controller;

import com.test.pojo.Users;
import com.test.service.IUsersService;
import com.test.service.impl.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usersServlet")
public class UsersServlet extends HttpServlet {
    private IUsersService usersService=new UsersService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.获取表单中提交的信息
        int id=Integer.parseInt(request.getParameter("id").toString());
        String name=request.getParameter("name").toString();
        int age=Integer.parseInt(request.getParameter("age").toString());
        Users users=new Users(id,name,age);
        //2.调用service层做添加用户的 逻辑处理
        int i=usersService.addUsers(users);
        //3.返回结果
        if(i>0)
            response.getWriter().print("添加成功");
        else
            response.getWriter().print("添加失败");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request,response);
    }
}
