<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<c:if test="${not empty products}">
	<table>
		<tr>
			<th>Code</th>
			<th>Name</th>
			<th>Line</th>
			<th>Quantity</th>
			<th>Price</th>
			<th>View</th>
		</tr>
		<c:forEach items="${products}" var="item">
			<tr>
				<td>${item.code}</td>
				<td>${item.name}</td>
				<td>${item.line}</td>
				<td>${item.quantity}</td>
				<td>$${item.price}</td>
				<td align="center"><a class="button" href="/${appName}/products/view?id=${item.code}">Details</a></td>
			</tr>
		</c:forEach>
	</table>
</c:if>


</structure:template>