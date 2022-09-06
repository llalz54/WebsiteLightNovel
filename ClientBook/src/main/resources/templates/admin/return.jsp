<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>P.V.B | Trả hàng & Hoàn tiền</title>
</head>

<body>
<form action="<c:url value="/admin-return"/> " method="post">
<div class="info-product">
    <div class="container-fluid">
        <div class="row ">
            <div class="col-lg-12 col-md-12 ">
                <div class="card">
                    <div class="card-body">
                        <div class="row row-margin-top">
                            <div class="container-fluid">
                                <div class="tab-pane fade show active" id="all" role="tabpanel" aria-labelledby="all-tab">
                                    <!-- tất cả đơn hàng -->
                                    <div class="container-fluid">
                                        <div class="gap-sm"></div>
                                        <div class="row">
                                            <div class="col-lg-3 col-md-3 col-sm-5 col-5">
                                                <div class="input-group mb-3">
                                                    <input type="text" class="form-control" placeholder="Tìm mã đơn hàng..." aria-label="Recipient's username" aria-describedby="basic-addon2">
                                                    <div class="input-group-append">
                                                                    <span class="input-group-text" id="basic-addon2"><i
                                                                            class="fa fa-search"
                                                                            aria-hidden="true"></i></span>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="col-lg-1 col-md-1 "></div>
                                            <div class="col-lg-7 col-md-7 col-sm-12 col-12">
                                                <div class="container-fluid">
                                                    <div class="row">
                                                        <div class="col-lg-2 col-md-2">
                                                            <p style="margin-top: 10px;">Ngày đặt hàng
                                                            </p>
                                                        </div>
                                                        <div class="col-lg-3 col-md-3col-sm-6 col-6">
                                                            <div class="form-group row">
                                                                <div class="col-12">
                                                                    <input class="form-control"
                                                                           type="datetime-local"
                                                                           value="2011-08-19T13:45:00"
                                                                            >
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-1 col-md-1">
                                                            <i class="fa fa-arrow-right" aria-hidden="true"
                                                               style="margin-left: 20px;margin-top: 15px;"></i>
                                                        </div>
                                                        <div class="col-lg-3 col-md-3 col-sm-6 col-6">
                                                            <div class="form-group row">
                                                                <div class="col-12">
                                                                    <input class="form-control"
                                                                           type="datetime-local"
                                                                           value="2011-08-19T13:45:00"
                                                                            >
                                                                </div>
                                                            </div>
                                                        </div>
                                                        <div class="col-lg-3 col-md-3">
                                                            <button class="btn btn-primary"><i
                                                                    class="fa fa-print" aria-hidden="true"
                                                                    style="color: white !important;"></i>
                                                                In hóa đơn</button>
                                                        </div>

                                                    </div>
                                                </div>


                                            </div>
                                            <div class="col-lg-1 col-md-1 "></div>
                                        </div>
                                        <div class="gap-xs"></div>
                                        <div class="row">
                                            <h3 style="color: black;">Đơn hủy</h3>
                                        </div>
                                        <div class="gap-xs"></div>
                                        <div class="row">
                                            <div class="col-12">
                                                <section class="section">
                                                    <div class="card">
                                                        <!-- all product-tab -->
                                                        <div class="card-body">
                                                            <table class='table table-striped' id="table1">
                                                                <thead>
                                                                <tr>
                                                                    <th>Mã đơn hàng</th>
                                                                    <th>ID Khách hàng</th>
                                                                    <th>Số tài khoản </th>
                                                                    <th>Ngân hàng </th>
                                                                    <th>Số tiền hoàn</th>

                                                                    <th>Trạng thái</th>

                                                                </tr>
                                                                </thead>
                                                                <tbody>

                                                                <tr>
                                                                    <td><a
                                                                            href="chitietdonhang.html">DH02</a>
                                                                    </td>
                                                                    
                                                                    <td>THAONHA01
                                                                    </td>
                                                                    <td>90888888888</td>

                                                                    <td>Vietcombank</td>
                                                                    <td>10.000.000</td>

                                                                    <td>
                                                                                        <span
                                                                                                class="badge bg-success">Đã nhận hàng & hoàn tiền</span>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td><a href="chitietdonhang.html">DH02</a>
                                                                    </td>
                                                                    
                                                                    <td>THAONHA01
                                                                    </td>
                                                                    <td>90888888888</td>

                                                                    <td>Vietcombank</td>
                                                                    <td>10.000.000</td>

                                                                    <td>
                                                                        <span class="badge bg-danger">Đã nhận hàng    </span>
                                                                    </td>
                                                                </tr>
                                                                <tr>
                                                                    <td><a href="chitietdonhang.html">DH02</a>
                                                                    </td>
                                                                   
                                                                    <td>THAONHA01
                                                                    </td>
                                                                    <td>90888888888</td>

                                                                    <td>Vietcombank</td>
                                                                    <td>10.000.000</td>

                                                                    <td>
                                                                        <span class="badge bg-success">Đã hoàn tiền</span>
                                                                    </td>
                                                                </tr>

                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>

                                                </section>
                                            </div>
                                        </div>
                                    </div>



                                </div>




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