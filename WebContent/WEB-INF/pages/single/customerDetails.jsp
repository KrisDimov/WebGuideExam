<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>

<p><a class="button" href="/${appName}/customers">back to all customers</a>

<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Number</td>
			<td>${customer.name}</td>
		</tr>
		<tr>
			<td>First Name</td>
			<td>${customer.firstName}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${customer.lastName}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${customer.phone}</td>
		</tr>
		<tr>
			<td>Address Line 1</td>
			<td>${customer.address}</td>
		</tr>
		<tr>
			<td>Address Line 2</td>
			<td>${customer.additionalAddress}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${customer.city}</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${customer.state}</td>
		</tr>
		<tr>
			<td>Postal Code</td>
			<td>${customer.postalCode}</td>
		</tr>
		<tr>
			<td>Country</td>
			<td>${customer.country}</td>
		</tr>
		<tr>
			<td>Sales Representative</td>
			<td>${customer.salesRepEmpNum}</td>
		</tr>
		<tr>
			<td>Credit Limit</td>
			<td>${customer.creditLimit}</td>
		</tr>
	</table>

</structure:template>