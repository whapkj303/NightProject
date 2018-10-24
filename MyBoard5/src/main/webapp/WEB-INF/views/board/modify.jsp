<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp"%>

<script>
	$(document).ready(function(){
		//1) form 객체 가져오기
		var formObj = $("form");
	
		$('button').on("click", function(e){
			e.preventDefault();
			
			var operation = $(this).data("oper");
			
			console.log(operation);
			
			if(operation === 'remove'){
				formObj.attr("action", "/board/remove");
			}else if(operation ==='list'){
				formObj.attr("action","/board/list").attr("method", "get");
				var pageNumTag = $("input[name='pageNum']").clone();
				var amountTag = $("input[name='amount']").clone(); // 원래 있는 객체를 clone이 복제 
				
				// form 안쪽의 모든 내용을 비우고
				formObj.empty();
				
				// 복제한 태그를 추가함. 뽑아내고 비운다음에 다시 추가. 소수의 개가 선택될 경우 많이 사용!
				formObj.append(pageNumTag);
				formObj.append(amountTag);
				
				
			}
			formObj.submit();
		});
		
	
	});
</script>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<div class="panel-body">
			
				<form action="/board/modify" role="form" method="post">
				
					<input type="hidden" name='pageNum' value='<c:out value="${cri.pageNum}"></c:out>'>
					<input type="hidden" name='amount' value='<c:out value="${cri.amount}"></c:out>'>
				
					<div class="form-group">
						<label>Bno</label>
						<input class="form-control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly" >
					</div>
			
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value='<c:out value="${board.title }"/>' >
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" name="content" ><c:out value="${board.content }"/></textarea>
					</div>
					
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer" value='<c:out value="${board.writer }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name="regdate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.regdate }" />' readonly="readonly" >
					</div>
					
					<div class="form-group">
						<label>UpdateDate</label>
						<input class="form-control" name="updateDate" value='<fmt:formatDate pattern = "yyyy/MM/dd" value="${board.updateDate }" />' readonly="readonly" >
					</div>
					
					<button type="submit" data-oper='modify' class="btn btn-default">Modify</button>
					<button type="submit" data-oper='remove' class="btn btn-danger">Remove</button>
					<button type="submit" data-oper='list' class="btn btn-info">List</button>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp" %>