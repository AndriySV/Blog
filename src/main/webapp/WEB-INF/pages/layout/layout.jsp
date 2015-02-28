<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html>
	<head>
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
		
		<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
    	<link href="<c:url value='/css/bootstrap.min.css' />" rel="stylesheet">

	</head>
	
	<body bgcolor="#c0c0c0">
		
		<div class="container-fluid" style="background: #B8E62E;">
			<tiles:insertAttribute name="header"/>
			<tiles:insertAttribute name="nav" />
			
			<!-- Remove style !!! -->
			<div class="container-fluid" style="background-color:  rgba(255, 255, 255, 0.6);
										  		border-radius:6px;
										  		height:80%;">
	
						<tiles:insertAttribute name="body" />
				
						<!-- Delete if it doesn't need -->
						<tiles:insertAttribute name="footer" />
			</div>
		</div>	
	
		<script src="<c:url value='/js/jquery.js' />" ></script>
		<script src="<c:url value='/js/bootstrap.min.js' />" ></script>
		<script src="<c:url value='/js/bootstrap.js' />" ></script>
	
	</body>

</html>