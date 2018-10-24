<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	
<body>
           <!-- 用户信息 -->
            <div class="tpl-sidebar-user-panel">
                <div class="tpl-user-panel-slide-toggleable">
                    <div class="tpl-user-panel-profile-picture">
                        <img src="assets/img/user04.png" alt="">
                    </div>
                    <span class="user-panel-logged-in-text">
              <i class="am-icon-circle-o am-text-success tpl-user-panel-status-icon"></i>
              禁言小张
          </span>
                    <a href="javascript:;" class="tpl-user-panel-action-link"> <span class="am-icon-pencil"></span> 账号设置</a>
                </div>
            </div>
           <!-- 菜单 -->
            <ul class="sidebar-nav">
                <!--  <li class="sidebar-nav-heading"><span class="sidebar-nav-heading-info"></span></li>-->
                <c:forEach var="per" items="${loginUser.pers}">
                <li class="sidebar-nav-link">
                    <a href="javascript:;" class="sidebar-nav-sub-title">
                        <i class="am-icon-table sidebar-nav-link-logo"></i> ${per.pname}
                        <span class="am-icon-chevron-down am-fr am-margin-right-sm sidebar-nav-sub-ico"></span>
                    </a>          
                    <ul class="sidebar-nav sidebar-nav-sub">
                        <c:forEach var="p" items="${per.childrenPer}">
	                        <li class="sidebar-nav-link">
	                            <a href="${p.url}">
	                                <span class="am-icon-angle-right sidebar-nav-link-logo"></span> ${p.pname}
	                            </a>
	                        </li>
                        </c:forEach>
                    </ul>
                </li>
                </c:forEach>
            </ul>
</body>
</html>