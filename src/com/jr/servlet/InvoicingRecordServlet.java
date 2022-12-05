package com.jr.servlet;

import com.google.gson.Gson;
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
import java.util.Date;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/is")
public class InvoicingRecordServlet extends HttpServlet {
    InvoicingRecordBizImpl irbi=new InvoicingRecordBizImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("text/html;charset=utf-8");
        int i = Integer.parseInt(request.getParameter("i"));
        if (i==1){
            invoiceList(request,response);
        }else if (i==2){
            invoice(request,response);
        }else if (i==3){
            refund(request,response);
        }else if (i==4){
            detail(request,response);
        }else if (i==5){
            invoiceMinList(request, response);
        }else if (i==6){
            invoiceMaxList(request, response);
        }else if (i==7){
            invoiceStatusList(request, response);
        }else if (i==8){
            invoiceTitleList(request, response);
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
        /*int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        List<InvoicingRecord> invoicelist=irbi.getIRList(enterpriseId);*/
        List<InvoicingRecord> invoicelist=irbi.getIRList(2);
        String creatortime=request.getParameter("creatortime");
        String titlestr=request.getParameter("titlestr");
        String invoicingmin=request.getParameter("invoicingmin");
        String invoicingmax=request.getParameter("invoicingmax");
        if (creatortime.equals("undefined") && titlestr.equals("undefined") && invoicingmin.equals("undefined") && invoicingmax.equals("undefined")){
            Gson gson=new Gson();
            response.getWriter().print(gson.toJson(invoicelist));
        }
    }
    public void invoiceStatusList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status=request.getParameter("status");
        List<InvoicingRecord> invoicestatuslist=irbi.selectStatusList(2,status);
        Gson gson=new Gson();
        response.getWriter().print(gson.toJson(invoicestatuslist));

    }

    public void invoiceTitleList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String titlestr=request.getParameter("titlestr");
        List<InvoicingRecord> invoicetitlelist=irbi.selectIRByTitle(2,titlestr);
        Gson gson=new Gson();
        response.getWriter().print(gson.toJson(invoicetitlelist));

    }
    public void invoiceMinList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        int amount=Integer.parseInt(request.getParameter("amount"));
        List<InvoicingRecord> invoiceMinlist=irbi.getIRAmountMinList(enterpriseId,amount);*/
        int invoicingmin=Integer.parseInt(request.getParameter("invoicingmin"));
        List<InvoicingRecord> invoiceminlist=irbi.getIRAmountMinList(2,invoicingmin);
        Gson gson=new Gson();
        response.getWriter().print(gson.toJson(invoiceminlist));
    }
    public void invoiceMaxList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        int amount=Integer.parseInt(request.getParameter("amount"));
        List<InvoicingRecord> invoiceMaxlist=irbi.getIRAmountMinList(enterpriseId,amount);*/
        int invoicingmax=Integer.parseInt(request.getParameter("invoicingmax"));
        List<InvoicingRecord> invoicemaxlist=irbi.getIRAmountMaxList(2,invoicingmax);
        Gson gson=new Gson();
        response.getWriter().print(gson.toJson(invoicemaxlist));
    }


    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoicingRecord ir=new InvoicingRecord();
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
            response.sendRedirect("invoice-list.jsp");
        }
    }

    public void refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        InvoicingRecord ir=new InvoicingRecord();
        int iid=Integer.parseInt(request.getParameter("iid"));
        ir.setIid(iid);
        boolean boo=irbi.refundIR(ir.getIid());
        if (boo){
            response.sendRedirect("invoice-list.jsp");
        }else{
            response.sendRedirect("invoice-list.jsp");
        }
    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int iid=Integer.parseInt(request.getParameter("iid"));
        InvoicingRecord detaillist=irbi.detailIR(iid);
        Gson gson=new Gson();
//        response.getWriter().print(gson.toJson(detaillist));
        HttpSession session=request.getSession();
        session.setAttribute("detaillist",detaillist);
        System.out.println(detaillist.toString());
//        response.getWriter().print(new Gson().toJson(detaillist));
        response.sendRedirect("invoice-detail.jsp");
    }
}