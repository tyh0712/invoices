package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.OrderBizImpl;
import com.jr.entry.Order;
import com.jr.util.PageHelper;
import com.sun.org.apache.xpath.internal.operations.Or;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Timestamp;
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
        }else if (o==5){
            open(request,response);
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

    //搜索框+分页+确认勾选数据
    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int count =0;
        String orderno = request.getParameter("orderno");
        String orderdate = request.getParameter("orderdate");
        String ordermin = request.getParameter("ordermin");
        String ordermax = request.getParameter("ordermax");
        String index = request.getParameter("index");
        if (orderno.equals("")){
            count++;
        }
        if (orderdate.equals("")){
            count++;
        }
        if (ordermin.equals("")){
            count++;
        }
        if (ordermax.equals("")){
            count++;
        }
        PageHelper ph = null;
        if ((orderno.equals("undefined") && orderdate.equals("undefined") &&ordermin.equals("undefined") && ordermax.equals("undefined") )|| count==4){
            List<Order> list = orderBiz.invoicingOrder(0,0,ph,"B");
            PageHelper pageHelper = page(list.size(),index);
            List<Order> list1 = orderBiz.invoicingOrder(0,1,pageHelper,"B");
            pageHelper.setPageList(list1);
            response.getWriter().println(new Gson().toJson(pageHelper));
        }else if (count==3 && !orderno.equals("")){
            List<Order> list = orderBiz.invoicingOrder(0,0,ph,"B",orderno);
            PageHelper pageHelper = page(list.size(),index);
            List<Order> list1 = orderBiz.invoicingOrder(0,1,pageHelper,"B",orderno);
            pageHelper.setPageList(list1);
            response.getWriter().println(new Gson().toJson(pageHelper));
        }else if (count==3 && !orderdate.equals("")){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date = sdf.parse(orderdate);
                Timestamp createTime = new Timestamp(date.getTime());
                List<Order> list = orderBiz.invoicingOrder(0,0,ph,"B",createTime);
                PageHelper pageHelper = page(list.size(),index);
                List<Order> list1 = orderBiz.invoicingOrder(0,1,pageHelper,"B",createTime);
                pageHelper.setPageList(list1);
                response.getWriter().println(new Gson().toJson(pageHelper));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if (count==3 && !ordermin.equals("")){
            int judge=1;
            double min = Double.parseDouble(ordermin);
            List<Order> list = orderBiz.invoicingOrder(1,0,ph,"B",min);
            PageHelper pageHelper = page(list.size(),index);
            List<Order> list1 = orderBiz.invoicingOrder(1,1,pageHelper,"B",min);
            pageHelper.setPageList(list1);
            System.out.println(pageHelper + "-------min-------");
            response.getWriter().println(new Gson().toJson(pageHelper));
        }else if (count==3 && !ordermax.equals("")){
            int judge = 2;
            double max = Double.parseDouble(ordermax);
            List<Order> list = orderBiz.invoicingOrder(2,0,ph,"B",max);
            PageHelper pageHelper = page(list.size(),index);
            List<Order> list1 = orderBiz.invoicingOrder(2,1,pageHelper,"B",max);
            pageHelper.setPageList(list1);
            response.getWriter().println(new Gson().toJson(pageHelper));
        }

        if (count==2){//判断几个参数有值，选择对应参数个数传入
            if (!orderno.equals("") && !orderdate.equals("")){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = sdf.parse(orderdate);
                    List<Order> list = orderBiz.invoicingOrder(0,0,ph,"B",orderno,date);
                    PageHelper pageHelper = page(list.size(),index);
                    List<Order> list1 = orderBiz.invoicingOrder(0,1,pageHelper,"B",orderno,date);
                    pageHelper.setPageList(list1);
                    response.getWriter().println(new Gson().toJson(pageHelper));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else if (!orderno.equals("") && !ordermin.equals("")){
                double min = Double.parseDouble(ordermin);
                List<Order> list = orderBiz.invoicingOrder(1,0,ph,"B",orderno,min);
                PageHelper pageHelper = page(list.size(),index);
                List<Order> list1 = orderBiz.invoicingOrder(1,1,pageHelper,"B",orderno,min);
                pageHelper.setPageList(list1);
                response.getWriter().println(new Gson().toJson(pageHelper));
            }else if (!orderno.equals("") && !ordermax.equals("")){
                double max = Double.parseDouble(ordermax);
                List<Order> list = orderBiz.invoicingOrder(2,0,ph,"B",orderno,max);
                PageHelper pageHelper = page(list.size(),index);
                List<Order> list1 = orderBiz.invoicingOrder(2,1,pageHelper,"B",orderno,max);
                pageHelper.setPageList(list1);
                response.getWriter().println(new Gson().toJson(pageHelper));
            }else if (!ordermin.equals("") && !ordermax.equals("")){
                double min = Double.parseDouble(ordermin);
                double max = Double.parseDouble(ordermax);
                List<Order> list = orderBiz.invoicingOrder(0,0,ph,"B",min,max);
                PageHelper pageHelper = page(list.size(),index);
                List<Order> list1 = orderBiz.invoicingOrder(0,1,pageHelper,"B",min,max);
                pageHelper.setPageList(list1);
                response.getWriter().println(new Gson().toJson(pageHelper));
            }

        }else if (count==1){

        }

    }

    protected PageHelper page(int allcount,String index) {

        PageHelper<Order> ph=new PageHelper<>();
        ph.setTotalCount(allcount);// 给  一共有多少条数据   赋值
        ph.setPageSize(3); //给  每页显示的条数   赋值
        ph.getTotalPage();
        if(index==null){
            ph.setIndexPage(1); //给   当前是第几页   赋值
        }else{
            int i=Integer.parseInt(index);
            ph.setIndexPage(i);
        }
        return ph;
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

    public void open(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        int oid = Integer.parseInt(request.getParameter("oid"));
        int invoicingRecordId = Integer.parseInt(request.getParameter("invoicingRecordId"));
        boolean boo = orderBiz.openOrder(oid,invoicingRecordId);
        if (boo){
            //开票成功此处应该无变化
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