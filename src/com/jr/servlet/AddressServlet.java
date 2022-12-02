package com.jr.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/as")
public class AddressServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int a = Integer.parseInt(request.getParameter("a"));
        if (a==1){
            titleAndAddress(request,response);
        }else if (a==2){
            message(request,response);
        }else if (a==3){
            invoice(request,response);
        }else if (a==4){
            detail(request,response);
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

    public void titleAndAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void message(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
