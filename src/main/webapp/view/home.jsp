<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26 / 04 / 2023
  Time: 10:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title> <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
                               integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
</head>
<body>
<header class="container"> <h3 style="text-align: center;margin-top:15px;">Quản Lý Khách Hàng</h3>
</header>
<main class="container">

    <section>
        <div class="col-10 offset-1 mt-5 table-responsive">
            <div class="row">
                <div class="col-6">
                    <a href="#" class="btn btn-success">Thêm mới</a>
                </div>
            </div>
            <c:if test="${ f:length(danhSachKH) == 0 }">
                <h3 class="alert alert-warning">Không có dữ liệu</h3>
            </c:if>

            <c:if test="${ f:length(danhSachKH) != 0 }">
                <table class="table table-striped mt-3">
                    <thead class="table-primary">
                    <tr>
                        <th>Mã</th>
                        <th>Họ</th>
                        <th>Đệm</th>
                        <th>Tên</th>
                        <th>Ngày sinh</th>
                        <th>SDT</th>
                        <th>Địa chỉ</th>
                        <th>Thành phố</th>
                        <th>Quốc gia</th>
                        <th colspan="2">Thao tác</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${ danhSachKH }" var="kh">
                        <tr>
                            <td>${ kh.ma }</td>
                            <td>${ kh.ho }</td>
                            <td>${ kh.tenDem }</td>
                            <td>${ kh.ten }</td>
                            <td>${ kh.ngaySinh }</td>
                            <td>${ kh.sdt }</td>
                            <td>${ kh.diaChi }</td>
                            <td>${ kh.thanhPho }</td>
                            <td>${ kh.quocGia }</td>
                            <td>
                                <a class="btn btn-primary"
                                   href="/khach-hang/edit?ma=${ kh.ma }">
                                    Cập nhật
                                </a>
                            </td>
                            <td>
                                <a class="btn btn-danger"
                                   href="/khach-hang/delete?ma=${ kh.ma }">
                                    Xóa
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </c:if>

        </div>
    </section>
</main>
<footer><p style="text-align: center;">HangNT169</p></footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
        integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
        integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
        crossorigin="anonymous"></script>
</body>
</html>
