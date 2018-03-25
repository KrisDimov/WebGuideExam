<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags/structure" prefix="structure"%>

<structure:template>

	<h2>Java - Explore the Enterprise - Web Exam</h2>
<p class='colored'>February 04, 2018</p>
<h3>Overview</h3>
<p>This document will serve as a general overview of the task that has to be completed for the web part of the exam.
<h3>Goals</h3>
	<ol class='colored'>
		<li>Create Dynamic Web Project using Eclipse IDE and Java Web
			Development Environment using Servlets, JSP, Tomcat, Custom Tags,
			JSTL , HTML and CSS</li>
		<li>Connecting to the database using JDBC driver from the Web
			application and display all the required data as per wireframes</li>
		<li>Create Sample HTML and CSS layout in order to display all
			information</li>
	</ol>
	<h3>Specifications</h3>
<p>Please check the wireframes provided in the web folder. Basically there are 3 types of screens: <b>First type</b> is Home Page which has to be displayed when you open your project which has the structure illustrated in the wireframe - <b>exam-home</b>. It has header with logo, text, current date, it has section with 6 boxes with link to specific Domain Item from the database, and footer which displays some copyright things. <b>Second type</b> of screens are so called Listing Pages - There are 6 pages of this type, one for every domain object we want to visualize. There are some examples in the wireframe, how these pages are suppose to look like (see <b>exam-products, exam-orders</b> etc.), so follow the same idea for the other items which don't have exact wireframe. For Every type these are the things you have to display in the grid:
<ol>
		<li><b>Products</b> - product code, product name, product line ,
			quantity In Stock, buy Price</li>
		<li><b>Orders</b> - order number, order date, shipping date,
			comments, status</li>
		<li><b>Customers</b> - customer number, customer name, contact first
			name, contact last name, phone, address line 1</li>
		<li><b>Offices</b> - officeCode, city, phone, addressLine1, country,
			postalCode</li>
		<li><b>Employees</b> - employeeNumber, lastName, firstName, email,
			jobTitle</li>
		<li><b>Payments</b> - customerNumber, checkNumber, paymentDate,
			amount</li>
	</ol>
<p><b>Third type</b> of pages is so called <b>Single Item Page</b> - that means this page is suppose to display full information for one particular item of specific domain type - please check - <b>exam-products-singleitem, exam-orders-singleitem</b> etc. wireframes for reference.
<p>For Every type which has to be displayed on the Single Item Page, This is the information required:
<ol>
		<li><b>Product Item</b> - productcode, productname, price, quantity,
			vendor and scale</li>
		<li><b>Order item</b> - orderNumber, orderDate, shippingDate, status,
			customerName; Order Detail - productName, price and ordered Quantity</li>
		<li><b>Customer Item</b> - customerName, customerNumber,
			contactLastName, contactFirstName, phone, addressLine1, addressLine2,
			city, state, postalCode, country, salesRepEmployeeNumber, creditLimit</li>
		<li><b>Office Item</b> - officeCode, city, phone, addressLine1,
			addressLine2, state, country, postalCode, territory</li>
		<li><b>Employee Item</b> - employeeNumber, lastName, firstName,
			extension, email, reportsTo, jobTitle, office.city, office.country</li>
		<li><b>Payments</b> - customerNumber, customer.customerName,
			checkNumber, paymentDate, amount</li>
	</ol>
	<h3>Important Notes</h3>
<p>Please explore all the sample projects that are available in the GIT under samples/web folder. You can use the structure and some code from there, but the idea is to do this alone with some minor usage of existing code.
<p>Use the classicmodels sample SQL that is placed in sampledatabase folder. Create the database and import the script in it.
<p>As for the HTML and CSS, just do simple layout with no fancy components.(If you can, do it, but it is not mandatory). Check classicmodel project.
<p class='colored'>There are numerous places where you will find "unmatching" columns described above(and in the wireframes) when displaying information. This is because you need to do JOIN query between two tables with PK and FK respectively, in order to extract the information you need to display the page - either listing or single item. I suggest you start the implementation from Home Page then move to Products Listing / Product Item, Then Order Listing / Order Item and then the rest using the same idea.</p>
<p>Be careful when you open a Connection to the database, to close it after. 
<p>You can see that all pages have the same header and footer part - that is the name of the top and bottom sections of the page respectively. They are not changing when moving across pages so you can use some sort of template or custom tag, to load them easily, without repeating the same html code in every page. Check the sample projects...
<p><b>THAT IS BASICALLY IT. GOOD LUCK ! - You have more than enough, whole week, so try to make it nice, even with more functionality than required! :). If you have questions, I will be available in facebook group, radkosl skype, or google hangouts - break.rado@gmail.com</b>


		

</structure:template>