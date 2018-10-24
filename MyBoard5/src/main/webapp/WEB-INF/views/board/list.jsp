<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp"%>

<script>
	//모든 body의 내용이 로드가 되고 나서(DOM 구조 완성 후) 스크립트를 실행
	$(document).ready(function(){
		var result = '<c:out value="${result}"/>';
		
		checkModal(result);
		
		history.replaceState({}, null, null);
		
		$("#regBtn").on('click', function(){
			self.location = '/board/register';
		});
		
		//페이지 버튼(a)을 눌렀을 때 /board/list로 page, amount를 같이 보낼 수 있도록 처리
		// 즉 원래 a 태그가 해야 할 일을 하지 못하게 하고, actionForm을 submit 시킨다.
		var actionForm = $("#actionForm");
		
		// 페이지 버튼(a 태그)를 클릭 했을 때
		$(".paginate_button a").on("click", function(e){
			//원래 a태그가 클릭 되었을 때 해야 할 동작을 취소시킨다.
			e.preventDefault();
			//actionForm의 pageNum이 들어있는 태그의 value 값을 클릭된 a태그의 href으로 설정함
			// => 클릭한 페이지의 href값을 페이지 번호(pageNum)로 사용
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
			
		});
		
		$(".move").on("click", function(e){
			e.preventDefault();
			actionForm.append("<input type='hidden' name='bno' value='" +$(this).attr("href") + "'>");
			
			//기본적으로 action
			actionForm.attr("action","/board/get");
			actionForm.submit();
		});
		
		
		//checkModal : 결과물에 따라서 모달을 띄울것인지 안띄울것인지 결정
		function checkModal(result){
			
			//result 키값을 가진 attribute, parameter 등이 없으면 모달 안띄움
			if( result === '' || history.state ){
				return;
			}
			
			//result를 정수로 바꿨을 때 0보다 크다면
			if (parseInt(result) > 0){
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록 되었습니다.");
			}
			
			$("#myModal").modal("show");
			
		}
		
	});
	
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
			<div class="panel-heading">Board List Page 총${pageMaker.total} 개의 게시물이 존재합니다.
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
								<td><a class='move' href="<c:out value='${board.bno }'/>"><c:out value="${board.title}" /></a></td>
								<td><c:out value="${board.writer}" /></td>
								<td><fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd"/></td>
								<td><fmt:formatDate value="${board.updateDate}" pattern="yyyy-MM-dd"/></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div class="pull-right">
					<ul class='pagination'>
					
					<c:if test="${ pageMaker.prev }">
						<li class="paginate_button previous">
							<a href="${ pageMaker.startPage-1 }">Previous</a>
						</li>
					</c:if>
					
					<c:forEach var="num"
							   begin="${pageMaker.startPage}"
							   end="${pageMaker.endPage}">
						<li class="paginate_button ${ pageMaker.cri.pageNum == num ? "active" : ""}"><a href="${ num }">${num}</a></li>
					</c:forEach>
					
					<c:if test="${ pageMaker.next }">
						<li class="paginate_button next">
							<a href="${ pageMaker.endPage+1 }">Next</a>
						</li>
					</c:if>
					</ul>
					
					<form id="actionForm" action="/board/list" method="get">
						
						<input type="hidden" name="pageNum" value="${ pageMaker.cri.pageNum }">
						<input type="hidden" name="amount" value="${ pageMaker.cri.amount }">
						
					</form>
					
				</div>
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