package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.OrderBizImpl;
import com.jr.entry.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        List<Double> list = orderBiz.getAmount(enterpriseId);
        response.getWriter().println(new Gson().toJson(list));
    }

    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String orderno = request.getParameter("orderno");
        String orderdate = request.getParameter("orderdate");
        String ordermin = request.getParameter("ordermin");
        String ordermax = request.getParameter("ordermax");
        if (orderno.equals("undefined") && orderdate.equals("undefined") && ordermin.equals("undefined") && ordermax.equals("undefined")){
            List<Order> list = orderBiz.invoicingOrder(0,"B");
            response.getWriter().println(new Gson().toJson(list));
        }else if (orderdate.equals("undefined") && ordermin.equals("undefined") && ordermax.equals("undefined")){
            List<Order> list = orderBiz.invoicingOrder(0,"B",orderno);
            response.getWriter().println(new Gson().toJson(list));
        }else if (orderno.equals("undefined") && ordermin.equals("undefined") && ordermax.equals("undefined")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(orderdate);
                List<Order> list = orderBiz.invoicingOrder(0,"B",date);
                response.getWriter().println(new Gson().toJson(list));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if (orderno.equals("undefined") && orderdate.equals("undefined") && ordermax.equals("undefined")){
            int judge=1;
            double min = Double.parseDouble(ordermin);
            List<Order> list = orderBiz.invoicingOrder(1,"B",min);
            response.getWriter().println(new Gson().toJson(list));
        }else if (orderno.equals("undefined") && orderdate.equals("undefined") && ordermin.equals("undefined")){
            int judge = 2;
            double max = Double.parseDouble(ordermax);
            List<Order> list = orderBiz.invoicingOrder(2,"B",max);
            response.getWriter().println(new Gson().toJson(list));
        }
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