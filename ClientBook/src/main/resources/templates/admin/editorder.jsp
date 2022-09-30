<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>P.V.B | Thông tin giao dịch</title>
</head>

<body>
	<form action=" <c:url value="/admin-order-edit"/>" method="post">
		<div class="detail-product">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12 col-md-12 ">
						<div class="card">
							<c:if test="${not empty message}">
								<div class="alert alert-${alert}" role="alert">${message}
								</div>
							</c:if>
							<input name=id hidden=”hidden” value="${transaction.getId()}">
							<input name=user-id hidden=”hidden” value="${transaction.getUser_id()}">
							<div class="card-header">
								<h4 class="title-form">
									<h3 class="title-product">
										Điền các thông tin cần cập nhật<span
											class="span-title-product">*</span>
									</h3>
								</h4>
							</div>
							<div class="card-body">
								<div class="row row-margin-top">
									<div class="col-lg-2 col-md-2 col-6">
										<p>Tên chủ giao dịch:</p>
									</div>
									<div class="col-lg-4 col-md-4 col-4">
										<form>
											<div class="form-group">
												<input type="text" class="form-control" name="user_name"
													value="${transaction.getUser_name()}"
													placeholder="${transaction.getUser_name()}" readonly>
											</div>
										</form>
									</div>
									<div class="col-lg-2 col-md-6 col-6">
										<p>Mã giao dịch:</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<form>
											<div class="form-group">
												<input type="text" class="form-control" name="id"
													value="${transaction.getId()}"
													placeholder="${transaction.getId()}" readonly>
											</div>
										</form>
									</div>
								</div>
								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-6 col-6">
										<p>Ngày đặt hàng:</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="date" class="form-control" name="shipping_date"
											value="${transaction.getShipping_date()}"
											placeholder="${transaction.getShipping_date()}" readonly>
									</div>

									<div class="col-lg-2 col-md-6 col-6">
										<p>
											Ngày nhận hàng: <u></u> <span class="span-title-product">*</span>
										</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="date" class="form-control" name="delivery_date"
											value="${transaction.getDelivery_date()}"
											placeholder="${transaction.getDelivery_date()}">
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-4 col-6">
										<p>Email:</p>
									</div>
									<div class="col-lg-10 col-md-8 col-6">
										<input type="email" class="form-control"
											id="exampleFormControlTextarea1" name="user_email"
											value="${transaction.getUser_email()}"
											placeholder="${transaction.getUser_email()}" readonly>
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-4 col-6">
										<p>Địa chỉ:</p>
									</div>
									<div class="col-lg-10 col-md-8 col-6">
										<input type="text" class="form-control"
											id="exampleFormControlTextarea1" name="user_address"
											value="${transaction.getUser_address()}"
											placeholder="${transaction.getUser_address()}" readonly>
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-6 col-6">
										<p>Số điện thoại:</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="text" class="form-control" name="user_phone"
											value="${transaction.getUser_phone()}"
											placeholder="${transaction.getUser_phone()}" readonly>
									</div>

									<div class="col-lg-2 col-md-6 col-6">
										<p>Lời nhắn:</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="text" class="form-control" name="message"
											value="${transaction.getMessage()}"
											placeholder="${transaction.getMessage()}" readonly>
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-6 col-6">
										<p>Tổng tiền:</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="text" class="form-control" name="amount"
											value="${transaction.getAmount()}"
											placeholder="${transaction.getAmount()}" readonly>
									</div>

									<div class="col-lg-2 col-md-6 col-6">
										<p>
											Hình thức giao dịch:<u></u> <span class="span-title-product">*</span>
										</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<input type="text" class="form-control" name="payment"
											value="${transaction.getPayment()}"
											placeholder="${transaction.getPayment()}" readonly>
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-lg-2 col-md-6 col-6">
										<p>
											Trạn thái đơn hàng:<u></u> <span class="span-title-product">*</span>
										</p>
									</div>
									<div class="col-lg-4 col-md-6 col-6">
										<select class="form-control" name="status" aria-placeholder="${transaction.getStatus()}">
											<option value="0">Chờ xác nhận</option>
											<option value="1">Chờ lấy hàng</option>
											<option value="2">Đang đi giao</option>
											<option value="3">Đã giao</option>
										</select>
									</div>
								</div>

								<div class="gap-sm"></div>
								<div class="row">
									<div class="col-12" style="text-align: center;">
										<button type="submit" class="btn btn-outline-primary"
											style="padding-left: 1.2rem; padding-right: 1.2rem; margin-right: 40px;">Lưu</button>
										<a href="<c:url value="/admin-order"/>"><button
												type="button" class="btn btn-outline-danger">Thoát</button></a>
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