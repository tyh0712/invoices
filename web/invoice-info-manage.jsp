<%--
  Created by IntelliJ IDEA.
  User: 88
  Date: 2022/12/2
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>供应链金融平台</title>
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
    <style>
        .am-tabs-bd {
            border: none;
        }

        .am-tabs-bd .am-tab-panel {
            padding: 0
        }
    </style>
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
            发票信息管理
        </div>
        <div class="am-tabs" data-am-tabs>
            <ul class="am-tabs-nav am-nav am-nav-tabs" style="height: 50px;border:none">
                <li class="am-active">
                    <a href="#tab1">基础信息管理</a>
                </li>
                <li>
                    <a href="#tab2">邮寄地址管理</a>
                </li>
                <li>
                    <a href="#tab3">电子邮箱</a>
                </li>
            </ul>
            <div class="am-tabs-bd">
                <div class="am-tab-panel am-active" id="tab1">
                    <div class="tpl-portlet-components">
                        <div class="tpl-block ">
                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <form class="am-form">
                                        <table class="am-table am-table-striped am-table-hover table-main">
                                            <thead>
                                            <tr>
                                                <th class="table-title">序号</th>
                                                <th class="table-title">发票抬头</th>
                                                <th class="table-author am-hide-sm-only">税号</th>
                                                <th class="table-author am-hide-sm-only">开户银行</th>
                                                <th class="table-date am-hide-sm-only">开户账号</th>
                                                <th class="table-date am-hide-sm-only">注册固定电话</th>
                                                <th class="table-date am-hide-sm-only">注册场所地址</th>
                                                <th class="table-date am-hide-sm-only">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="doc-modal-list1">
                                            <tr data-id="2">
                                                <td class="am-hide-sm-only">
                                                    <span name="bid1"></span>
                                                </td>
                                                <td class="am-hide-sm-only" name="title1">
                                                    <span style="background-color: rgba(230, 247, 255, 1);border: 1px solid;color: #1890FF;padding:3px 5px;border-radius: 3px;">默认</span>
                                                </td>
                                                <td class="am-hide-sm-only" name="taxNo1"></td>
                                                <td>
                                                    <div class="editRow" name="bankName1"></div>
                                                    <input type="text" class="am-form-field editInput" value="${baseData.bankName}"
                                                           style="border: 1px solid #c2cad8;width: 70%;border-radius: 3px;" name="bankName2">
                                                </td>
                                                <td class="am-hide-sm-only">
                                                    <div class="editRow" name="bankAccount1"></div>
                                                    <input type="text" class="am-form-field editInput"
                                                           value="${baseData.bankAccount}"
                                                           style="border: 1px solid #c2cad8;width: 70%;border-radius: 3px;" name="bankAccount2">
                                                </td>
                                                <td class="am-hide-sm-only">
                                                    <div class="editRow" name="phone1"></div>
                                                    <input type="text" class="am-form-field editInput"
                                                           value="${baseData.phone}"
                                                           style="border: 1px solid #c2cad8;width: 70%;border-radius: 3px;" name="phone2">
                                                </td>
                                                <td class="am-hide-sm-only">
                                                    <div class="editRow" name="address1"></div>
                                                    <input type="text" class="am-form-field editInput"
                                                           value="${baseData.address}"
                                                           style="border: 1px solid #c2cad8;width: 70%;border-radius: 3px;" name="address2">
                                                </td>
                                                <td>
                                                    <div class="am-btn-toolbar">
                                                        <div class="am-btn-group am-btn-group-xs">
                                                            <div class="am-g">
                                                                <div class="am-u-sm-4" id="editBtn">
                                      <span class="am-text-secondary"
                                            style="cursor:pointer;width: 30px;display: inline-block;color:#007bff">
                                        编辑</span>
                                                                </div>
                                                                <div class="am-u-sm-10">
                                        <span id="saveBtn" class=" "
                                              style="cursor:pointer;width: 30px;color:#007bff;display:inline-block">
                                        保存</span>
                                                                    <span id="cancelBtn" class=""
                                                                          style="cursor:pointer;width: 30px;color:#007bff;display:inline-block">
                                        取消</span>
                                                                </div>
                                                                <div class="am-u-sm-1">
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </td>
                                            </tr>
                                            </tbody>
                                        </table>
                                        <div style="text-align: center;margin-top:40px">
                                            <a class="am-btn am-btn-default" href="invoice-list.jsp">返&nbsp;&nbsp;&nbsp;&nbsp;
                                                回
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-tab-panel" id="tab2">
                    <div class="tpl-portlet-components">
                        <div class="tpl-block ">
                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <form class="am-form">
                                        <table class="am-table am-table-striped am-table-hover table-main"
                                               id="table_id_address">
                                            <thead>
                                            <tr>
                                                <th class="table-title">序号</th>
                                                <th class="table-title">收件人</th>
                                                <th class="table-author am-hide-sm-only">联系电话</th>
                                                <th class="table-author am-hide-sm-only">省市区</th>
                                                <th class="table-date am-hide-sm-only">详细地址</th>
                                                <th class="table-date am-hide-sm-only">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="doc-modal-list2">

                                            </tbody>
                                        </table>
                                        <div style="text-align: center;margin-top:40px">
                                            <a class="am-btn am-btn-default" href="invoice-list.jsp">返&nbsp;&nbsp;&nbsp;&nbsp;
                                                回
                                            </a>
                                            <a id="submitBtn" class="am-btn am-btn-primary" onclick="add_address()"
                                               style="margin-left:20px">新&nbsp;&nbsp;&nbsp;&nbsp; 增
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="am-tab-panel" id="tab3">
                    <div class="tpl-portlet-components">
                        <div class="tpl-block ">
                            <div class="am-g">
                                <div class="am-u-sm-12">
                                    <form class="am-form">
                                        <table class="am-table am-table-striped am-table-hover table-main"
                                               id="table_id_email">
                                            <thead>
                                            <tr>
                                                <th class="table-title">序号</th>
                                                <th class="table-title">邮箱</th>
                                                <th class="table-date am-hide-sm-only">操作</th>
                                            </tr>
                                            </thead>
                                            <tbody id="doc-modal-list3">

                                            </tbody>
                                        </table>
                                        <div style="text-align: center;margin-top:40px">
                                            <a class="am-btn am-btn-default" href="invoice-list.jsp">返&nbsp;&nbsp;&nbsp;&nbsp;
                                                回
                                            </a>
                                            <a class="am-btn am-btn-primary" onclick="addtmpParam()"
                                               style="margin-left:20px">新&nbsp;&nbsp;&nbsp;&nbsp; 增
                                            </a>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="js/jquery.min.js"></script>
