<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<c:if test="${not empty offices}">
		<table>
			<tr>
				<th>Code</th>
				<th>City</th>
				<th>Phone</th>
				<th>Address</th>
				<th>Country</th>
				<th>Postal Code</th>
				<th>View</th>
			</tr>
			<c:forEach items="${offices}" var="item">
				<tr>
					<td>${item.code}</td>
					<td>${item.city}</td>
					<td>${item.phone}</td>
					<td>${item.address}</td>
					<td>${item.country}</td>
					<td>${item.postCode}</td>
					<td align="center"><a class="button" href="/${appName}/offices/view?id=${item.code}">Details</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</structure:template>