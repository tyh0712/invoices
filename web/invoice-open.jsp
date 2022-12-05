<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/12/2
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>发票管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/app.css">
    <style>
        .star::before {
            content: '*';
            color: #F56C6C;
            margin-right: 0.020833rem;
        }

        .am-form-horizontal .am-radio {
            padding-top: 3px;
        }

        .am-ucheck-icons {
            line-height: 28px;
        }
    </style>
</head>
<body data-type="generalComponents">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick" name="userName"></span>
                    <span class="tpl-header-list-user-ico">
              <img src="img/user01.png">
            </span>
                </a>
                <ul class="am-dropdown-content">
                    <li>
                        <a href="login.jsp">
                            <span class="am-icon-power-off"></span> 退出</a>
                    </li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<div class="tpl-page-container tpl-page-header-fixed">
    <div class="tpl-left-nav tpl-left-nav-hover">
        <div class="tpl-left-nav-list">
            <ul class="tpl-left-nav-menu">
                <li class="tpl-left-nav-item">
                    <a href="javascript:;" class="nav-link tpl-left-nav-link-list active">
                        <i class="am-icon-table"></i>
                        <span>发票管理</span>
                        <i class="am-icon-angle-right tpl-left-nav-more-ico am-fr am-margin-right tpl-left-nav-more-ico-rotate"></i>
                    </a>
                    <ul class="tpl-left-nav-sub-menu" style="display:block">
                        <li>
                            <a href="invoice-list.jsp">
                                <i class="am-icon-angle-right"></i>
                                <span>发票总览管理</span>
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="tpl-content-wrapper">
        <div class="tpl-content-page-title" style="margin-bottom: 4px;">
            发票开具
        </div>
        <div class="tpl-portlet-components" id="baseinfoDiv">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    选择开票相关订单
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block">
                <div class="am-g">
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                <span class="am-input-group-btn">
                  <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">订单编号</span>
                </span>
                            <input id="orderno" type="text" class="am-form-field" placeholder="&nbsp;&nbsp;请输入订单编号"
                                   style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                <span class="am-input-group-btn">
                  <span style="font-size: 14px;margin-right: 8px;margin-left: 8px;">生成日期</span>
                </span>
                            <input id="orderdate" type="text" class="am-form-field" data-am-datepicker placeholder="&nbsp;&nbsp;请选择日期"
                                   style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                        <div class="am-input-group am-input-group-sm">
                <span class="am-input-group-btn">
                  <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">凭证金额</span>
                </span>
                            <input id="ordermin" type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最低金额(万)"
                                   style="border: 1px solid #c2cad8;width: 32%;border-radius: 3px;">
                            <div class="am-form-field"
                                 style="width: 0%; border-radius: 3px;border: none;margin-left: 10px;">~
                            </div>
                            <input id="ordermax" type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最高金额(万)"
                                   style="border: 1px solid #c2cad8;width: 32%;border-radius: 3px;margin-left: 20px;">
                        </div>
                    </div>
                    <div class="am-u-sm-6 am-u-md-3">
                    </div>
                </div>
            </div>
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                </th>
                                <th class="table-check">
                                    <input type="checkbox" class="tpl-table-fz-check">
                                </th>
                                <th class="table-title">订单编号</th>

                                <th class="table-author am-hide-sm-only">订单金额（元）</th>
                                <th class="table-date am-hide-sm-only">生成时间</th>
                            </tr>
                            </thead>
                            <tbody id="doc-modal-list1">

                            </tbody>
                        </table>
                        <div class="am-cf">
                            <div class="am-fr">
                                <ul id="ulid" class="am-pagination tpl-pagination">

                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
            </div>
        </div>
        <div class="tpl-portlet-components" id="showDiv">
            <!-- 表单填写页面 -->
            <div class="tpl-block">
                <div class="">
                    <div class="portlet-title">
                        <div class="caption font-green bold">
                            抬头信息
                        </div>
                        <div class="tpl-portlet-input tpl-fz-ml">
                            <div class="portlet-input input-small input-inline">
                                <div class="input-icon right">
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="tpl-block ">
                        <div class="am-g tpl-amazeui-form">
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label star"> 发票种类</label>
                                        <div class="am-u-sm-3" style="margin-top: 4px;font-size: 16px;"
                                             onclick="selectCategory('ordinary')">
                                            <label class="am-radio">
                                                <input type="radio" name="radio1" value="普通增值税发票" data-am-ucheck checked>
                                                普通增值税发票
                                            </label>
                                        </div>
                                        <div class="am-u-sm-6" style="margin-top: 4px;font-size: 16px;"
                                             onclick="selectCategory('appropriative')">
                                            <label class="am-radio">
                                                <input type="radio" name="radio1" value="增值税专用发票" data-am-ucheck> 增值税专用发票
                                            </label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <form class="am-form am-form-horizontal">
                                    <div class="am-form-group">
                                        <label class="am-u-sm-3 am-form-label star"> 发票类型</label>
                                        <div class="am-u-sm-3" style="margin-top: 4px;font-size: 16px;"
                                             onclick="selectType('ele')">
                                            <label class="am-radio">
                                                <input type="radio" name="radio2" value="电子发票" data-am-ucheck checked> 电子发票
                                            </label>
                                        </div>
                                        <div class="am-u-sm-6" style="margin-top: 4px;font-size: 16px;"
                                             onclick="selectType('paper')">
                                            <label class="am-radio">
                                                <input type="radio" name="radio2" value="纸质发票" data-am-ucheck> 纸质发票
                                            </label>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <hr>
                        <div>
                            <div id='invoice_ordinary_title' class="am-g tpl-amazeui-form">
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 抬头</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="title1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label">税号</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="taxNo1"></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div id='invoice_appropriative_title' class="am-g tpl-amazeui-form" hidden>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 抬头</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="title1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label">税号</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="taxNo1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 开户银行</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="bankName1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label">开户账号</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="bankAccount1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 注册固定电话</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="phone1"></div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label">注册场所地址</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="address1"></div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <hr>
                            <div id='invoice_ele_addr' class="am-g tpl-amazeui-form">
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 邮箱</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" id="emailopen">

                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label"></label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                                <span id="selectEmail" style="color: #23abf0;cursor: pointer;" >选择</span>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                            <div id='invoice_paper_addr'  class="am-g tpl-amazeui-form" hidden>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label star"> 邮寄地址</label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" id="deAddress">

                                            </div>
                                        </div>
                                    </form>
                                </div>
                                <div class="am-u-sm-12 am-u-md-6">
                                    <form class="am-form am-form-horizontal">
                                        <div class="am-form-group">
                                            <label class="am-u-sm-3 am-form-label"></label>
                                            <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">
                                                <span id="selectAddress"
                                                      style="color: #23abf0;cursor: pointer;" >选择</span>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div style="text-align: center;margin-top:40px">
                <a class="am-btn am-btn-default" href="invoice-list.jsp">取&nbsp;&nbsp;&nbsp;&nbsp; 消
                </a>
                <a id="submitBtn" class="am-btn am-btn-primary" style="margin-left:20px">提&nbsp;&nbsp;&nbsp;&nbsp; 交
                </a>
            </div>
        </div>
        <div class="tpl-portlet-components" id="resultDiv">
            <!-- 提交成功页面 -->
            <div class="tpl-block ">
                <div class="am-g tpl-amazeui-form">

                    <div class="am-u-sm-12 am-u-md-12">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <div class="am-u-sm-12" style="margin-top: 4px;text-align: center;margin-bottom: 20px;">
                                    <img src="img/u105.png" alt="" style="width: 120px;">
                                </div>
                                <div class="am-u-sm-12"
                                     style="margin-top: 4px;font-size: 20px;text-align: center;font-weight: bold;margin-bottom: 20px;">
                                    提交申请成功
                                </div>
                                <div class="am-u-sm-12" style="color: #999;font-size:14px;text-align: center;">
                                    已通知审核人员尽快审核，最终结果将以站内信的方式告知您。
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div style="text-align: center;margin-top:40px">
                    <a class="am-btn am-btn-primary" href="invoice-list.jsp">返回列表</a>
                </div>
            </div>
        </div>
        <!-- 选择邮箱弹出框 -->
        <div class="am-modal am-modal-prompt" tabindex="-1" id="my-email">
            <div class="am-modal-dialog">
                <form class="am-form">
                    <legend style="font-size: 18px;padding: 12px 0;">选择邮箱</legend>
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check"></th>
                            <th class="table-title" style="text-align: center;">邮箱</th>
                        </tr>
                        </thead>
                        <tbody id="doc-modal-list2">

                        </tbody>
                    </table>
                </form>
                <div class="am-modal-footer" style="border-top: 1px solid #dedede;">
                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                    <span id="chooseEmail" onclick="chooseEmail()" class="am-modal-btn"  data-am-modal-confirm >确定</span>
                </div>
            </div>
        </div>
        <!-- 邮寄地址弹出框 -->
        <div class="am-modal am-modal-prompt" tabindex="-1" id="my-address">
            <div class="am-modal-dialog">
                <form class="am-form">
                    <legend style="font-size: 18px;padding: 12px 0;">选择邮寄地址</legend>
                    <table class="am-table am-table-striped am-table-hover table-main">
                        <thead>
                        <tr>
                            <th class="table-check"></th>
                            <th class="table-title" style="text-align: center;">地址信息</th>
                        </tr>
                        </thead>
                        <tbody id="doc-modal-list3">

                        </tbody>
                    </table>
                </form>
                <div class="am-modal-footer" style="border-top: 1px solid #dedede;">
                    <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                    <span id="chooseAdd" onclick="chooseAdd()" class="am-modal-btn" data-am-modal-confirm>确定</span>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script type="text/javascript">
        function submitvalue(subvalue) {
            var orderno = $("[id='orderno']").val();
            var orderdate = $("[id='orderdate']").val();
            var ordermin = $("[id='ordermin']").val();
            var ordermax = $("[id='ordermax']").val();

            $.get("os","o=2&orderno="+orderno+"&orderdate="+orderdate+"&ordermin="+ordermin+"&ordermax="+ordermax+"&index="+subvalue,function (pageHelper2) {
                eval("var ph="+pageHelper2);
                $("#doc-modal-list1").empty();
                $("#ulid").empty();
                for (var i=0;i<ph.pageList.length;i++){
                    var obj = "<tr data-id='2'>\n" +
                        "    <td>\n" +
                        "        <input type='checkbox' id="+ph.pageList[i].oid+" name="+(i+4)+" class='checkbox-acount' value="+ph.pageList[i].totalAmount+">\n" +
                        "    </td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].no +"</td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].totalAmount+"</td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].createTime+"</td>\n" +
                        "</tr>";
                    $(obj).appendTo($("#doc-modal-list1"));
                }

                var objherd = "<li class=\"am-disabled\">\n" +
                    "  <a href=\"#\">«</a>\n" +
                    "  </li>";

                var objlast = "   <li>\n" +
                    "   <a href=\"#\">»</a>\n" +
                    "    </li>";
                $(objherd).appendTo($("[id='ulid']"));
                for(var i=1;i<=ph.totalPage;i++){
                    var obj="<li class=\"am-active\">\n" +
                        "  <a class='ahref' value='"+i+"'>"+i+"</a>\n" +
                        "   </li>";
                    $(obj).appendTo($("[id='ulid']"));
                }
                $(objlast).appendTo($("[id='ulid']"));
            });

        }
        var acount =0;//这是计算的选中的订单的总金额
        function sumacount(val){
            acount +=val;
        }
        function reducecount(val){
            acount -=val;
        }
        var names = [];//存储checkbox的name属性
        names.push(-1);//让数组初始不为空；
        function isInArray(arr,value){//判断数组中是否存在某元素
            for(var i = 0; i < arr.length; i++){
                if(value === arr[i]){
                    return i;
                }
            }
            return -1;
        }

        var oids = [];//存储选中的订单的id，以备后续使用

        $(document).ready(function () {
            $("#orderno").blur(function () {
                submitvalue(null);
            });
            $("#orderdate").blur(function () {
                submitvalue(null);
            });
            $("#ordermin").blur(function () {
                submitvalue(null);
            });
            $("#ordermax").blur(function () {
                submitvalue(null);
            });

            $.get("os","o=2&orderno=undefined&orderdate=undefined&ordermin=undefined&ordermax=undefined",function (pageHelper1) {
                eval("var ph="+pageHelper1);
                for (var i=0;i<ph.pageList.length;i++){
                    var obj = "<tr data-id='2'>\n" +
                        "    <td>\n" +
                        "        <input type='checkbox' id="+ph.pageList[i].oid+" name="+(i+1)+" class='checkbox-acount' value="+ph.pageList[i].totalAmount+">\n" +
                        "    </td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].no +"</td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].totalAmount+"</td>\n" +
                        "    <td class='am-hide-sm-only'>"+ph.pageList[i].createTime+"</td>\n" +
                        "</tr>";
                    $(obj).appendTo($("#doc-modal-list1"));
                }
                var objherd = "<li class=\"am-disabled\">\n" +
                    "  <a href=\"#\">«</a>\n" +
                    "  </li>";

                var objlast = "   <li>\n" +
                    "   <a href=\"#\">»</a>\n" +
                    "    </li>";
                $(objherd).appendTo($("[id='ulid']"));
                for(var i=1;i<=ph.totalPage;i++){
                    var obj="<li class=\"am-active\">\n" +
                        "  <a class='ahref' value='"+i+"'>"+i+"</a>\n" +
                        "   </li>";
                    $(obj).appendTo($("[id='ulid']"));
                }
                $(objlast).appendTo($("[id='ulid']"));
            });

            $(document).on("click","[class='ahref']",function () {
                var val=$(this)[0].getAttribute("value");
                submitvalue(val);
            });

            $(document).on("click","[class='checkbox-acount']",function () {
                    var namei = $(this)[0].getAttribute("name");
                    if (isInArray(names,namei)!=-1){
                        var val=$(this)[0].getAttribute("value");
                        var num = parseInt(val);
                        oids.splice(isInArray(names,namei)-1,1);
                        alert(oids);
                        reducecount(num);
                        names.splice(isInArray(names,namei),1);
                    }else {
                        var val=$(this)[0].getAttribute("value");
                        var num = parseInt(val);
                        sumacount(num);
                        names.push(namei);
                        var orderid = $(this)[0].getAttribute("id");
                        var oid = parseInt(orderid);
                        oids.push(oid);
                        alert(oids);
                    }

            })

        });

    var baseinfoDiv = document.getElementById('baseinfoDiv')
    var showDiv = document.getElementById('showDiv')
    var resultDiv = document.getElementById('resultDiv')
    resultDiv.style.display = 'none';
    // 提交按钮
    $(function () {
        $('#submitBtn').on('click', function () {
            baseinfoDiv.style.display = 'none';
            showDiv.style.display = 'none';
            resultDiv.style.display = 'block';

            var uid="${sessionScope.uid}";
            var creatorTime=Date.now();
            function getRadioValue1() {
                var obj=document.getElementsByName("radio1");
                for (var i=0;i<obj.length;i++){
                    if (obj[i].checked) {
                        return obj[i].value;
                    }
                }
            }
            function getRadioValue2() {
                var obj=document.getElementsByName("radio2");
                for (var i=0;i<obj.length;i++){
                    if (obj[i].checked) {
                        return obj[i].value;
                    }
                }
            }
            var category=getRadioValue1();
            var type =getRadioValue2();
            var status="A";
            var bid="${sessionScope.bid}";
            var aid="${sessionScope.aid}";
            var eid="${sessionScope.eid}";
            function randomString(length, chars) {
                var result = '';
                for (var i = length; i > 0; --i) result += chars[Math.floor(Math.random() * chars.length)];
                return result;
            }
            var uplinkAddress = randomString(16, '0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ');
            $.get("is","i=2&amount="+8000+"&enterpriseId="+enterpriseId+"&uid="+uid+"&creatorTime="+creatorTime+"&category="+category+"&type="+type+"&status="+status+"&bid="+bid+"&aid="+aid+"&eid="+eid+"&uplinkAddress="+uplinkAddress+"",function () {
            })

        });
    });
    // 邮寄地址选择按钮
    $(function () {
        $('#selectAddress').on('click', function () {
            $('#my-address').modal(
                {
                    relatedTarget: this,
                    onCancel: function (e) {
                    }
                });
        });
    });
    // 邮箱选择按钮
    $(function () {
        $('#selectEmail').on('click', function () {
            $('#my-email').modal(
                {
                    relatedTarget: this,
                    onCancel: function (e) {
                    }
                });
        });
    });

    // 发票类型切换
    function selectType(val) {
        if (val === 'ele') {
            $('#invoice_ele_addr').show();
            $('#invoice_paper_addr').hide();
        }else if (val === 'paper') {
            $('#invoice_ele_addr').hide();
            $('#invoice_paper_addr').show();
        }
    }
    function selectCategory(val) {
        if (val === 'ordinary') {
            $('#invoice_ordinary_title').show();
            $('#invoice_appropriative_title').hide();
        }else if (val === 'appropriative') {
            $('#invoice_ordinary_title').hide();
            $('#invoice_appropriative_title').show();
        }
    }
    var enterpriseId = ${sessionScope.enterpriseId};
    $(document).ready(function () {
        //抬头信息  抬头、税号
        $.get("bs","b=1&enterpriseId="+enterpriseId,function (baseData1) {
            eval("var baseData=" + baseData1);
            $("[name=title1]").text(baseData.title);
            $("[name=taxNo1]").text(baseData.taxNo);
            $("[name=bankName1]").text(baseData.bankName);
            $("[name=bankAccount1]").text(baseData.bankAccount);
            $("[name=phone1]").text(baseData.phone);
            $("[name=address1]").text(baseData.address);
        });

        //右上角用户名
        var userName1 = "${sessionScope.userName}";
        $("[name=userName]").text(userName1);



        //返回选择的邮寄地址
        $.get("as","a=6&enterpriseId="+enterpriseId,function (list) {
            eval("var list="+list);
            $('<span id="showAdd">'+list[0].area+''+list[0].addressDetail+'</span>').appendTo($("#deAddress"));
            for (var i=0;i<list.length;i++){
                $('<tr data-id="2"><td><label class="am-radio"><input type="radio" name="addressCho" id="'+i+'" value="'+list[i].area+''+list[i].addressDetail+'" data-am-ucheck checked></label></td><td class="am-hide-sm-only"><label class="am-radio" for="'+i+'">'+list[i].area+''+list[i].addressDetail+'</label></td></tr>').appendTo($("#doc-modal-list3"));
            }
        })
    });

    $(function () {
        //去开票--邮箱显示
        $.get("es","e=3&enterpriseId="+enterpriseId,function (email2) {
            eval("var email="+email2);
            $("[name=email2]").text(email.emailDetail);
        });
        //去开票--邮箱选择
        $.get("es","e=5&enterpriseId="+enterpriseId,function (list) {
            eval("var list="+list);
            $('<span id="showemail">'+list[0].emailDetail+'</span>').appendTo($("#emailopen"));
            for(var i=0;i<list.length;i++){
                $('<tr data-id="2"><td><label class="am-radio"><input type="radio" name="emailCho" id="'+i+'" value="'+list[i].emailDetail+'" data-am-ucheck checked></label></td><td class="am-hide-sm-only"><label class="am-radio" for="'+i+'">'+list[i].emailDetail+'</label></td></tr>').appendTo($("#doc-modal-list2"));

            }
        });
    });

     function chooseAdd() {
             $("#deAddress").empty();
         $('<span>'+$('[name="addressCho"]:checked').val()+'</span>').appendTo($("#deAddress"));
    }

    //邮箱选择事件
    function chooseEmail() {
        $("#emailopen").empty();
        $('<span>'+$('[name="emailCho"]:checked').val()+'</span>').appendTo($("#emailopen"));

    }
</script>

</body>

</html>