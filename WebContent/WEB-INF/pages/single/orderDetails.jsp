<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>


	<h1>Order - ${order.number}</h1>
	<span><a href="/${appName}/orders">back to all orders</a></span>

	<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Number</td>
			<td>${order.number}</td>
		</tr>
		<tr>
			<td>Order Date</td>
			<td>${order.orderDate}</td>
		</tr>
		<tr>
			<td>Order Number</td>
			<td>${order.shippedDate}</td>
		</tr>
		<tr>
			<td>Status</td>
			<td>${order.status}</td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td>${order.customerName}</td>
		</tr>
	</table>

	<c:if test="${not empty orderDetails}">
		<table>
			<tr>
				<th>Product Name</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>
			<c:forEach items="${orderDetails}" var="item">
				<tr>
					<td>${item.productName}</td>
					<td>${item.quantity}</td>
					<td>$${item.price}</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</structure:template>