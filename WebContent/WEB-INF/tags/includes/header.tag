<%@ taglib tagdir="/WEB-INF/tags/includes" prefix="includes"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>${title} - WebGuideExam</title>
<link href="/${appName}/static/css/main.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Ubuntu" rel="stylesheet">
<link rel="icon" href="/${appName}/static/images/icon.png" type="image/png"> 
<script src="/${appName}/static/javascript/main.js"></script>
</head>
<body onload='changeActivePageColor()'>

	<div class="site-container">
		<div class="header">
			<div class="logo">
				<a href="/${appName}"><img
					src="/${appName}/static/images/logo.png" alt="site-logo"> </a>
			</div>
			<div class="sign-and-date">
				<h1>Welcome to ${appName}</h1>
					<h3><fmt:formatDate value="${date}" pattern="HH:mm:ss dd/MM/yyyy" /></h3>
			</div>
		</div>