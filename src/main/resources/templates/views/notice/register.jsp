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
                        <h1 class="page-title">공지사항</h1>  
                </div>
            </div>
        </div>
        </div>
        <!-- End page header -->
	<section>		
		<div class="container">
			<div class="qnaform">

				<!-- 액션 뭐라고 해야될까? 완성못하면 집가서

				컨트롤러에 /register는 게시글 작성 페이지를 의미하는게 아니라 페이지 작성 그 자체 동작인듯 ?
				action에 /notice/register을 넣고

				지금 이 작성 폼 jsp를 다른 이름으로 변경하면 작동하지 않을까 ?


				-->
				<form role="form" method="post">
					
					<div class="qnaform__title outside">					
						<span class="left">제목</span>
						<span class="right"><input name="noticeTitle"></span>
					</div>
					<div class="qnaform__content outside">				
						<span class="left">내용</span>
						<span class="right"><textarea name="noticeContent"></textarea></span>
					</div>
					<div class="qnaform__submit">
						<button class="navbar-btn nav-button wow fadeInRight" data-wow-delay="0.48s" type="submit">
						업로드
						</button>
					</div>			
				</form>
			</div>
		</div>
</section>		


    <!-- board search area -->
    




<%@ include file="../include/footer.jspf" %>
        