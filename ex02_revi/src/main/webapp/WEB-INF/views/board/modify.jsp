<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	
	$(document).ready(function() {
		
		var formObj = $("form");
		
		$("button").on("click",function(event){
			
			//console.log("Target : " + event.target); -> [object HTMLButtonElement]
			
			//form 태그의 모든 버튼은 기본적으로 submit으로 처리하기 때문에 기본 동작을 막아야 한다. event는 발생한 이벤트에 대한 정보를 가지고 있다.
			event.preventDefault();
			
			var operation = $(this).data("oper");
			console.log("opertaion : " + operation);
			
			if(operation==='remove'){
				formObj.attr("action", "/board/remove");
			}else if(operation==='list'){
				//move to list 
				//window.location.href="/board/list";
				//self.location="/board/list";
				
				//GET으로 호출할수 있게 속성을 변경한다. 
				formObj.attr("action", "/board/list").attr("method","get");
				formObj.empty();
			}
			
			formObj.submit();
		});
	});
</script>


<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Modify Page</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">Board Modify Page</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
			
				<form role="form" action="/board/modify" method="post">
					
					<div class="form-group">
						<label>Bno</label><input class="form-control" name="bno"  value="${board.bno}"  readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label>Title</label><input class="form-control" name="title" value="${board.title}" />
					</div>
					
					<div class="form-group">
						<label>Content</label><textarea class="form-control" rows="3" name="content" >${board.content}</textarea>
					</div>					

					<div class="form-group">
						<label>Writer</label> <input class="form-control" name="writer" value="${board.writer}" readonly="readonly" />
					</div>
					
					<div class="form-group">
						<label>RegDate</label>
						<input class="form-control" name="regDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.regdate}" />'	readonly="readonly">
					</div>
					
					<div class="form-group">
						<label>Update Date</label>
						<input class="form-control" name="updateDate" value='<fmt:formatDate pattern="yyyy/MM/dd" value="${board.updateDate}" />'	readonly="readonly">
					</div>					
					
					<!-- HTML5 기능
						data-*   : HTML ELEMENT에 데이터를 저장하는 용도.
						즉, data-oper는 "modify"라는 데이터를 저장한다.
					 -->					
					<button type="submit" data-oper="modify" class="btn btn-default">Modify</button>
					<button type="submit" data-oper="remove" class="btn btn-danger">Remove</button>
					<button type="submit" data-oper="list" class="btn btn-info">List</button>
					
				</form>						
			</div>
			<!-- end panel-body -->
		</div>
		<!-- end panel -->
	</div>
	<!-- end col-lg-12 -->
</div>
<!-- end row -->

<%@include file="../includes/footer.jsp"%>