<script src="js/amazeui.min.js"></script>
<script src="js/app.js"></script>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script>

    var bid = 0;
    var enterpriseId = ${sessionScope.enterpriseId};
    $(document).ready(function () {
        //发票信息管理  序号、抬头、税号、开户银行、开户账号、注册固定电话、注册场所地址
        $.get("bs","b=1&enterpriseId="+enterpriseId,function (baseData1) {
            eval("var baseData=" + baseData1);
            $("[name=bid1]").text(baseData.bid);
            bid = baseData.bid;
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
    })

    //   发票
    var cancelBtn = document.getElementById('cancelBtn');
    cancelBtn.style.display = "none";
    var saveBtn = document.getElementById('saveBtn');
    saveBtn.style.display = "none";
    var editBtn = document.getElementById('editBtn');
    var editRow = document.getElementsByClassName('editRow');
    var editInput = document.getElementsByClassName('editInput');
    for (var i = 0; i < editInput.length; i++) {
        editInput[i].style.display = "none";
    }
    // 取消按钮
    $(function () {
        $('#cancelBtn').on('click', function () {
            cancelBtn.style.display = "none";
            editBtn.style.display = "block";
            saveBtn.style.display = "none";

            for (var i = 0; i < editRow.length; i++) {
                editRow[i].style.display = "block";
            }

            for (var i = 0; i < editInput.length; i++) {
                editInput[i].style.display = "none";
            }
        });
    });

    // 保存按钮
    $(function () {
        $('#saveBtn').on('click', function () {
            cancelBtn.style.display = "none";
            saveBtn.style.display = "none";
            editBtn.style.display = "block";
            for (var i = 0; i < editRow.length; i++) {
                editRow[i].style.display = "block";
            }

            for (var i = 0; i < editInput.length; i++) {
                editInput[i].style.display = "none";
            }

            var bankName = $("[name=bankName2]").val();
            var bankAccount = $("[name=bankAccount2]").val();
            var phone = $("[name=phone2]").val();
            var address = $("[name=address2]").val();

            $.get("bs","b=2&enterpriseId="+enterpriseId+"&bid="+bid+"&bankName="+bankName+"&bankAccount="+bankAccount+"&phone="+phone+"&address="+address,function (baseData1) {
                $("[name=bankName1]").empty();
                $("[name=bankAccount1]").empty();
                $("[name=phone1]").empty();
                $("[name=address1]").empty();

                eval("var baseData3=" + baseData1);
                $("[name=bankName1]").text(baseData3.bankName);
                $("[name=bankAccount1]").text(baseData3.bankAccount);
                $("[name=phone1]").text(baseData3.phone);
                $("[name=address1]").text(baseData3.address);
            });
        });
    });

    // 编辑按钮
    $(function () {
        $('#editBtn').on('click', function () {
            cancelBtn.style.display = "inline-block";
            saveBtn.style.display = "inline-block";
            editBtn.style.display = "none";
            for (var i = 0; i < editRow.length; i++) {
                editRow[i].style.display = "none";
            }

            for (var i = 0; i < editInput.length; i++) {
                editInput[i].style.display = "block";
            }
        });
    });

    // 电子邮箱
    function addtmpParam() {
        var Table = document.getElementById("table_id_email");
        var rowsNum = Table.rows.length - 1;
        NewRow = Table.insertRow(); //添加行
        ID = NewRow.insertCell(); //添加列
        Name = NewRow.insertCell();
        // NO = NewRow.insertCell();
        // Type = NewRow.insertCell();
        // defaultV = NewRow.insertCell();
        operate = NewRow.insertCell();
        //属性赋值
        ID.innerHTML = rowsNum + 1;
        Name.innerHTML = "<input id=Name" + (rowsNum + 1) + " style='width:120px' type='text' />";
        // NO.innerHTML = "<input id=No" +  (rowsNum + 1) +"  style='width: 80px;' type='text' />";
        operate.innerHTML = '<div id=operate' + (rowsNum + 1) + '><a style="cursor:pointer;color:#007bff;"  onclick="saveInterfaceParam();">保存</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;"  onclick="saveInterfaceParam();">取消</a></div>';
    }

    function saveInterfaceParam() {
        var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
        //获取行索引，修改input样式，其中parentElement和table中的标签层级相关，不是一成不变
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $("#Name" + key).attr("disabled", true);
        $("#No" + key).attr("disabled", true);
        $("#Type" + key).attr("disabled", true);
        $("#defaultV" + key).attr("disabled", true);
        var div1 = $("#operate" + key);
        div1[0].innerHTML = '<a style="cursor:pointer;color:#007bff;"  onclick="editInterfaceParam()">编辑</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;">设为默认</a>';
    }

    function editInterfaceParam() {
        var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $("#Name" + key).attr("disabled", false);
        $("#No" + key).attr("disabled", false);
        $("#Type" + key).attr("disabled", false);
        $("#defaultV" + key).attr("disabled", false);
        var div1 = $("#operate" + key);
        div1[0].innerHTML = '<a style="cursor:pointer;color:#007bff;"  onclick="saveInterfaceParam();">保存</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;"  onclick="saveInterfaceParam();">取消</a>';
    }

    // 邮寄地址
    function add_address() {

        $.get("as","a=2&enterpriseId="+enterpriseId,function (list) {
            eval("var list="+list);
            var i=list.length - 1;
            var Tbody = document.querySelector('#table_id_address tbody')
            var rowsNum = Tbody.rows.length;
            NewRow = Tbody.insertRow(); //添加行
            ID = NewRow.insertCell(); //添加列
            Name = NewRow.insertCell();
            NO = NewRow.insertCell();
            Type = NewRow.insertCell();
            defaultV = NewRow.insertCell();
            operate = NewRow.insertCell();
            //属性赋值
            ID.innerHTML = list[i].aid+1;
            Name.innerHTML = "<input id=Name" + (list[i].aid+1) + " style='width: 120px;' type='text' />";
            NO.innerHTML = "<input id=No" + (list[i].aid+1) + "  style='width: 120px;' type='text' />";
            Type.innerHTML = "<input id=Type" + (list[i].aid+1) + "  style='width: 120px;' type='text' />";
            defaultV.innerHTML = "<input id=defaultV" + (list[i].aid+1) + "  style='width: 120px;' type='text' />";
            operate.innerHTML = '<div id=operate' + (list[i].aid+1) + '><a style="cursor:pointer;color:#007bff;"  onclick="saveNewAddress()">保存</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;"  onclick="saveNewAddress()">取消</a></div>';
        });
    }


    $(function () {
        $.get("as","a=2&enterpriseId="+enterpriseId,function (list) {
            eval("var list="+list);
            for (var i=0;i<list.length;i++){
                var Tbody = document.querySelector('#table_id_address tbody')
                var rowsNum = Tbody.rows.length;
                NewRow = Tbody.insertRow(); //添加行
                ID = NewRow.insertCell(); //添加列
                Name = NewRow.insertCell();
                NO = NewRow.insertCell();
                Type = NewRow.insertCell();
                defaultV = NewRow.insertCell();
                operate = NewRow.insertCell();
                //属性赋值
                ID.innerHTML = list[i].aid;
                Name.innerHTML = "<input id=Name" + (list[i].aid) + " value='"+list[i].addressee+"'  style='width: 120px;' type='text' disabled='disabled'/>";
                NO.innerHTML = "<input id=No" + (list[i].aid) + " value='"+list[i].phone+"'  style='width: 120px;' type='text' /disabled='disabled'>";
                Type.innerHTML = "<input id=Type" + (list[i].aid) + " value='"+list[i].area+"'  style='width: 120px;' type='text' disabled='disabled'/>";
                defaultV.innerHTML = "<input id=defaultV" + (list[i].aid) + " value='"+list[i].addressDetail+"'  style='width: 120px;' type='text' disabled='disabled'/>";
                if (list[i].defaultStatus=="A"){
                    operate.innerHTML = "<div id=operate" + (list[i].aid) + "><a style='cursor:pointer;color:#007bff;'  onclick='editAddress()'>编辑&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"background-color: rgba(230, 247, 255, 1);border: 1px solid;color: #1890FF;padding:3px 5px;border-radius: 3px;\">默认</span></div>";
                }else {
                    operate.innerHTML = "<div id=operate" + (list[i].aid) + "><a style='cursor:pointer;color:#007bff;'  onclick='editAddress()'>编辑</a>&nbsp;&nbsp;<a style='cursor:pointer;color:#007bff;'  onclick='setDefault()'>设为默认</a></div>";
                }
            }
        });
    });

    function setDefault() {
        var td = event.srcElement;
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $.get("as", "a=4&aid=" + key + "&enterpriseId=" + enterpriseId, function (list) {
            $("#doc-modal-list2").empty();
            eval("var list=" + list);
            for (var i = 0; i < list.length; i++) {
                var Tbody = document.querySelector('#table_id_address tbody')
                var rowsNum = Tbody.rows.length;
                NewRow = Tbody.insertRow(); //添加行
                ID = NewRow.insertCell(); //添加列
                Name = NewRow.insertCell();
                NO = NewRow.insertCell();
                Type = NewRow.insertCell();
                defaultV = NewRow.insertCell();
                operate = NewRow.insertCell();
                //属性赋值
                ID.innerHTML = list[i].aid;
                Name.innerHTML = "<input id=Name" + (list[i].aid) + " value='" + list[i].addressee + "'  style='width: 120px;' type='text' disabled='disabled'/>";
                NO.innerHTML = "<input id=No" + (list[i].aid) + " value='" + list[i].phone + "'  style='width: 120px;' type='text' /disabled='disabled'>";
                Type.innerHTML = "<input id=Type" + (list[i].aid) + " value='" + list[i].area + "'  style='width: 120px;' type='text' disabled='disabled'/>";
                defaultV.innerHTML = "<input id=defaultV" + (list[i].aid) + " value='" + list[i].addressDetail + "'  style='width: 120px;' type='text' disabled='disabled'/>";
                if (list[i].defaultStatus == "A") {
                    operate.innerHTML = "<div id=operate" + (list[i].aid) + "><a style='cursor:pointer;color:#007bff;'  onclick='editAddress()'>编辑&nbsp;&nbsp;&nbsp;&nbsp;<span style=\"background-color: rgba(230, 247, 255, 1);border: 1px solid;color: #1890FF;padding:3px 5px;border-radius: 3px;\">默认</span></div>";
                } else {
                    operate.innerHTML = "<div id=operate" + (list[i].aid) + "><a style='cursor:pointer;color:#007bff;'  onclick='editAddress()'>编辑</a>&nbsp;&nbsp;<a style='cursor:pointer;color:#007bff;'  onclick='setDefault()'>设为默认</a></div>";
                }
            }
        });
    }
    function saveNewAddress() {
        var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
        //获取行索引，修改input样式，其中parentElement和table中的标签层级相关，不是一成不变
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $("#Name" + key).attr("disabled", true);
        $("#No" + key).attr("disabled", true);
        $("#Type" + key).attr("disabled", true);
        $("#defaultV" + key).attr("disabled", true);
        var div1 = $("#operate" + key);
        $.get("as","a=5&enterpriseId="+enterpriseId+"&addressee="+$("#Name"+key).val()+ "&phone="+$("#No"+key).val()+ "&area="+$("#Type"+key).val()+ "&addressDetail="+$("#defaultV"+key).val(),function (str) {
            eval("var str="+str);
        });
        div1[0].innerHTML = '<a style="cursor:pointer;color:#007bff;"  onclick="editAddress()">编辑</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;">设为默认</a>';
    }

    function saveAddress() {
        var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
        //获取行索引，修改input样式，其中parentElement和table中的标签层级相关，不是一成不变
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $("#Name" + key).attr("disabled", true);
        $("#No" + key).attr("disabled", true);
        $("#Type" + key).attr("disabled", true);
        $("#defaultV" + key).attr("disabled", true);
        var div1 = $("#operate" + key);
        $.get("as","a=3&aid="+key+"&addressee="+$("#Name"+key).val()+ "&phone="+$("#No"+key).val()+ "&area="+$("#Type"+key).val()+ "&addressDetail="+$("#defaultV"+key).val(),function (str) {
            eval("var str="+str);
        });
        div1[0].innerHTML = '<a style="cursor:pointer;color:#007bff;"  onclick="editAddress()">编辑</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;">设为默认</a>';
    }

    function editAddress() {
        var td = event.srcElement; // 通过event.srcElement 获取激活事件的对象 td
        var key = td.parentElement.parentElement.parentElement.innerText.split("\n")[0].trim();
        $("#Name" + key).attr("disabled", false);
        $("#No" + key).attr("disabled", false);
        $("#Type" + key).attr("disabled", false);
        $("#defaultV" + key).attr("disabled", false);
        var div1 = $("#operate" + key);
        div1[0].innerHTML = '<a style="cursor:pointer;color:#007bff;"  onclick="saveAddress();">保存</a>&nbsp;&nbsp;<a style="cursor:pointer;color:#007bff;"  onclick="saveAddress();">取消</a>';
    }
</script>
</body>

</html>