<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<h1>${title}</h1>

	<c:if test="${not empty orders}">
		<table>
			<tr>
				<th>Number</th>
				<th>Order Date</th>
				<th>Shipping Date</th>
				<th>Comments</th>
				<th>Status</th>
				<th>View</th>
			</tr>
			<c:forEach items="${orders}" var="item">
				<tr>
					<td>${item.number}</td>
					<td>${item.orderDate}</td>
					<td>${item.shippedDate}</td>
					<td>${item.comments}</td>
					<td>${item.status}</td>
					<td><a href="/${appName}/orders/view?id=${item.number}">View more</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</structure:template>