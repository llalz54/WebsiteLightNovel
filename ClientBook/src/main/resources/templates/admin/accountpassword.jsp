<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>P.V.B | Sửa mật khẩu</title>
  
</head>

<body>
<form action=" <c:url value="/admin-account-password"/>" method="post">
<div class="info-product">
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
                            <h3 class="title-product">Điền các thông tin cần cập nhật<span class="span-title-product">*</span></h3>
                        </h4>
                    </div>
                    <div class="card-body">
                        <div class="row row-margin-top">
                            <div class="col-lg-2 col-md-2 col-6">
                                <p>Tên tài khoản:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <form>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="username" value="${user.getUsername()}" placeholder="${user.getUsername()}" readonly>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Mã tài khoản:</p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <form>
                                    <div class="form-group">
                                        <input type="number" class="form-control" name="id" value="${user.getId()}" placeholder="${user.getId()}" readonly>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Mật khẩu:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="password" class="form-control" name="password" placeholder="Mật khẩu cũ ..." required="required">
                            </div>
                        </div>
                        
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Mật khẩu mới:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="password" class="form-control" id="password" name="newpassword"  placeholder="Mật khẩu mới ..." required="required">
                            </div>
                        </div>
                        
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Nhập lại mật khẩu:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="password" class="form-control" id="password2" name="repassword" placeholder="Mật khẩu mới ..." required="required">
                            </div>
                        </div>

                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-12" style="text-align: center;">
                                <button type="submit" class="btn btn-outline-primary" style="padding-left: 1.2rem; padding-right: 1.2rem; margin-right: 40px;">Lưu</button>
                                <a href="<c:url value="/admin-account"/>"><button type="button" class="btn btn-outline-danger">Thoát</button></a>
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