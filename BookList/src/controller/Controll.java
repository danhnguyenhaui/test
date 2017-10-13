package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Book;
import model.BookModel;

/**
 * Servlet implementation class Controll
 */
@WebServlet("/Controll")
public class Controll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controll() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		updateData(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	    updateData(request, response);
	    
	}

	private void updateData(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    response.setCharacterEncoding("UTF_8");   
	    request.setCharacterEncoding("UTF-8");
	    String action = request.getParameter("action");
	        if(action != null) {
	            BookModel bookModel = new BookModel();
	            String bookID = request.getParameter("bookID");
	            System.out.println(bookID);
	            String bookName = request.getParameter("bookName");
	            String authorID = request.getParameter("authorName");
	            String cost = request.getParameter("cost");
	            String numberOfPage = request.getParameter("numberOfPage");
	            Book book = new Book();
	            try {
	                
	                
	                if("addBook".equals(action)) {
	                    book.setBookName(bookName);
	                    book.setCost(Float.parseFloat(cost));
	                    book.setNumberOfPage(Integer.parseInt(numberOfPage));
	                    authorID = authorID.substring(authorID.indexOf(':') + 1).trim();
	                    book.setAuthorID(Integer.parseInt(authorID));
	                    System.out.println(book);
	                    bookModel.addBook(book);
	                    
	                }else if("editBook".equals(action)) {
	                    book.setBookID(Integer.parseInt(bookID));
	                    book.setBookName(bookName);
	                    book.setCost(Float.parseFloat(cost));
	                    book.setNumberOfPage(Integer.parseInt(numberOfPage));
	                    authorID = authorID.substring(authorID.indexOf(':') + 1).trim();
	                    book.setAuthorID(Integer.parseInt(authorID));
	                    System.out.println(book);
	                    bookModel.editBook(book);
	                    
	                }else if("removeBook".equals(action)) {
	                    int id = Integer.parseInt(bookID);
	                    bookModel.removeBook(id);
	                    
	                }
	                response.sendRedirect("/BookList/jsp/book_list.jsp");
	            } catch (Exception e) {
	                e.printStackTrace();
	                response.sendRedirect("/BookList/jsp/book_list.jsp");
	            }
	            
	            
	        }
	        
	       
	}
	
}
