<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="dao.BookDao"%>
<%@ page import="bean.IssueBookBean" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Issued Book</title>
<style>
body{
	background-color:#fbf3e4;
}
ul{
	list-style-type:none;
	margin:0;
	padding:0;
	overflow:hidden;
	background-color: #333;
}
li{
	float:left;
}
li a{
	display:block;
	color:white;
	text-align:center;
	padding:14px 16px;
	text-decoration:none;
	font-size:17px;
}
li a:not(.logo){
	margin-top:2px;
}
li a:hover:not(.logo){
	background-color:#111;
}
.logo{
	margin:0px 20px;
	color:#ffff66;
	font-size:19px;
}
.main{
	width:100%;
	min-height:79vh;
	background:url("images/lib2.jpg");
	background-repeat:no-repeat;
	background-size:cover;
	background-color:#3e3e41;
  	background-blend-mode: screen;
  	margin-top:-15px;
  	padding-bottom:10vh;
}
h1{
	font-size:34px;
	color:white;
	padding:50px 20px 10px 70px;
}
table{
	border:1px solid white;
	width:75%;
	margin-left:auto;
	margin-right:auto;
	margin-top:20px;
	border-collapse:collapse;
	background-color:rgba(255,255,255,0.8);
	text-align:center;
}
tr,td,th{
	border:1px solid white;
	padding:8px 4px;
}
th{
	background-color:rgba(255,255,255,0.9);
	font-size:17px;
}
a{
	color:#0059b3;
}

</style>
</head>
<body>

<ul>
	<li><a href="#" class="logo"><b>e-Library</b></a></li>
	<li><a href="librarian.html">Home</a></li>
	<li><a href="addBook.html">Add Book</a></li>
	<li><a href="issueBook.html">Issue Book</a></li>
	<li><a href="returnBook.html">Return Book</a></li>
	<li><a href="index.html">Logout</a></li>
</ul>

<div class="main">
	<h1>Issued Books List</h1>
	<table>
		<tr><th>Call No</th><th>Student ID</th><th>Student Name</th><th>Student Mobile</th><th>Issued Date</th><th>Return Status</th></tr>
		<%
			ArrayList<IssueBookBean> list = BookDao.viewIssuedBooks();
			for(IssueBookBean bean : list){
				out.println("<tr><td>" + bean.getcallno() + "</td><td>" + bean.getStudentid() + "</td><td>" + bean.getStudentname() + "</td><td>" + bean.getStudentmobile() + "</td><td>" + bean.getIssueddate() + "</td><td>" + bean.getReturnstatus() + "</td></tr>");
			}
		%>
	</table>
</div>

</body>
</html>