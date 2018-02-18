<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<h1>${title}</h1>

	<c:if test="${not empty customers}">
		<table>
			<tr>
				<th>Number</th>
				<th>Company Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Address</th>
				<th>View</th>
			</tr>
			<c:forEach items="${customers}" var="item">
				<tr>
					<td>${item.number}</td>
					<td>${item.name}</td>
					<td>${item.firstName}</td>
					<td>${item.lastName}</td>
					<td>${item.phone}</td>
					<td>${item.address}</td>
					<td><a href="/${appName}/customers/view?id=${item.number}">View more</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>

</structure:template>