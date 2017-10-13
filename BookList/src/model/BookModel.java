package model;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionBD;
import entities.Book;
import entities.BookInfor;

public class BookModel
{
    private ConnectionBD con = null;
    
    public boolean editBook(Book book) {
        boolean result = false;
        try {
            this.con = new ConnectionBD();
            result = con.editBook(book);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            con.close();
        }
        return result;
    }
    
    public boolean removeBook(int bookID) {
        boolean result = false;
        try {
            this.con = new ConnectionBD();
            result = con.removeBook(bookID);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            con.close();
        }
        return result;
    }
    
    public boolean addBook(Book book) {
        boolean result = false;
        try {
            this.con = new ConnectionBD();
            result = con.addBook(book);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            con.close();
        }
        
        return result;
    }
    
    public ArrayList<BookInfor> getBookList(){

        ArrayList<BookInfor> list = null;
        try {
            this.con = new ConnectionBD();
            list = con.getBookList();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            con.close();
        }
        return list;
    }
}
