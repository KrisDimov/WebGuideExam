<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="menu">
	<a id='home' class='' href="/${appName}">Home</a>
	<a id='products' class='' href="/${appName}/products">Products</a>
	<a id='orders' class='' href="/${appName}/orders">Orders</a>
	<a id='customers' class='' href="/${appName}/customers">Customers</a>
	<a id='offices' class='' href="/${appName}/offices">Offices</a>
	<a id='employees' class='' href="/${appName}/employees">Employees</a>
	<a id='payments' class='' href="/${appName}/payments">Payments</a>
	
	<c:if test="${loggedIn}">
		<a href="/${appName}/logout">Logout</a>
	</c:if>
	
	<c:if test="${!loggedIn}">
		<a href="/${appName}/login">Login</a>
	</c:if>
	
</div>
<div id="content">

		<h1>${title}</h1>
