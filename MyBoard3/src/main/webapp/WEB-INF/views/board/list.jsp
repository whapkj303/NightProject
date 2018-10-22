<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp"%>

<script>
	//부트스트랩은 제이쿼리 사용해야 한다.
	// 모든 body의 내용이 로드가 되고 나서 (DOM 구조 완성 후) 스크립트 실행
	
	$(document).ready(function(){
		var result = '<c:out value="${result}" />';
		
		// 변수 매개변수 차이;
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		$('#regBtn').on('click', function(){
			self.location = '/board/register';
		});
		
		//checkModal : 결과물에 따라서 모달을 띄울 것인지 안띄울것인지 결정
		function checkModal(result){
			
			//result 키값을 가진 attribute, parameter 등이 없으면 모달 안띄움
			if( result === ''  || histort.state	){		
				// 자바스크립트는 === 는 안의 값까지 확인
				return;
			}
			
			//result를 정수로 바꿨을 때 0 보다 크다면
			if( parseInt(result) > 0){
				$(".modal-body").html("게시글" + parseInt(result) + "번이 등록되었습니다.")
			}			
			
			$("#myModal").modal("show");
			
		}
	})
	
</script>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board List Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board List Page
			<button id='regBtn' type='button' class='btn btn-xs pull-right'>Register New Board</button>
			</div>
			<div class="panel-body">
				<table class="table table-striped table-bordered table-hover">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${list}" var="board">
							<tr>
								<td><c:out value="${board.bno}" /></td>
								<td><a class='move' href="/board/get?bno=<c:out value='${board.bno}'/>"><c:out value="${board.title}" /></a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				<!-- 게시글 등록 모달 처리 -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save changes</button>
							</div>
							
						</div>
					</div> 
				</div>
			</div>
		</div>
	</div>
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>