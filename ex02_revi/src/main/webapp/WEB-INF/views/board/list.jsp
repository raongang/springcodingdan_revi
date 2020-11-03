<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>


<script type="text/javascript">
	$(document).ready(function() {
		var result = "${result}";
		console.log("result : " + result);
		
		checkModal(result);
		
		//modal checking
		function checkModal(result) {
			if (result === '') {
				return;
			}
			if (parseInt(result) > 0) {
				$(".modal-body").html("게시글 " + parseInt(result) + " 번이 등록되었습니다.");
			}
			$("#myModal").modal("show");
		}
		
		//register button event
		$("#regBtn").on("click", function(){
			window.location.href = "/board/register";
		});
		
	});
</script>

<div class="row">
	<div class="col-lg-12">
		<h1 class="page-header">Board Tables</h1>
	</div>
	<!-- /.col-lg-12 -->
</div>

<!-- /.row -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">BoardList Page
				<button id="regBtn" type="button" class="btn btn-xs pull-right">Register New Board</button>
			</div>
			<!-- /.panel-heading -->
			<div class="panel-body">
				<table width="100%"
					class="table table-striped table-bordered table-hover"
					id="dataTables-example">
					<thead>
						<tr>
							<th>#번호</th>
							<th>제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>수정일</th>
						</tr>
					</thead>
					
					<c:forEach items="${list}" var="board">
						<tr>
							<td>${board.bno}</td>
							<!-- 여기서 <c:out을 쓴 이유는 HTML에서는 ' 도 "로 인식을 하다보니 a href의 '와 bno데이터를 뽑는 부분에서의 "가 매칭이 되지 않았다.
								그리고, 작업을 진행하다가 알았는데 그냥 EL표현식보다 c:out을 쓰는게 더 좋은거 같음... 
								확실한 이유는 잘 모르겠음.
							 -->
							<td><a href='/board/get?bno=<c:out value="${board.bno}"/>'>${board.title }</a>
							<td>${board.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }" /></td>
							
						</tr>
					</c:forEach>
				</table>
				
				<!-- modal add -->
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">&times;</button>
								<h4 class="modal-title" id="myModalLabel">Modal title</h4>
							</div>
							<div class="modal-body">처리가 완료되었습니다.</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
								<button type="button" class="btn btn-primary">Save
									changes</button>
							</div>
						<!-- /.modal-content -->							
						</div>
					<!-- /.modal-dialog -->	
					</div>
				<!-- /.modal -->	
				</div>
				
			<!-- end panel-body -->
			</div>
			<!-- end panel -->
		</div>
		<!-- end col-lg-12 -->
	</div>
	<!-- end row -->
</div>

<%@include file="../includes/footer.jsp"%>

