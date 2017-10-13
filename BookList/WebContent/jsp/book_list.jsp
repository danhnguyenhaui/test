<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="entities.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Book list</title>
<link type="text/css" href="../css/book_list.css" rel="stylesheet">
</head>
<%
	BookModel bookModel = new BookModel();
	ArrayList<BookInfor> bookList = bookModel.getBookList();
	
%>
<body>
	<table class="bookInforTable">
		<tr class="titleTable">
			<td>Mã sách</td>
			<td>Tên sách</td>
			<td>Số trang</td>
			<td>Tác giả</td>
			<td>Giá bán</td>
			<td>Xóa</td>
			<td>Sửa</td>
		</tr>
		<% if(bookList != null){
				for(BookInfor book : bookList){    
		%>
		<tr>
			<td><%= book.getBookID() %></td>
			<td><%= book.getBookName() %></td>
			<td><%= book.getNumberOfPage() %></td>
			<td><%= book.getAuthorName() %></td>
			<td><%= book.getCost() %></td>
			<td>
				<a href="../Controll?action=removeBook&bookID=
				
					<%= 
						book.getBookID()
					%>">
				Xóa
				</a>
			</td>
			<td>
				<% 
				
					String actionUrl = "/BookList/jsp/edit_book.jsp?action=editBook"; 
					actionUrl += "&bookID=" + book.getBookID();
					actionUrl += "&bookName=" + book.getBookName();
					actionUrl += "&cost=" + book.getCost();
					actionUrl += "&numberOfPage=" + book.getNumberOfPage();
					String authorID = book.getAuthorID()+ "";
					actionUrl += "&authorID=" + book.getAuthorID();
				%>
				<a href="<%= actionUrl %>">Sửa</a>
			</td>
		</tr>
		<%}} %>
		
	</table>
	<a href="add_book.jsp" style="font-size: 20px; margin-left: 20px; margin-top: 200px;">Thêm sách</a>

</body>
</html>