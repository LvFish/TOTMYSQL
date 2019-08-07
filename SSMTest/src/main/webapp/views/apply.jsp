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

                <li><a  href="/user/index"><i
                        class="fa fa-dashboard"></i> 我的流程</a></li>
                <li><a class="active-menu" href="/flow/apply"><i class="fa fa-desktop"></i>
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
                        审批
                    </h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" role="form">

                        <div class="form-group">
                            <label for="add-description" class="col-sm-2 control-label">审批意见</label>
                            <div class="col-sm-10">
                                <input type="hidden" class="form-control" id="add-id" required="required">
                                <input type="text" class="form-control" id="add-description" placeholder="审批意见" required="required">
                            </div>
                        </div>
                        <div class="form-group">
                            <label for="add-result" class="col-sm-2 control-label">审批结果</label>
                            <div class="col-sm-10">
                                <select id="add-result" class="form-control">
                                    <option value="1">同意</option>
                                    <option value="0">驳回</option>
                                </select>
                            </div>
                        </div>


                    </form>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                    </button>
                    <button type="button" onclick="dealApply()" class="btn btn-primary">
                        上传
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
                        流程审批
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
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    <tr>
                                        <th>申请人</th>
                                        <th>申请时间</th>
                                        <th>申请事件</th>
                                        <th>申请描述</th>
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
        getStepList();

    });

    function dealApply(){
        var flowId = document.getElementById('add-id').value;
        var description = document.getElementById('add-description').value;
        var result = document.getElementById('add-result').value;
        console.log(result);
        $.ajax({
            url:'/flow/addStep',
            type:'post',
            data:{
                'flowId':flowId,
                'description':description,
                'result':result
            },
            async:false,
            success:function(res) {
                $('#myModal').modal('hide');
                location.reload();
            }
        });

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

    $(".panel-body").on('click', 'button#approval', function () {

         var data = $("#dataTables-example").DataTable().row($(this).parents("tr")).data();
         document.getElementById('add-id').value = data.flowId;
        // document.getElementById('upload-file').value = "";
        /*  alert("Do you want delete " + data.username + "?"); */
        $('#myModal').modal('show');

    });

    function getStepList(){
        $.ajax({  // ajax登陆请求
            url:"/user/getApprovalWorkFlow",
            type:"post",
            data:{
            },
            async:false,
            success:function(res){
                var jsonDate =res;

                var msg = jsonDate.approvalWorkFlowList;
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

                        { "mData": "nickname"},
                        { "mData": function(obj){
                                return getMyDate(obj.addTime.time)//通过调用函数来格式化所获取的时间戳
                            }},// 是否选中
                        { "mData": "flowName"},
                        {"mData" : "description"},
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
                                var button  = "<button style='margin-right: 10px;' id='approval' class='btn btn-primary' type='button'>审批</button>";
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
