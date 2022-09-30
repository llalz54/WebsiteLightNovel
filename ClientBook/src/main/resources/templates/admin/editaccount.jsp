<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>P.V.B | Thông tin tài khoản</title>
  
</head>

<body>
<form action=" <c:url value="/admin-account-edit"/>" method="post">
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
                                        <input type="text" class="form-control" name="id" value="${user.getId()}" placeholder="${user.getId()}" readonly>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Họ và tên:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="text" class="form-control" name="name" value="${user.getName()}"  placeholder="${user.getName()}">
                            </div>
                            
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Số điện thoại:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="text" class="form-control" name="phone" value="${user.getPhone()}"  placeholder="${user.getPhone()}">
                            </div>
                        </div>

                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-4 col-6">
                                <p>Email: <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-10 col-md-8 col-6">
                                <input type="email" class="form-control" id="exampleFormControlTextarea1" name="email" value="${user.getEmail()}" placeholder="${user.getEmail()}" readonly>
                            </div>
                        </div>
                        
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-4 col-6">
                                <p>Địa chỉ: <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-10 col-md-8 col-6">
                                <input type="text" class="form-control" id="exampleFormControlTextarea1" name="address" value="${user.getAddress()}" placeholder="${user.getAddress()}">
                            </div>
                        </div>
                        
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Loại tài khoản:<u></u> <span class="span-title-product">*</span></p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                            	<c:choose>
                            	<c:when test="${user.isRole() == 1}">
									<select class="form-control" aria-placeholder="${user.isRole()}" name="role">
											<option value="1">Bình Thường</option>
											<option value="0">Khóa Tài Khoản</option>
									</select>
								</c:when>
								<c:when test="${user.isRole() == 2}">
									<select class="form-control" aria-placeholder="${user.isRole()}" name="role">
											<option value="2">Nhân Viên</option>
											<option value="3">Quản Lý</option>
									</select>
								</c:when>
								<c:when test="${user.isRole() == 0}">
									<select class="form-control" aria-placeholder="${user.isRole()}" name="role">
											<option value="0">Khóa Tài Khoản</option>
											<option value="1">Bình Thường</option>
									</select>
								</c:when>
								</c:choose>
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