<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure" %>

<structure:template>


<h1>${title}</h1>

	<c:if test="${not empty employees}">
		<table>
			<tr>
				<th>Number</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Job Title</th>
				<th>View</th>
			</tr>
			<c:forEach items="${employees}" var="item">
				<tr>
					<td>${item.number}</td>
					<td>${item.firstName}</td>
					<td>${item.lastName}</td>
					<td>${item.email}</td>
					<td>${item.jobTitle}</td>
					<td><a href="/${appName}/employees/view?id=${item.number}">View more</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>


</structure:template>
