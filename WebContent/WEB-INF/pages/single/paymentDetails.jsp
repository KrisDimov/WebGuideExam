<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<structure:template>


	<h1>Payment - ${payment.checkNumber}</h1>
	<a href="/${appName}/payments">back to all orders</a>

	<table>
		<tr>
			<th>Attribute</th>
			<th>Value</th>
		</tr>
		<tr>
			<td>Check Number</td>
			<td>${payment.checkNumber}</td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td>${payment.customerName}</td>
		</tr>
		<tr>
			<td>Customer Number</td>
			<td>${payment.customerNumber}</td>
		</tr>
		<tr>
			<td>Payment Date</td>
			<td>${payment.paymentDate}</td>
		</tr>
		<tr>
			<td>Amount</td>
			<td>$${payment.amount}</td>
		</tr>
	</table>

</structure:template>