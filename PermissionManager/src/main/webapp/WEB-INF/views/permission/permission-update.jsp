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

</head>

<body data-type="widgets">
    <script src="assets/js/theme.js"></script>

            <div class="container-fluid am-cf">
                <div class="row">
                    <div class="am-u-sm-12 am-u-md-12 am-u-lg-9">
                        <div class="page-header-heading"><span class="am-icon-home page-header-heading-icon"></span> 权限 <small>permission</small></div>
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
                                <div class="widget-title am-fl">权限修改</div>
                                <div class="widget-function am-fr">
                                    <a href="javascript:;" class="am-icon-cog"></a>
                                </div>
                            </div>
                            <div class="widget-body am-fr">

                                <form class="am-form tpl-form-line-form" id="perUpdate" action="/permission?op=execUpdate" method="post">
                               	    <input type="hidden" name="id" value="${per.id}">
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">权限名称 <span class="tpl-form-line-small-title">名称</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="pname" name="pname" placeholder="请输入权限名称" value="${per.pname}">
                                            <small>请填写权限名称。</small>
                                        </div>
                                    </div>
                                    
                                    <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">权限代码 <span class="tpl-form-line-small-title">代码</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="pcode" name="pcode" placeholder="请输入权限代码" value="${per.pcode}" readonly="readonly">
                                            <small>请填写权限代码,使用大写字母,每个单词下划线隔开。</small>
                                        </div>
                                    </div>
                                    
                                     <div class="am-form-group">
                                        <label for="user-name" class="am-u-sm-3 am-form-label">权限路径 <span class="tpl-form-line-small-title">路径</span></label>
                                        <div class="am-u-sm-9">
                                            <input type="text" class="tpl-form-input" id="url" name="url" placeholder="请输入权限路径" value="${per.url}">
                                            <small>请填写权限路径。</small>
                                        </div>
                                    </div>
                                    
                                    <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">是否菜单 <span class="tpl-form-line-small-title">菜单</span></label>
                                        <div class="am-u-sm-9">
                                            <div class="tpl-switch">
                                     
                                                <input type="checkbox" name="isMenu" value="1" class="ios-switch bigswitch tpl-switch-btn isMenu"/>
                                
                                                <div class="tpl-switch-btn-view">
                                                    <div>
                                                    </div>
                                                </div>
                                            </div>

                                        </div>
                                    </div>
                                    <input type="hidden" name="isMenu" id="isMenu" value="${per.isMenu}">
                                    <input type="hidden" name="parentMenu"  value="${per.parentId}">
                                     <div class="am-form-group">
                                        <label for="user-phone" class="am-u-sm-3 am-form-label">父级菜单 <span class="tpl-form-line-small-title">父级</span></label>
                                        <div class="am-u-sm-9">
                                            <select name="parentId" data-am-selected="{searchBox: 1}" style="display: none;">
                                              <option value="0"></option>
                                              <c:forEach items="${aps}" var="p">
											  	<option value="${p.id}" <c:if test="${per.parentId==p.id}">selected</c:if>>${p.pname}</option>
											  </c:forEach>
											</select>

                                        </div>
                                    </div>
                                    
                                     <div class="am-form-group">
                                        <label for="user-intro" class="am-u-sm-3 am-form-label">权限描述 <span class="tpl-form-line-small-title">描述</span></label>
                                        <div class="am-u-sm-9">
                                            <textarea class="" rows="10" name="description" id="description" placeholder="请输入权限描述" >${per.description}</textarea>
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
                                            <button type="button" id="submi" class="am-btn am-btn-primary tpl-btn-bg-color-success ">提交</button>
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
	<script>
		$(function(){
			var isMenu = $("#isMenu").val();
			if(isMenu==1){
				$(".isMenu").attr("checked","checked");
			}
			$("#isMenu").val(0);
		})
	</script>
	
	 <script>
    	$("#submi").click(function(){
    		//alert("hah");
    		var websocket = window.parent.websocket;	
    		var name = $("#pname").val();
    		websocket.send("修改一条名为："+name+" 的权限");
    		$("perUpdate").submit();
			$("#submi").disabled=false;
    	})
    </script>
</body>

</html>