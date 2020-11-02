<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Read</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Read Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
					<div class="form-group">
						<label>Bno</label><input class="form-control" name="Bno"  value="${board.bno}"  readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label>Title</label><input class="form-control" name="title" value="${board.title}" readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label>Content</label><textarea class="form-control" rows="3" name="content" readonly="readonly">${board.content}</textarea>
	
					</div>					


					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}" readonly="readonly" />
					</div>
					
					<!-- HTML5 기능
						data-*   : HTML ELEMENT에 데이터를 저장하는 용도.
					 -->
					<button data-oper="modify" class="btn btn-default">Modify</button>
					<button data-oper="list" class="btn btn-info">List</button>
					
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- end col-lg-12 -->
</div>
<!-- end row -->

<%@include file="../includes/footer.jsp"%>