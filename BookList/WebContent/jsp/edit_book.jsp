<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.*" %>
<%@ page import="entities.*" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cập nhật sách</title>
<link rel="stylesheet" href="../css/add_book.css" style="text/css">
</head>
<% AuthorModel authorModel = new AuthorModel();
	ArrayList<Author> authorList = authorModel.getAuthorList();
	String bookID = request.getParameter("bookID");
	System.out.println(bookID);
	String bookName = request.getParameter("bookName");
	String authorID = request.getParameter("authorID");
	String cost = request.getParameter("cost");
	String numberOfPage = request.getParameter("numberOfPage");
%>
<body>
	<h2 align="center">Cập nhật thông tin sách</h2><br>
	<form action="../Controll" method="post" >
		<table class="authorListTable">
			<tr>
				<td>Mã sách: </td>
				<td><input type="text" name="bookID" readonly="readonly" value="<%= bookID %>"></td>
			</tr>
			<tr>
				<td>Tên sách: </td>
				<td><input type="text" name="bookName" value="<%= bookName %>"></td>
			</tr>
			<tr>
				<td>Số trang: </td>
				<td><input type="text" name="numberOfPage" value="<%= numberOfPage %>"></td>
			</tr>
			
			<tr>
				<td>Tác giả: </td>
				<td>
					<select name="authorName">
						<%
							if(authorList != null){
							    for(Author author : authorList){
							        
							        boolean checked = false;
							        if(authorID.equals("" + author.getAuthorID())){
							            checked = true;
							        }
							
						%>
						<option <%= (checked)?"selected='selected'":"" %>><%= author.getAuthorName() + " ID: " + author.getAuthorID() %></option>
						<%
							    }
							}
						%>
					</select>
					
				</td>
			</tr>
			<tr>
				<td>Giá bán: </td>
				<td><input type="text" name="cost" value="<%= cost %>"></td>
			</tr>
			<tr>
				<td><input type="hidden" value="editBook" name="action"></td>
				<td><input type="submit" value="Cập nhật" style="width: auto; padding: 2px;"></td>
			</tr>
		</table>
	</form>
</body>
</html>