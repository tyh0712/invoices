package com.jr.servlet;

import com.jr.biz.impl.UserBizImpl;
import com.jr.dao.impl.UserDaoImpl;
import com.jr.entry.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/us")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String str = request.getParameter("u");
        int u = Integer.parseInt(str);
        if (u == 1){
            login(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        UserBizImpl ubi = new UserBizImpl();
        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        User user1 = ubi.login(user);
        if (user1 != null){
            HttpSession session = request.getSession();
            session.setAttribute("enterpriseId",user1.getEnterpriseId());
            session.setAttribute("userName",user1.getName());
            response.sendRedirect("invoice-list.jsp");
        }else {
            response.sendRedirect("login.jsp");
        }
    }
}
