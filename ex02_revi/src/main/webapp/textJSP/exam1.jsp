<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>


<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
     
    <script type="text/javascript">
    	// span엘리멘트에 data()함수로 "name"과 "address" 세팅방법
    	
    	$(document).ready(function() {
    		
        	//$("span").data("name","Nextree"); //동작안함(??????????????????)
        	//$("span").data("address", "Gasan");    	
        	
        	$("span").css("background-color","red"); //정상동작
        	
        	var jsonData = $("span").data();
        	console.log(jsonData);
        	console.log($("span").data("name"));
        	
        	var member = $("span").data("member");
        	console.log("member : " + member);
        	
    	});
    	
    </script>

</head>

<body>
	
	<!-- data()가 호출되면 span 엘리먼트에 "name"과 "address"가 추가된다.
	<span>jQuery의 data()의 저장 방법</span>
	 -->
	<div>
		<!-- data-*  : HTML5 기능 -->
		<span data-name="nextree" data-address="gasan" data-member='{"name" : "jisu"}'>.data()가 저장되는 방식.</span></div>
</body>
</html>