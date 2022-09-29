<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file="../../include/header.jspf" %>
<%@ include file="../../include/myPageHeader.jsp" %>

<style>
    .margin-space {
        margin-top: 40px;
        margin-left: 15px;
        margin-bottom: 40px;
    }

    .text-center {
        text-align: center;
    }
</style>

<!-- Main content -->
<section class="content">

    <!-- Default box -->
    <div class="container">
        <div class="row">
            <table class="table table-bordered margin-space" style="text-align: center; border: 1px solid #dddddd">
                <thead>
                <tr>
                    <th width="60" class="text-center">번호</th>
                    <th width="190" class="text-center">시공분야</th>
                    <th class="text-center">제목</th>
                    <th width="250" class="text-center">지역</th>
                    <th width="210" class="text-center">등록일</th>
                </tr>
                </thead>
                <tbody>

                <c:choose>

                    <c:when test="${login.rank == 1}">
                        <c:forEach items="${generalList}" var="item">
                            <tr>
                                <td>${item.boardNo}</td>
                                <td>${item.part}</td>
                                <td>
                                    <a href='/board/readPage${pageMaker.makeQuery(pageMaker.cri.page)}&boardNo=${item.boardNo}'>${item.title}
                                </td>
                                <td>${item.address}</td>
                                <fmt:parseDate var='regDate' pattern="yyyy-MM-dd HH:mm"
                                               value="${item.regDate}" scope="page"/>
                                <td><fmt:formatDate pattern="yyyy년 MM월 dd일 HH:mm"
                                                    value="${regDate}"/></td>
                            </tr>
                        </c:forEach>
                    </c:when>

                    <c:otherwise>
                        <c:forEach items="${businessList}" var="item">
                            <tr>
                                <td>${item.cbno}</td>
                                <td>${item.cnstType}</td>
                                <td>
                                    <a href="/cboard/read?cbno=${item.cbno}">${item.ctitle}
                                </td>
                                <td>${item.address}</td>
                                <td><fmt:formatDate pattern="yyyy년 MM월 dd일 HH:mm"
                                                    value="${item.regDate}"/></td>
                            </tr>
                        </c:forEach>
                    </c:otherwise>

                </c:choose>

                </tbody>
            </table>
            <!-- /.box-body -->
        </div>
    </div>
</section>
<!-- /.content -->

<%@ include file="../../include/footer.jspf" %>