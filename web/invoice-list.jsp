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
    <style>
        .ele-dot-text {
            width: 45px;
            display: inline-block;
            margin-left: 20px;
        }

        .ele-dot-status {

            width: 8px;
            height: 8px;
            display: inline-block;
            border-radius: 50%;
            line-height: 10px;
        }

        .ele-dot-status-success {
            background: #52c41a;
        }

        .ele-dot-status-error {
            background: #ff4d4f;
        }

        .ele-dot-status-info {
            background: #1890ff;
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
            发票管理
        </div>
        <div class="am-g" style="height: 100px;">
            <div class="am-u-sm-6" style="padding-left: 0;">
                <div class="tpl-portlet-components">
                    <div class="tpl-block " id="resultDiv1">
                        <div class="am-g tpl-amazeui-form">
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-u-sm-12" style="text-align: center;font-weight: bold;">
                                    <div>可开票金额</div>
                                    <div id="divnewcount" style="color: red;font-size: 20px;"></div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-1">
                                <div class="am-u-sm-12" style="text-align: center;font-weight: bold;">
                                    <div>=</div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-u-sm-12" style="text-align: center;font-weight: bold;">
                                    <div>总计可开票金额</div>
                                    <div id="divallcount" style="color: red;font-size: 20px;"></div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-1">
                                <div class="am-u-sm-12" style="text-align: center;font-weight: bold;">
                                    <div>-</div>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-3">
                                <div class="am-u-sm-12" style="text-align: center;font-weight: bold;">
                                    <div>历史已开票</div>
                                    <div id="divusecont" style="color: red;font-size: 20px;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <a href="invoice-open.jsp" class="am-btn am-btn-primary"
                       style="margin-bottom: 10px;margin-left: 40px;margin-top: 8px;">去开票</a>
                </div>
            </div>
            <div class="am-u-sm-6">
                <div class="tpl-portlet-components">
                    <div class="tpl-block " id="resultDiv2">
                        <div></div>
                        <div class="am-g tpl-amazeui-form">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <span style="font-size: 18px;font-weight: bold;">发票抬头及地址信息</span>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <a href="invoice-info-manage.jsp" class="am-btn am-btn-default"
                                       style="float: right;">编辑</a>
                                </div>
                            </div>
                        </div>
                        <div class="am-g tpl-amazeui-form" style="font-size: 14px;color: #666;margin-bottom: 5px;">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <span style="color: #333;">抬头（默认）：</span> <span name="title1"></span>
                                </div>
                            </div>
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <span style="color: #333;">税号：</span> <span name="taxNo1"></span>
                                </div>
                            </div>
                        </div>
                        <div class="am-g tpl-amazeui-form" style="font-size: 14px;color: #666;margin-bottom: 5px;">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <span style="color: #333;">邮寄地址（默认）：</span><span id="deAddress"> </span>
                                </div>
                            </div>
                        </div>
                        <div class="am-g tpl-amazeui-form" style="font-size: 14px;color: #666;">
                            <div class="am-u-sm-12 am-u-md-6">
                                <div class="am-u-sm-12">
                                    <span style="color: #333;">电子邮箱：</span> <span>
                                            2134566876756453@qq.com</span>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 搜索条件 -->
        <div class="am-g" style="height: 100px;">
            <div class="am-u-sm-12" style="padding-left: 0;">
                <div class="tpl-portlet-components">
                    <div class="tpl-block " id="resultDiv3">
                        <div class="am-g tpl-amazeui-form">

                            <div class="am-u-sm-6 am-u-md-3">
                                <div class="am-input-group am-input-group-sm">
                                        <span class="am-input-group-btn">
                                            <span
                                                    style="font-size: 14px;margin-right: 8px;margin-left: 8px">发票申请日期</span>
                                        </span>
                                    <input type="text" class="am-form-field" data-am-datepicker
                                           placeholder="&nbsp;&nbsp;请选择日期"
                                           style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                                </div>
                            </div>

                            <div class="am-u-sm-6 am-u-md-3">
                                <div class="am-input-group am-input-group-sm">
                                        <span class="am-input-group-btn">
                                            <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">发票抬头</span>
                                        </span>
                                    <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;请输入发票抬头"
                                           style="border: 1px solid #c2cad8;width: 68%;border-radius: 3px;">
                                </div>
                            </div>
                            <div class="am-u-sm-6 am-u-md-3" style="margin-left: -10px;">
                                <div class="am-input-group am-input-group-sm">
                                        <span class="am-input-group-btn">
                                            <span style="font-size: 14px;margin-right: 8px;margin-left: 8px">发票金额</span>
                                        </span>
                                    <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最低金额(万)"
                                           style="border: 1px solid #c2cad8;width: 32%;border-radius: 3px;">
                                    <div class="am-form-field"
                                         style="width: 0%; border-radius: 3px;border: none;margin-left: 10px;">~
                                    </div>
                                    <input type="text" class="am-form-field" placeholder="&nbsp;&nbsp;最高金额(万)"
                                           style="border: 1px solid #c2cad8;width: 32%;border-radius: 3px;margin-left: 20px;">
                                </div>
                            </div>
                            <div class="am-g">
                                <div class="am-u-sm-6 am-u-md-3">
                                    <div class="am-input-group am-input-group-sm">
                                            <span class="am-input-group-btn">
                                                <span
                                                        style="font-size: 14px;margin-right: 8px;margin-left: 8px">处理状态</span>
                                            </span>
                                        <div class="am-btn-group am-btn-group-sm status-type">
                                            <button type="button" class="am-btn am-btn-primary am-radius">全部
                                            </button>
                                            <button type="button" class="am-btn am-btn-default">申请中</button>
                                            <button type="button" class="am-btn am-btn-default">已开票</button>
                                            <button type="button" class="am-btn am-btn-default">已作废</button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- 发票列表 -->
        <div class="tpl-portlet-components">
            <div class="am-g">
                <div class="am-u-sm-12">
                    <form class="am-form">
                        <table class="am-table am-table-striped am-table-hover table-main">
                            <thead>
                            <tr>
                                <th class="table-title">发票申请时间</th>
                                <th class="table-author am-hide-sm-only">发票抬头</th>
                                <th class="table-author am-hide-sm-only">发票金额（元）</th>
                                <th class="table-date am-hide-sm-only">上链地址</th>
                                <th class="table-date am-hide-sm-only">处理状态</th>
                                <th class="table-set">操作</th>
                            </tr>
                            </thead>
                            <tbody id="doc-modal-list">
                                <tr data-id="2">
                                    <td class="am-hide-sm-only">2021-12-31 12：12：12</td>
                                    <td class="am-hide-sm-only">百度科技有限公司</td>
                                    <td class="am-hide-sm-only">1,000,000.00</td>
                                    <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                    <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-success"><span>
                                                    <span class="ele-dot-text"> 已开票</span>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="invoice-detail.jsp"><span class="am-text-secondary"
                                                                                   style="cursor:pointer"><span></span>
                                                            详情</span></a>
                                                <span class="am-text-secondary am-icon"
                                                      style="cursor:pointer"><span></span>
                                                        退票</span>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-id="2">
                                    <td class="am-hide-sm-only">2021-12-31 12：12：12</td>
                                    <td class="am-hide-sm-only">百度科技有限公司</td>
                                    <td class="am-hide-sm-only">1,000,000.00</td>
                                    <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                    <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-error"><span>
                                                    <span class="ele-dot-text">已作废</span>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="invoice-detail.jsp"><span class="am-text-secondary"
                                                                                   style="cursor:pointer"><span></span>
                                                            详情</span></a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-id="2">
                                    <td class="am-hide-sm-only">2021-12-31 12：12：12</td>
                                    <td class="am-hide-sm-only">百度科技有限公司</td>
                                    <td class="am-hide-sm-only">1,000,000.00</td>
                                    <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                    <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-error"><span>
                                                    <span class="ele-dot-text">已作废</span>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="invoice-detail.jsp"><span class="am-text-secondary"
                                                                                   style="cursor:pointer"><span></span>
                                                            详情</span></a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-id="2">
                                    <td class="am-hide-sm-only">2021-12-31 12：12：12</td>
                                    <td class="am-hide-sm-only">百度科技有限公司</td>
                                    <td class="am-hide-sm-only">1,000,000.00</td>
                                    <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                    <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-error"><span>
                                                    <span class="ele-dot-text">已作废</span>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="invoice-detail.jsp"><span class="am-text-secondary"
                                                                                   style="cursor:pointer"><span></span>
                                                            详情</span></a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                <tr data-id="2">
                                    <td class="am-hide-sm-only">2021-12-31 12：12：12</td>
                                    <td class="am-hide-sm-only">百度科技有限公司</td>
                                    <td class="am-hide-sm-only">1,000,000.00</td>
                                    <td class="am-hide-sm-only">F64A3FA774552D72</td>
                                    <td class="am-hide-sm-only">
                                            <span class="ele-dot-status ele-dot-status-success"><span>
                                                    <span class="ele-dot-text">已开票</span>
                                    <td>
                                        <div class="am-btn-toolbar">
                                            <div class="am-btn-group am-btn-group-xs">
                                                <a href="invoice-detail.jsp"><span class="am-text-secondary"
                                                                                   style="cursor:pointer"><span></span>
                                                            详情</span></a>
                                                <span class="am-text-secondary am-icon"
                                                      style="cursor:pointer"><span></span>
                                                        退票</span>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <div class="am-cf">
                            <div class="am-fr">
                                <ul class="am-pagination tpl-pagination">
                                    <li class="am-disabled"><a href="#">«</a></li>
                                    <li class="am-active"><a href="#">1</a></li>
                                    <li><a href="#">2</a></li>
                                    <li><a href="#">3</a></li>
                                    <li><a href="#">4</a></li>
                                    <li><a href="#">5</a></li>
                                    <li><a href="#">»</a></li>
                                </ul>
                            </div>
                        </div>
                        <hr>
                    </form>
                </div>
                <!-- 退票二次确认弹出框 -->
                <div class="am-modal am-modal-confirm" tabindex="-1" id="my-confirm">
                    <div class="am-modal-dialog" style="font-size: 16px;">
                        <div class="am-modal-hd">提示</div>
                        <div class="am-modal-bd">
                            将进行退票，是否继续？
                        </div>
                        <div class="am-modal-footer">
                            <span class="am-modal-btn" data-am-modal-cancel>取消</span>
                            <span class="am-modal-btn" data-am-modal-confirm>确定</span>
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
    // 退票二次确认
    $(function () {
        //状态按钮样式切换
        $('.status-type').find('button').on('click', function () {
            let statusTypeBtnArr = $('.status-type').find('button');
            for (let i = 0; i < statusTypeBtnArr.length; i++) {
                statusTypeBtnArr.eq(i).removeClass('am-btn-primary');
            }
            $(this).addClass('am-btn-primary');
        });
        $('#doc-modal-list').find('.am-icon').add('#doc-confirm-toggle').on('click', function () {
            $('#my-confirm').modal({
                relatedTarget: this,
                onConfirm: function (options) {
                    //点击确认调用函数
                    alert("点击了确认");
                },
                onCancel: function () {
                    //点击取消调用函数
                    alert("点击了取消")
                }
            });
        });
    });

    var eid = ${sessionScope.eid};
    $(function () {
        var post=$.post("as","a=1&enterpriseId="+eid,function (address) {
            eval("var address="+address);
            $("[id=deAddress]").text(address.area+""+address.addressDetail);
        });
    });

    $.get("os","o=1&invoicingRecordId="+eid,function (count) {
        eval("var getamount=" + count);
        $("#divallcount").text(getamount[0]+"元");
        $("#divusecont").text(getamount[1]+"元");
        $("#divnewcount").text(getamount[2]+"元");
    });
</script>
<script>
    $(document).ready(function () {
        var eid = ${sessionScope.eid};
        $.get("bs","b=1&eid="+eid,function (baseData1) {
            eval("var baseData=" + baseData1);
            var title = baseData.title;
            $("[name=title1]").text(title);
            $("[name=taxNo1]").text(baseData.taxNo);
        });

        var userName1 = "${sessionScope.userName}";
        $("[name=userName]").text(userName1);
    });
</script>
</body>

</html>