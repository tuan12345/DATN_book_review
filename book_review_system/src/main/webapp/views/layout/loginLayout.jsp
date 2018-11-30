<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles-extras"
	prefix="tilesx"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<spring:url value="/assets/css/bootstrap.min.css" var="bootstrapCss" />		
		<spring:url value="/assets/js/bootstrap.min.js" var="bootstrapJs" />
		<spring:url value="assets/js/vendor/jquery-1.12.0.min.js" var="jquery" />
		<spring:url value="/assets/js/jquery.scrollTo.min.js" var="jqueryScroll" />
		<spring:url value="/assets/js/jquery.nicescroll.js" var="niceScroll" />
		<spring:url value="/assets/js/scripts.js" var="script" />
		
		<spring:url value="/assets/css/bootstrap-theme.css" var="bootstrapTheme" />
		<spring:url value="/assets/css/elegant-icons-style.css" var="elegant" />
		<spring:url value="/assets/css/font-awesome.min.css" var="fontAwesome" />
		<spring:url value="/assets/css/style.css" var="style" />
		<spring:url value="/assets/css/style-responsive.css" var="styleReponsive" />
		<spring:url value="/assets/css/jquery-ui-1.10.4.min.css" var="jqueyrUI" />
		<spring:url value="/assets/js/scripts.js" var="script" />
		
		<link rel="stylesheet" href="${bootstrapCss}" />
		<link rel="stylesheet" href="${bootstrapTheme}" />
		<link rel="stylesheet" href="${elegant}" />
		<link rel="stylesheet" href="${fontAwesome}" />
		<link rel="stylesheet" href="${style}" />
		<link rel="stylesheet" href="${styleReponsive}" />
		<link rel="stylesheet" href="${jqueyrUI}" />
		<script src="${jquery}" type="text/javascript"></script>
		<script src="${bootstrapJs}" type="text/javascript"></script>
		
		<title><tiles:insertAttribute name="title" ignore="true" /></title>
	</head>
	<body>
		<tiles:insertAttribute name="login" />
		<script src="${jqueryScroll}" type="text/javascript"></script>
		<script src="${niceScroll}" type="text/javascript"></script>
		<script src="${script}" type="text/javascript"></script>

  		<!--custome script for all page-->
  		<script src="${script}"></script>
	</body>
</html>
