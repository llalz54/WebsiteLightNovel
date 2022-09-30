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
<form action=" <c:url value="/admin-product-edit"/>" method="post">
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
                                        <input type="text" class="form-control" name="id" value="${product.getId()}" placeholder="${product.getId()}" readonly>
                                    </div>
                                </form>
                            </div>
                            <div class="col-lg-2 col-md-2 col-2">
                                <p>Mã danh mục:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <form>
                                    <div class="form-group">
                                        <input type="text" class="form-control" name="catalog_id" value="${product.getCatalog_id()}" placeholder="${product.getCatalog_id()}">
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Tên sản phẩm:</p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <input type="text" class="form-control" name="name" value="${product.getName()}"  placeholder="${product.getName()}">
                            </div>
                            <div class="col-lg-2 col-md-6 col-6">
                                <p>Hình ảnh sản phẩm:</p>
                            </div>
                            <div class="col-lg-4 col-md-6 col-6">
                                <form>
                                    <div class="form-group input-group">
                                        <input type="file" name="image_link" onchange="readURL(this);" 
                                        	class="form-control-file" id="upload" hidden="">
                                        	<label id="upload-label" for="upload" class="font-weight-light text-muted">File name: ${linkAnh}</label>
                                        	<div class="image-area mt-4"><img id="imageResult" src="${product.getImage_link()}" alt="" class="img-fluid rounded shadow-sm mx-auto d-block " style="width: 100px;"></div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-lg-2 col-md-4 col-6">
                                <p>Thông tin sản phẩm:</p>
                            </div>
                            <div class="col-lg-10 col-md-8 col-6">
                                <input type="text" class="form-control" id="exampleFormControlTextarea1" name="content" value="${product.getContent()}"   placeholder="${product.getContent()}">
                            </div>
                        </div>
                        <div class="gap-sm"></div>
                        <div class="row">
                        	<div class="col-lg-2 col-md-2 col-2">
                                <p>Giá:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <input type="number" class="form-control" min="0" name="price" value="${product.getPrice()}"  placeholder="${product.getPrice()}">
                            </div>
                        
                            <div class="col-lg-2 col-md-2 col-6">
                                <p>Số lượng tồn:</p>
                            </div>
                            <div class="col-lg-4 col-md-4 col-4">
                                <input type="number" class="form-control" min="0" name="qty"  value="${product.getQty()}" placeholder="${product.getQty()}">
                            </div>
                        </div>

                        <div class="gap-sm"></div>
                        <div class="row">
                            <div class="col-12" style="text-align: center;">
                                <button type="submit" class="btn btn-outline-primary" style="padding-left: 1.2rem; padding-right: 1.2rem; margin-right: 40px;">Lưu</button>
                                <a href="<c:url value="/admin-product"/>"><button type="button" class="btn btn-outline-danger">Thoát</button></a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
<script type="text/javascript">
/*  ==========================================
SHOW UPLOADED IMAGE
* ========================================== */
function readURL(input) {
if (input.files && input.files[0]) {
    var reader = new FileReader();

    reader.onload = function (e) {
        $('#imageResult')
            .attr('src', e.target.result);
    };
    reader.readAsDataURL(input.files[0]);
}
}

$(function () {
$('#upload').on('change', function () {
    readURL(input);
});
});

/*  ==========================================
SHOW UPLOADED IMAGE NAME
* ========================================== */
var input = document.getElementById( 'upload' );
var infoArea = document.getElementById( 'upload-label' );

input.addEventListener( 'change', showFileName );
function showFileName( event ) {
var input = event.srcElement;
var fileName = input.files[0].name;
infoArea.textContent = 'File name: ' + fileName;
}
</script>
</body>
</html>