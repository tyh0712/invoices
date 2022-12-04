package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.EmailBizImpl;
import com.jr.entry.Email;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Auther:唐一涵
 * @Date:2022/12/1
 * @Description: com.jr.servlet
 * @version: 1.0
 */
@WebServlet("/es")
public class EmailServlet extends HttpServlet {
    EmailBizImpl ebi = new EmailBizImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        int e = Integer.parseInt(request.getParameter("e"));
        if (e==1){//抬头--电子邮箱显示
            titleAndAddress(request,response);
        }else if (e==2){//抬头--编辑--电子邮箱查询显示
            message(request,response);
        }else if (e==3){//去开票--邮箱显示
            invoice(request,response);
        }else if (e==4){//详情--邮箱显示
            detail(request,response);
        }else if(e==5){//去开票--选择邮箱
            message(request, response);
        }else if(e==6){//发票抬头及地址信息--编辑--电子邮箱--新增
            addEmail(request, response);
        }else if(e==7){//发票抬头及地址信息--编辑--电子邮箱--编辑邮箱
            modifyEmailDetail(request, response);
        }else if(e==8){//发票抬头及地址信息--编辑--电子邮箱--设为默认
            modifyEmailStatus(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }

    //当前企业发票抬头及地址信息
    public void titleAndAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        Email email = ebi.queryDeEmailByEId(enterpriseId,"A");
        response.getWriter().println(new Gson().toJson(email));

    }

    //信息管理 实现邮箱列表的查询
    public void message(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        List<Email> list = ebi.queryEmailByEId(enterpriseId);
        response.getWriter().println(new Gson().toJson(list));
    }

    //修改
    public void modifyEmailStatus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Email email = new Email();
        int eid=Integer.parseInt(request.getParameter("id"));
        int enterpriseId=Integer.parseInt(request.getParameter("eid"));
        boolean boo = ebi.modifyEmailStatus(eid,enterpriseId);
        if (boo){
            System.out.println("设置成功");
            message(request, response);
        }else{
            System.out.println("修改失败");
        }
    }

    public void modifyEmailDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Email email = new Email();
        email.setEmailDetail(request.getParameter("email_detail"));
        email.setEid(Integer.parseInt(request.getParameter("eid")));
        System.out.println(email.toString());
        boolean boo = ebi.modifyEmailDetail(email);
        if (boo){
            System.out.println("success");
        }else{
            System.out.println("修改失败");
        }
    }

    //增加
    public void addEmail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        Email email = new Email();
        email.setEmailDetail(request.getParameter("email_detail"));
        email.setEnterpriseId(Integer.parseInt(request.getParameter("eid")));
        boolean boo = ebi.addEmail(email);
        if (boo){
            System.out.println("success");
        }else{
            System.out.println("添加失败");
        }
    }


    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int enterpriseId = Integer.parseInt(request.getParameter("enterpriseId"));
        List<Email> list = ebi.queryEmailByEId(enterpriseId);
        response.getWriter().println(new Gson().toJson(list.get(0)));
    }



    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        int eid = Integer.parseInt(request.getParameter("eid"));
        Email email = ebi.queryEmailByIId(eid);
        response.getWriter().println(new Gson().toJson(email));
    }
}
