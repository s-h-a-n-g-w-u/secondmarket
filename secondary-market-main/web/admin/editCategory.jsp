<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../include/admin/adminHeader.jsp" %>
<%@include file="../include/admin/adminNavigator.jsp" %>

<title>编辑分类</title>
<script>
    $(function () {
        $("#editForm").submit(function () {
            if (!checkEmpty("name", "分类名称"))
                return false;
            return true;
        });
    });
</script>

<div class="container">
    <br>
    <ol class="breadcrumb">
        <li><a href="admin-category-list">所有分类</a></li>
        <li class="active">编辑分类</li>
    </ol>
    <div class="panel panel-warning editDiv">
        <div class="panel-heading">编辑分类</div>
        <div class="panel-body">
            <form method="post" id="editForm" action="admin-category-update">
                <table class="editTable">
                    <tr>
                        <td>分类名称</td>
                        <td><input id="name" name="name" value="${category.name}" type="text" class="form-control"></td>
                    </tr>
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <input type="hidden" name="id" value="${category.id}">
                            <input type="hidden" name="page.start" value="${page.start}">
                            <button type="submit" class="btn btn-success">修 改</button>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
