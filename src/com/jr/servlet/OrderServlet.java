package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.OrderBizImpl;
import com.jr.entry.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/os")
public class OrderServlet extends HttpServlet {
    OrderBizImpl orderBiz = new OrderBizImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int o = Integer.parseInt(request.getParameter("o"));
        System.out.println(o);
        if (o==1){
            totalAmount(request,response);
        }else if (o==2){
            invoice(request,response);
        }else if (o==3){
            refund(request,response);
        }else if (o==4){
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

    public void totalAmount(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int enterpriseId = Integer.parseInt(request.getParameter("invoicingRecordId"));
        System.out.println(enterpriseId);
        List<Double> list = orderBiz.getAmount(enterpriseId);
        response.getWriter().println(new Gson().toJson(list));
    }

    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    public void refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int invoicingRecordId = Integer.parseInt(request.getParameter("invoicingRecordId"));
        boolean boo = orderBiz.refundOrder(invoicingRecordId);
        if (boo){
            //退票成功此处应该无变化
        }
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int invoicingRecordId = Integer.parseInt(request.getParameter("invoicingRecordId"));
        List<Order> list = orderBiz.detailOrder(invoicingRecordId);
        response.getWriter().println(new Gson().toJson(list));
    }
}