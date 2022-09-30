<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>P.V.B | Chi tiết sản phẩm</title>
</head>

<body>
<form action=" <c:url value="/admin-category-edit"/>" method="post">
<div class="detail-product">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12 col-md-12 ">
                <div class="card">
                    <c:if test="${not empty message}">
                        <div class="alert alert-${alert}" role="alert">
                                ${message}
                        </div>
                    </c:if>
                    <div class="card-header">
                        <h4 class="title-form">
                            <h3 class="title-product">Điền các thông tin cần sửa<span class="span-title-product">*</span></h3>
                        </h4>
                    </div>
                    <div class="card-body">
                        <div class="row row-margin-top">
                            <div class="col-lg-2 col-md-2 col-2">
                                <p>Mã sản phẩm:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <form>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="id" value="${category.getId()}" placeholder="${category.getId()}" readonly>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-2 col-md-2 col-2">
                                <p>Tên danh mục:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <form>
                                    <div class="form-group">
                                        <input type="text" class="form-control" id="3" name="pvb" value="${category.getName()}" placeholder="${category.getName()}">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-12" style="text-align: center;">
                                <button type="submit" class="btn btn-outline-primary" style="padding-left: 1.2rem; padding-right: 1.2rem; margin-right: 40px;">Lưu</button>
                                <a href="<c:url value="/admin-category"/>"><button type="button" class="btn btn-outline-danger">Thoát</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
</body>

</html>