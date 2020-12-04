<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@include file="../includes/header.jsp"%>

<script type="text/javascript">
	
	$(document).ready(function() {
	
		var result = '<c:out value="${result}"/>';
		console.log("result : " + result);
		
		checkModal(result);
		
		//현재 창의 열람이력을 수정한다.
		history.replaceState({}, null, null);
		console.log("history.state : " + history.state);
		
		//modal checking
		function checkModal(result) {
			if (result === '' || history.state) {
				console.log("check Point");
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
			//self.location="/board/register";
		});
		
		//페이징처리
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e){
			e.preventDefault();
			console.log("page click");
			
			//페이지 번호를 클릭하면 클릭한 페이지번호의 값을 넣어준다.
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();
			
		});
		
		//게시물 상세보기 이후 list로 갈때 처리. 해당 처리가 없으면 페이지가 현재 봤던 페이지가 아닌 고정페이지로 계속 나온다.
		$(".move").on("click",function(e){
						
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
				<table width="100%" class="table table-striped table-bordered table-hover" <%--id="dataTables-example" --%>>
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
							<!-- 새창은 target=_blank옵션으로 줄수 있다. 
							<td><a class='move' href='/board/get?bno=<c:out value="${board.bno}"/>'>${board.title }</a>
							-->
							<td><a class='move' href='<c:out value="${board.bno}"/>'> <c:out value="${board.title}" /></a></td>
							<td>${board.writer}</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.regdate }" /></td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate }" /></td>
							
						</tr>
					</c:forEach>
				</table>
				
				<!-- paging handler  -->
				<div class='pull-right'>
					<ul class="pagination">
					
						<c:if test="${pageMaker.prev }">
							<li class="paginate_button previous"><a href="${pageMaker.startPage-1}">Previous</a></li>
						</c:if>
						
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? 'active' : ''}">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a href="${pageMaker.endPage+1 } }">Next</a></li>
						</c:if>
						
					</ul>
				</div>
				
				<form id="actionForm" action="/board/list" method="get">
					<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum }" > 
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }" >
				</form>
				
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

