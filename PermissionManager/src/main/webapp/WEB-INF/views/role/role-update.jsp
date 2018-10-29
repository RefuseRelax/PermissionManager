<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Amaze UI Admin index Examples</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <link rel="icon" type="image/png" href="assets/i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI" />
    <script src="assets/js/echarts.min.js"></script>
    <link rel="stylesheet" href="assets/css/amazeui.min.css" />
    <link rel="stylesheet" href="assets/css/amazeui.datatables.min.css" />
    <link rel="stylesheet" href="assets/css/app.css">
    <script src="assets/js/jquery.min.js"></script>
    
    <link rel="stylesheet" href="static/css/dtree.css">
</head>

<body data-type="widgets">
    <script src="assets/js/theme.js"></script>

            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 角色 <small>role</small></div>
                        <p class="page-header-description">Amaze UI 有许多不同的表格可用。</p>
                    </div>
                    <div class="am-u-lg-3 tpl-index-settings-button">
                        <button type="button" class="page-header-button" onclick="javascript:history.go(-1)"><span class="am-icon-paint-brush"></span> 返回</button>
                    </div>
                </div>

            </div>

            <div class="row-content am-cf">


                <div class="row">

                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-12">
                        <div class="widget am-cf">
                            <div class="widget-head am-cf">
                                <div class="widget-title am-fl">角色修改</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-line-form" id="roleUpdate" action="/role?op=execUpdate" method="post">
                               	    <input type="hidden" id="id" name="id" value="${role.id}">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">角色名称 <span class="tpl-form-line-small-title">名称</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="rname" name="rname" placeholder="请输入角色名称" value="${role.rname}">
                                            <small>请填写角色名称。</small>
                                        </div>
                                    </div>
                                    
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">角色代码 <span class="tpl-form-line-small-title">代码</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="rcode" name="rcode" placeholder="请输入角色代码" value="${role.rcode}" readonly="readonly">
                                            <small>请填写角色代码,使用大写字母,每个单词下划线隔开。</small>
                                        </div>
                                    </div>
                                    
                                     <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">角色描述 <span class="tpl-form-line-small-title">描述</span></label>
                                        <div class="am-u-sm-9">
                                            <textarea class="" rows="10" name="description" id="description" placeholder="请输入角色描述" >${role.rdescription}</textarea>
                                        </div>
                                    </div>
                                    
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">角色权限 <span class="tpl-form-line-small-title">权限</span></label>
                                        <div class="am-u-sm-9">
                                         	<div id="tree" class="dtree">	
                                         	</div>
                                            <small>请选择角色权限。</small>
                                        </div>
                                    </div>


                                <!--    <div class="am-form-group">
                                        <label for="user-weibo" class="am-u-sm-3 am-form-label">封面图 <span class="tpl-form-line-small-title">Images</span></label>
                                        <div class="am-u-sm-9">
                                            <div class="am-form-group am-form-file">
                                                <div class="tpl-form-file-img">
                                                    <img src="assets/img/a5.png" alt="">
                                                </div>
                                                <button type="button" class="am-btn am-btn-danger am-btn-sm">
    <i class="am-icon-cloud-upload"></i> 添加封面图片</button>
                                                <input id="doc-form-file" type="file" multiple="">
                                            </div>

                                        </div>
                                    </div>-->  

                                    <div class="am-form-group">
                                        <div class="am-u-sm-9 am-u-sm-push-3">
                                            <button type="button"  id="submi" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>

            </div>

    <script src="assets/js/amazeui.min.js"></script>
    <script src="assets/js/amazeui.datatables.min.js"></script>
    <script src="assets/js/dataTables.responsive.min.js"></script>
    <script src="assets/js/app.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="static/js/dtree.js"></script>
    
    <script>
		$(function(){
			dt = new dTree('dt',true);
			dt.check = true;  
			$.ajax({
				type: "POST",
				async: false,
				url: "/role?op=execTree",
				data: {
					id : $("#id").val()
				},
				success:function(d){
					dt.add(0,-1,"角色权限","#");
					for(var i=0;i<d.length;i++){
						var a = d[i];
						console.log(a);
						//id, pid, name, url, title, target, icon, iconOpen, open
						dt.add(a.nodeId,a.parentId,a.checkboxShow,"#",a.isCheck,a.chechboxVal	,a.chechboxName);
					}
					//$("#tree").html(dt);
					document.getElementById("tree").innerHTML=dt;
				}
			});
		});

	</script>
	<script type="text/javascript">
		$("#submi").click(function(){
			//alert("hah");
			var websocket = window.parent.websocket;	
			var name = $("#rname").val();
			websocket.send("修改一条名为："+name+" 的角色");
			$("#roleUpdate").submit();
			$("#submi").disabled=false;
		})
	</script>
	
</body>

</html>