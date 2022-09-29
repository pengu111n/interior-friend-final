<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include/header.jspf" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/infoBoard.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/FAQ.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/assets/css/QNAForm.css">
<div class="page-head"> 
            <div class="container">
                <div class="row">
                    <div class="page-head-content">
                        <h1 class="page-title">1:1문의</h1>  
                </div>
            </div>
        </div>
        </div>
        <!-- End page header -->
	<section>		
		<div class="container">
			<div class="qnaform">
				<form role="form" method="post">
							<!-- 카테고리 -->
					<div class="outside qnaform__category">
						<div>				
						<span class="left">				
								분류		
						</span>
							<input type="hidden" id="nickName" name="nickName" value="${login.nickName}">
						<span class="right">
							<select id="category" name="category">
								<option value="전체">전체</option>
								<option value="주문/결제">주문/결제</option>
								<option value="배송관련">배송관련</option>
								<option value="취소/환불">취소/환불</option>
								<option value="반품/교환">반품/교환</option>
								<option value="로그인/회원정보">로그인/회원정보</option>
								<option value="서비스/기타">서비스/기타</option>
							</select>
						</span>
						</div>
					</div>

					<div class="outside qnaform__title">					
						<span class="left">제목</span>
						<span class="right"><input name="qnaTitle"></span>					
					</div>
					<div class="outside qnaform__content outside">				
						<span class="left">내용</span>
						<span class="right"><textarea name="qnaContent"></textarea></span>					
					</div>
					<div class="outside qnaform__submit">
						<button class="navbar-btn nav-button wow fadeInRight" data-wow-delay="0.48s" type="submit">
						제출
						</button>
					</div>			
				</form>
			</div>
		</div>
</section>		


    <!-- board search area -->
    




<%@ include file="../include/footer.jspf" %>
        