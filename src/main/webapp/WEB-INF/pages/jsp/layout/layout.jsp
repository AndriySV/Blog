<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		  		
    	<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
		<link href="<c:url value='/css/bootstrap-theme.min.css' />" rel="stylesheet">
		<link href="<c:url value='/css/login.css' />" rel="stylesheet">
		<link href="<c:url value='/css/datepicker.css' />" rel="stylesheet">
		<link href="<c:url value='/css/admin.css' />" rel="stylesheet">
		<link href="<c:url value='/css/layout.css' />" rel="stylesheet">
		<link href="<c:url value='/css/right_panel.css' />" rel="stylesheet">
		<link href="<c:url value='/css/index.css' />" rel="stylesheet">
	</head>
	
	<body bgcolor="#c0c0c0">
		
		<div class="container-fluid main-container">
			<tiles:insertAttribute name="header"/>
			<tiles:insertAttribute name="nav" />
			
			<div class="container-fluid body-container">
				 <div class="row">
					<div class="col-md-8">
						<tiles:insertAttribute name="body" />
					</div>
				
				 	<div class="col-md-3 col-md-offset-1">
						<!-- Delete if it doesn't need -->
						<tiles:insertAttribute name="right_panel" />
					</div>		
				</div>
			</div>
		</div>	
	
		<script src="<c:url value='/js/jquery.js' />" ></script>
		<script src="<c:url value='/js/bootstrap.min.js' />" ></script>
		<script src="<c:url value='/js/validator.js' />" ></script>
		<script src="<c:url value='/js/registration.js' />" ></script>
		<script src="<c:url value='/js/bootstrap-datepicker.js' />" ></script>
		<script src="<c:url value='/js/calendar.js' />" ></script>
		<script src="<c:url value='/js/bootstrap-filestyle.js' />" ></script>
		<script src="<c:url value='/js/admin_page/admin.js' />" ></script>
		<script src="<c:url value='/js/admin_page/createArticle.js' />" ></script>
		<script src="<c:url value='/js/admin_page/downloadImage.js' />" ></script>
		<script src="<c:url value='/js/admin_page/editArticle.js' />" ></script>
		<script src="<c:url value='/js/admin_page/deleteArticle.js' />" ></script>
		<script src="<c:url value='/js/index.js' />" ></script>
	</body>

</html>