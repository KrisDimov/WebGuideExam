<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>

	<p>
		<a class="button" href="/${appName}/products">back to all products</a>
	<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Code</td>
			<td>${product.code}</td>
		</tr>
		<tr>
			<td>Name</td>
			<td>${product.name}</td>
		</tr>
		<tr>
			<td>Price</td>
			<td>$${product.price}</td>
		</tr>
		<tr>
			<td>Quantity</td>
			<td>${product.quantity}</td>
		</tr>
		<tr>
			<td>Vendor</td>
			<td>${product.vendor}</td>
		</tr>
		<tr>
			<td>Scale</td>
			<td>${product.scale}</td>
		</tr>
	</table>


</structure:template>