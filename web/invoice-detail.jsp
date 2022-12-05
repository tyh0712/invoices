<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/12/2
  Time: 9:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body data-type="generalComponents">
<header class="am-topbar am-topbar-inverse admin-header">
    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">
        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list tpl-header-list">
            <li class="am-dropdown" data-am-dropdown data-am-dropdown-toggle>
                <a class="am-dropdown-toggle tpl-header-list-link" href="javascript:;">
                    <span class="tpl-header-list-user-nick" name="userName"></span><span class="tpl-header-list-user-ico"> <img
                        src="img/user01.png"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="login.jsp"><span class="am-icon-power-off"></span> 退出</a></li>
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
                            <a href="invoice-list.jsp" class="active">
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
            发票详情
        </div>
        <!-- 开票相关订单信息 -->
        <div class="tpl-portlet-components">
            <div class="portlet-title">
                <div class="caption font-green bold">
                    开票相关订单信息
                </div>
                <div class="tpl-portlet-input tpl-fz-ml">
                    <div class="portlet-input input-small input-inline">
                        <div class="input-icon right">
                        </div>
                    </div>
                </div>
            </div>
            <div class="tpl-block ">
                <div class="am-g">
                    <div class="am-u-sm-12">
                        <div><span style="font-size: 16px;margin-left: 7px;">合计开票金额：</span> <span
                                style="color: red;font-size: 22px;font-weight: bold;" name="sum"></span></div>
                        <form class="am-form">
                            <table class="am-table am-table-striped am-table-hover table-main">
                                <thead>
                                <tr>
                                    <th class="table-title">订单编号</th>
                                    <th class="table-author am-hide-sm-only">相关企业</th>
                                    <th class="table-author am-hide-sm-only">订单金额（元）</th>
                                    <th class="table-date am-hide-sm-only">生成时间</th>
                                </tr>
                                </thead>
                                <tbody id="doc-modal-list">

                                </tbody>
                            </table>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!--抬头信息 -->
        <div class="tpl-portlet-components">
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
                <div class="am-g tpl-amazeui-form" style="padding:0">
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">发票种类</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="category1">
                                </div>
                            </div>
                        </form>
                        <hr>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6" style="padding:0">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">发票类型</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="type1">
                                </div>
                            </div>
                        </form>
                        <hr>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6" style="padding:0">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">抬头</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="title1"></div>
                            </div>
                        </form>
                        <hr>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6" style="padding:0">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group">
                                <label class="am-u-sm-3 am-form-label">税号</label>
                                <div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;" name="taxNo1"></div>
                            </div>
                        </form>
                        <hr>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                        <form class="am-form am-form-horizontal">
                            <div class="am-form-group" id="addAndEmail">

                            </div>
                        </form>
                    </div>
                    <div class="am-u-sm-12 am-u-md-6">
                    </div>
                </div>
                <div style="text-align: center;margin-top:40px">
                    <a class="am-btn am-btn-default" href="invoice-list.jsp">返 回</a>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script>

    $(document).ready(function () {
        var enterpriseId = ${sessionScope.enterpriseId};
        var iid = "${sessionScope.detaillist.iid}";
        $(function () {
            // var iid = 1;
            var sum = 0.00;
            $.get("os","o=4&invoicingRecordId="+iid,function (list1) {
                eval("var orderlist="+list1);
                for (var i=0;i<orderlist.length;i++){
                    var obj = "<tr data-id=\"2\">\n" +
                        "    <td class=\"am-hide-sm-only\">"+orderlist[i].no+"</td>\n" +
                        "    <td class=\"am-hide-sm-only\">"+baseData.title+"</td>\n" +
                        "    <td class=\"am-hide-sm-only\">"+orderlist[i].totalAmount+"</td>\n" +
                        "    <td class=\"am-hide-sm-only\">"+orderlist[i].createTime+"</td>\n" +
                        "</tr>";
                    $(obj).appendTo($("#doc-modal-list"));
                    sum += orderlist[i].totalAmount;
                }
                $("[name=sum]").text(sum+"元");
            });
        });
        //右上角用户名
        var userName1 = "${sessionScope.userName}";
        $("[name=userName]").text(userName1);

        //抬头信息 抬头、税号
        var baseData = null;
        $.get("bs","b=1&enterpriseId="+enterpriseId,function (baseData1) {
            eval("baseData=" + baseData1);
            $("[name=title1]").text(baseData.title);
            $("[name=taxNo1]").text(baseData.taxNo);
        });
        var x='${sessionScope.detaillist["category"]}';
        var y='${sessionScope.detaillist["type"]}';
        var obj1="<span>"+x+"</span>";
        $(obj1).appendTo($("[class=\"am-u-sm-9\"]:eq(0)"));
        var obj2="<span>"+y+"</span>";
        $(obj2).appendTo($("[class=\"am-u-sm-9\"]:eq(1)"));



        //邮寄地址信息addAndEmail
        $(function () {
            var aid = "${sessionScope.detaillist.address.aid}";
            var eid = "${sessionScope.detaillist.email.eid}";
            // var aid=1;
            // var eid=null;
            if (eid==1){
                $.get("as","a=7&aid="+aid,function (address) {
                    eval("var address="+address);
                    $("#addAndEmail").empty();
                    $('<label class="am-u-sm-3 am-form-label">邮寄地址' +
                        '</label><div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">'
                        +address.area+''+address.addressDetail+'</div>').appendTo($("#addAndEmail"));
                });
            }
            if (aid==1) {
                $.get("es", "e=4&eid=" + eid, function (email) {
                    eval("var email=" + email);
                    $("#addAndEmail").empty();
                    $('<label class="am-u-sm-3 am-form-label">邮箱' +
                        '</label><div class="am-u-sm-9" style="margin-top: 4px;font-size: 16px;">'
                        + email.emailDetail + '</div>').appendTo($("#addAndEmail"));
                });
            }
        });

    });
</script>
</body>

</html>
