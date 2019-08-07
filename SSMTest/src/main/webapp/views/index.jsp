<%--
  Created by IntelliJ IDEA.
  User: liujiawang
  Date: 2019/5/14
  Time: 10:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Dream</title>
    <!-- Bootstrap Styles-->
    <link href="/assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="/assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="/assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="/assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='https://fonts.googleapis.com/css?family=Open+Sans'
          rel='stylesheet' type='text/css' />

    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="/assets/js/jquery-1.10.2.js"></script>
    <!-- Bootstrap Js -->
    <script src="/assets/js/bootstrap.min.js"></script>
    <!-- Metis Menu Js -->
    <script src="/assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="/assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="/assets/js/morris/morris.js"></script>
    <!-- Custom Js -->
    <script src="/assets/js/echarts.min.js"></script>
</head>

<body>
<div id="wrapper">
    <nav class="navbar navbar-default top-navbar" role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".sidebar-collapse">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span>
                <span
                        class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">流程管理</a>
        </div>


    </nav>
    <!--/. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">

                <li><a class="active-menu" href="#"><i
                        class="fa fa-dashboard"></i> 我的流程</a></li>
                <li><a href="/flow/apply"><i class="fa fa-desktop"></i>
                    流程审批</a></li>

            </ul>

        </div>

    </nav>

    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="myModalLabel">
                        流程申请
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">
                        <!--用户框-->
                        <div class="form-group">
                            <label for="add-name" class="col-sm-2 control-label">流程名</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="add-name" placeholder="流程名" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-description" class="col-sm-2 control-label">流程描述</label>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" id="add-description" placeholder="流程描述" required="required">
                            </div>
                        </div>

                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" onclick="addFlow()" class="btn btn-primary">
                        添加
                    </button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal -->
    </div>


    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h1 class="page-header">
                        我的流程 <small>查看所有流程</small>
                    </h1>
                </div>
            </div>
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-body">
                            <div class="table-responsive">
                                <button data-toggle="modal" data-target="#myModal"
                                        style="background:none;border:none;float:right;outline:none;"><i class="fa fa-plus" aria-hidden="true"></i></button>
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>流程名</th>
                                        <th>申请日期</th>
                                        <th>申请状态</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>

                                </table>
                            </div>

                        </div>
                    </div>
                    <!--End Advanced Tables -->
                </div>
            </div>
            <!-- /. PAGE WRAPPER  -->
        </div>
    </div>
</div>

<script src="/assets/js/jquery-1.10.2.js"></script>
<!-- Bootstrap Js -->
<script src="/assets/js/bootstrap.min.js"></script>
<!-- Metis Menu Js -->
<script src="/assets/js/jquery.metisMenu.js"></script>
<!-- DATA TABLE SCRIPTS -->
<script src="/assets/js/dataTables/jquery.dataTables.js"></script>
<script src="/assets/js/dataTables/dataTables.bootstrap.js"></script>

<script type="text/javascript">
    $(document).ready(function () {
        getWorkFlow();

    });
    function addFlow(){
        var name = document.getElementById("add-name").value;
        var description = document.getElementById("add-description").value;
        if(description.length<=0||name.length<=0){
            alert("请输入正确信息!");return;
        }
        $.ajax({
            url:"/flow/addFlow",
            type:"post",
            data:{
                'name':name,
                'description':description
            },
            async:false,
            success:function() {
                console.log(123);
                $('#myModal').modal('hide');
                location.reload();
            }
        })
    }

    function getMyDate(time){
        var oDate = new Date(time),
            oYear = oDate.getFullYear(),
            oMonth = oDate.getMonth()+1,
            oDay = oDate.getDate(),
                oTime = oYear +'-'+ getZF(oMonth) +'-'+ getZF(oDay);//最后拼接时间
        return oTime;
    };

    //补0操作,当时间数据小于10的时候，给该数据前面加一个0
    function getZF(num){
        if(parseInt(num) < 10){
            num = '0'+num;
        }
        return num;
    }

    $(".panel-body").on('click', 'button#showDetail', function () {
        var data = $("#dataTables-example").DataTable().row($(this).parents("tr")).data();
        console.log(data);
        window.location.href="/user/showDetail?workflowId="+data.flowId;
    });

    function getWorkFlow(){
        $.ajax({  // ajax登陆请求
            url:"/user/getUserWorkFlow",
            type:"post",
            data:{
            },
            async:false,
            success:function(res){
                var jsonDate =res;

                var msg = jsonDate.workFlowModelList;
                $('#dataTables-example').dataTable().fnDestroy();//sample_1是table的id
                $('#dataTables-example').dataTable( {
                    bProcessing : true,
                    searching : false,
                    "oLanguage" : { // 国际化配置
                        "sProcessing" : "正在获取数据，请稍后...",
                        "sLengthMenu" : "显示 _MENU_ 条",
                        "sZeroRecords" : "没有找到数据",
                        "sInfo" : "从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条",
                        "sInfoEmpty" : "记录数为0",
                        "sInfoFiltered" : "(全部记录数 _MAX_ 条)",
                        "sInfoPostFix" : "",
                        "sSearch" : "查询",
                        "sUrl" : "",
                        "oPaginate" : {
                            "sFirst" : "第一页",
                            "sPrevious" : "上一页",
                            "sNext" : "下一页",
                            "sLast" : "最后一页"
                        }
                    },

                    "aaData":msg,
                    "aoColumns": [
                        // 按顺序来
                        { "mData": "flowName"},
                        { "mData": function(obj){
                                return getMyDate(obj.addTime.time)//通过调用函数来格式化所获取的时间戳
                            }},// 是否选中
                        { "mData": function(obj){
                                if(obj.isOver == 1){
                                    return "已同意";
                                }else if(obj.isOver == 2){
                                    return "已驳回";
                                }else{
                                    return "审批中";
                                }
                            }},
                        {"mData" : ""},
                        /*  { "mData": 234}, */
                    ],
                    "columnDefs": [
                        //{
                        //    "targets": -2,//编辑
                        //    "data": null,
                        //    "defaultContent": "<button id='editrow' class='btn btn-primary' type='button'><i class='fa fa-edit'></i></button>"
                        //},
                        {
                            "targets": -1,//删除
                            "data": null,
                            "render": function() {
                                var button  = "<button style='margin-right: 10px;' id='showDetail' class='btn btn-primary' type='button'>查看详情</button>";
                                return button;
                            },

                        }

                    ] ,

                } );

            }
        });

    }
</script>


<!-- /. WRAPPER  -->
</body>
</html>
