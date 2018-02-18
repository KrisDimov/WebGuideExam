<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>


	<h1>Employee - ${employee.number} ${employee.firstName} ${employee.lastName}</h1>
	<a href="/${appName}/employees">back to all orders</a>

	<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Number</td>
			<td>${employee.number}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${employee.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${employee.lastName}</td>
		</tr>
		<tr>
			<td>Extension</td>
			<td>${employee.extension}</td>
		</tr>
		<tr>
			<td>Email</td>
			<td>${employee.email}</td>
		</tr>
		<tr>
			<td>Boss</td>
			<td>${employee.boss}</td>
		</tr>
		<tr>
			<td>Job Title</td>
			<td>${employee.jobTitle}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${employee.city}</td>
		</tr>
		<tr>
			<td>Country</td>
			<td>${employee.country}</td>
		</tr>
	</table>

</structure:template>