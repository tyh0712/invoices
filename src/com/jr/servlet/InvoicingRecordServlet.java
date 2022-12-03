package com.jr.servlet;

import com.jr.biz.impl.InvoicingRecordBizImpl;
import com.jr.entry.InvoicingRecord;

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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/is")
public class InvoicingRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int i = Integer.parseInt(request.getParameter("i"));
        System.out.println(i);
        if (i==1){
            invoiceList(request,response);
        }else if (i==2){
            invoice(request,response);
        }else if (i==3){
            refund(request,response);
        }else if (i==4){
            detail(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request, response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    public void invoiceList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoicingRecordBizImpl irbi=new InvoicingRecordBizImpl();
        int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        System.out.println(enterpriseId);
        List<InvoicingRecord> list=irbi.getIRList(enterpriseId);
        HttpSession session=request.getSession();
        session.setAttribute("invoiceList",list);
        System.out.println(list);
//        response.sendRedirect("invoice-list.jsp");
    }

    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoicingRecordBizImpl irbi=new InvoicingRecordBizImpl();
        InvoicingRecord ir=new InvoicingRecord();
        int iid=Integer.parseInt(request.getParameter("iid"));
        ir.setIid(iid);
        double amount=Double.parseDouble(request.getParameter("amount"));
        int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        int uid=Integer.parseInt(request.getParameter("uid"));
        Timestamp creatorTime=new Timestamp(System.currentTimeMillis());
        String category=request.getParameter("category");
        String type=request.getParameter("type");
        String status=request.getParameter("status");
        int bid=Integer.parseInt(request.getParameter("bid"));
        int aid=Integer.parseInt(request.getParameter("aid"));
        int eid=Integer.parseInt(request.getParameter("eid"));
        String uplinkAddress=request.getParameter("uplinkAddress");
        ir.setIid(iid);
        ir.setAmount(amount);
        ir.getUser().setEnterpriseId(enterpriseId);
        ir.getUser().setUid(uid);
        ir.setCreatorTime(creatorTime);
        ir.setCategory(category);
        ir.setType(type);
        ir.setStatus(status);
        ir.getBaseData().setBid(bid);
        ir.getAddress().setAid(aid);
        ir.getEmail().setEid(eid);
        ir.setUplinkAddress(uplinkAddress);
        boolean boo=irbi.invoicingIR(ir);
        if (boo) {
//            response.sendRedirect("invoice-open.jsp");
        }else{
//            response.sendRedirect("invoice-open.jsp");
        }
    }

    public void refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoicingRecordBizImpl irbi=new InvoicingRecordBizImpl();
        InvoicingRecord ir=new InvoicingRecord();
        int iid=Integer.parseInt(request.getParameter("iid"));
        ir.setIid(iid);
        boolean boo=irbi.refundIR(ir.getIid());
        if (boo){
//            response.sendRedirect("invoice-open.jsp");
        }else{
//            response.sendRedirect("invoice-open.jsp");
        }

    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("iid"));
        InvoicingRecordBizImpl irbi=new InvoicingRecordBizImpl();
        int iid=Integer.parseInt(request.getParameter("iid"));
        List<InvoicingRecord> list=irbi.detailIR(iid);
        HttpSession session=request.getSession();
        session.setAttribute("detailList",list);
        System.out.println(list);
//        response.sendRedirect("invoice-detail.jsp");
    }
}