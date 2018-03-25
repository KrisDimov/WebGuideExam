<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menu">
	<a href="/${appName}">Home</a>
	<a href="/${appName}/products">Products</a>
	<a href="/${appName}/orders">Orders</a>
	<a href="/${appName}/customers">Customers</a>
	<a href="/${appName}/offices">Offices</a>
	<a href="/${appName}/employees">Employees</a>
	<a href="/${appName}/payments">Payments</a>
	
	<c:if test="${loggedIn}">
		<a href="/${appName}/logout">Logout</a>
	</c:if>
	
	<c:if test="${!loggedIn}">
		<a href="/${appName}/login">Login</a>
	</c:if>
	
</div>
<div id="content">

		<h1>${title}</h1>
