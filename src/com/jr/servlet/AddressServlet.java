package com.jr.servlet;

import com.google.gson.Gson;
import com.jr.biz.impl.AddressBizImpl;
import com.jr.entry.Address;

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
            showAll(request,response);
        }else if (a==3){
            changeAddress(request,response);
        }else if (a==4){
            changeDeAdd(request,response);
        }else if (a==5){
            addAddress(request,response);
        }else if (a==6){
            invoice(request,response);
        }else if (a==7){
            detail(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        doGet(request,response);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);
    }


    AddressBizImpl abi=new AddressBizImpl();

    public void titleAndAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        Address address=abi.queryDeAddByEId(enterpriseId,"A");
        response.getWriter().print(new Gson().toJson(address));

    }

    public void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        List<Address> list=abi.queryAddByEId(enterpriseId);
        response.getWriter().print(new Gson().toJson(list));

    }

    public void changeAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Address address=new Address();
        address.setAid(Integer.parseInt(request.getParameter("aid")));
        address.setAddressee(request.getParameter("addressee"));
        address.setPhone(request.getParameter("phone"));
        address.setArea(request.getParameter("area"));
        address.setAddressDetail(request.getParameter("addressDetail"));
        boolean boo=abi.modifyAddress(address);
        String str="失败";
        if (boo){
            System.out.println("success");
        }else {
            response.getWriter().print(new Gson().toJson(str));
        }
    }

    public void changeDeAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int aid=Integer.parseInt(request.getParameter("aid"));
        int enterpriseId=Integer.parseInt(request.getParameter("enterpriseId"));
        boolean boo=abi.modifyDeAddByEId(aid,enterpriseId);
        String str="失败";
        if (boo){
            System.out.println("success");
        }else {
            response.getWriter().print(new Gson().toJson(str));
        }
    }

    public void addAddress(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Address address=new Address();
        address.setEnterpriseId(Integer.parseInt(request.getParameter("enterpriseId")));
        address.setAddressee(request.getParameter("addressee"));
        address.setPhone(request.getParameter("phone"));
        address.setArea(request.getParameter("area"));
        address.setAddressDetail(request.getParameter("addressDetail"));
        boolean boo=abi.modifyAddress(address);
        String str="失败";
        if (boo){
            System.out.println("success");
        }else {
            response.getWriter().print(new Gson().toJson(str));
        }
    }


    public void invoice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Address> list=abi.queryAddByEId(Integer.parseInt(request.getParameter("enterpriseId")));
        response.getWriter().print(new Gson().toJson(list));

    }

    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Address address=abi.queryAddByIId(Integer.parseInt(request.getParameter("aid")));
        response.getWriter().print(new Gson().toJson(address));

    }
}
