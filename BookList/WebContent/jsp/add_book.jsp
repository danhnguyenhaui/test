<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="entities.*" %>
<%@ page import="model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm sách</title>
<link rel="stylesheet" href="../css/add_book.css" style="text/css">
</head>
<% AuthorModel authorModel = new AuthorModel();
	ArrayList<Author> authorList = authorModel.getAuthorList();
%>
<body>
	<h2 align="center">Nhập thông tin sách mới</h2><br>
	<form action="../Controll" method="post" >
		<table class="authorListTable">
			<tr>
				<td>Tên sách: </td>
				<td><input type="text" name="bookName"></td>
			</tr>
			<tr>
				<td>Số trang: </td>
				<td><input type="text" name="numberOfPage"></td>
			</tr>
			
			<tr>
				<td>Tác giả: </td>
				<td>
					<select name="authorName">
						<%
							if(authorList != null){
							    for(Author author : authorList){
							
						%>
						<option><%= author.getAuthorName() + " ID: " + author.getAuthorID() %></option>
						<%
							    }
							}
						%>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>Giá bán: </td>
				<td><input type="text" name="cost"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="addBook" name="action"></td>
				<td><input type="submit" value="Thêm mới" style="width: auto; padding: 2px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>