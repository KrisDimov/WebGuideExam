<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>

	<p>
		<a class="button" href="/${appName}/offices">back to all offices</a>
	<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Code</td>
			<td>${office.code}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${office.city}</td>
		</tr>
		<tr>
			<td>Phone</td>
			<td>${office.phone}</td>
		</tr>
		<tr>
			<td>Address Line 1</td>
			<td>${office.address}</td>
		</tr>
		<tr>
			<td>Address Line 2</td>
			<td>${office.additionalAddress}</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${office.state}</td>
		</tr>
		<tr>
			<td>Country</td>
			<td>${office.country}</td>
		</tr>
		<tr>
			<td>Postal Code</td>
			<td>${office.postCode}</td>
		</tr>
		<tr>
			<td>Territory</td>
			<td>${office.territory}</td>
		</tr>
	</table>

</structure:template>