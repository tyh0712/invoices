package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.BaseDataBizImpl;
import com.jr.entry.BaseData;

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
@WebServlet("/bs")
public class BaseDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        int b = Integer.parseInt(request.getParameter("b"));
        if (b==1){
            queryBaseData(request,response);
        }else if (b==2){
            messageUpdate(request,response);
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

    public void queryBaseData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int eid = Integer.parseInt(request.getParameter("eid"));
        BaseDataBizImpl bbi = new BaseDataBizImpl();
        BaseData baseData = bbi.queryBDByEId(eid);
        response.getWriter().print(new Gson().toJson(baseData));
    }

    public void messageUpdate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int bid = Integer.parseInt(request.getParameter("bid"));
        String bankName = request.getParameter("bankName");
        String bankAccount = request.getParameter("bankAccount");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        BaseDataBizImpl bbi = new BaseDataBizImpl();
        BaseData baseData = new BaseData();
        baseData.setBid(bid);
        baseData.setBankName(bankName);
        baseData.setBankAccount(bankAccount);
        baseData.setPhone(phone);
        baseData.setAddress(address);
        boolean boo = bbi.modify(baseData);
        if (boo){
            System.out.println("success");
        }else {
            response.getWriter().print("failure");
        }
    }
}
