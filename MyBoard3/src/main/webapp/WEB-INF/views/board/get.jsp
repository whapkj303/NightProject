<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@include file="../includes/header.jsp"%>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read Page</h1>
	</div>
</div>

<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<div class="panel-body">
			
					<div class="form-group">
						<label>Bno</label>
						<input class="form-control" name="bno" value='<c:out value="${board.bno }"/>' readonly="readonly">
					</div>
			
					<div class="form-group">
						<label>Title</label>
						<input class="form-control" name="title" value='<c:out value="${board.title }"/>' readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Text area</label>
						<textarea rows="3" class="form-control" name="content" readonly="readonly"><c:out value="${board.content }"/></textarea>
					</div>
					
					<div class="form-group">
						<label>Writer</label>
						<input class="form-control" name="writer" value='<c:out value="${board.writer }"/>' readonly="readonly">
					</div>
					
						<a href="/board/modify?bno=<c:out value="${board.bno}"/>">
							<button data-oper="modify" class="btn btn-default">
									Modify
							</button>
						</a>
					
						<a href="/board/list">
							<button data-oper="list" class="btn btn-info">
							  List
							</button>
						</a>
					
					<form id="operForm" action="/board/modify" method="get">
						<input type="hidden" id='bno' name='bno' value='<c:out value="${board.bno }"/>'>
					</form>
			</div>
		</div>
	</div>
</div>

<%@include file="../includes/footer.jsp" %>