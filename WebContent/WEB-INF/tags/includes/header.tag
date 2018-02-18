<%@ taglib tagdir="/WEB-INF/tags/includes" prefix="includes"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="UTF-8">
<title>${title} - WebGuideExam</title>
<link href="/${appName}/static/css/main.css" rel="stylesheet">
</head>
<body>

	<div class="site-container">
		<div class="header">
			<div class="logo">
				<a href="/${appName}"><img
					src="/${appName}/static/images/logo.png" alt="site-logo"> </a>
			</div>
			<div class="sign-and-date">
				<p>Welcome to ${appName}
				<p>
					<fmt:formatDate value="${date}" pattern="HH:mm:ss dd/MM/yyyy" />
			</div>
		</div>