<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>


<h1>${title}</h1>

	<c:if test="${not empty payments}">
		<table>
			<tr>
				<th>Customer Number</th>
				<th>Check Number</th>
				<th>Payment Date</th>
				<th>Amount</th>
				<th>View</th>
			</tr>
			<c:forEach items="${payments}" var="item">
				<tr>
					<td>${item.customerNumber}</td>
					<td>${item.checkNumber}</td>
					<td>${item.paymentDate}</td>
					<td>$${item.amount}</td>
					<td><a href="/${appName}/payments/view?id=${item.checkNumber}">View more</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</structure:template>