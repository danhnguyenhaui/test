package connection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import entities.Author;
import entities.Book;
import entities.BookInfor;

public class ConnectionBD
{
    private Connection conection = null;
    private PreparedStatement sqlGetBookList = null;
    private CallableStatement sqlAddBook = null;
    private CallableStatement sqlRemoveBook = null;
    private CallableStatement sqlEditBook = null;
    private PreparedStatement sqlGetAuthorList = null;
    
    public void close() {
        try {
            sqlGetBookList.close();
            sqlRemoveBook.close();
            sqlAddBook.close();
            sqlEditBook.close();
            sqlGetAuthorList.close();
            this.conection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
    }

    public ConnectionBD() throws ClassNotFoundException, SQLException
    {
        super();
        Class.forName(Config.DRIVER_STRING);
        this.conection = DriverManager.getConnection(Config.CONNECTION_URL_STRING, Config.USER_NAME, Config.PASSWORD);
        sqlGetBookList = conection.prepareStatement(
                "select CUON_SACH.MA_SACH, CUON_SACH.TenSach, CUON_SACH.SoTrang, CUON_SACH.GiaTien, TAC_GIA.HoTen, TAC_GIA.MA_TG" + 
                " from CUON_SACH inner join TAC_GIA on CUON_SACH.MA_TG = TAC_GIA.MA_TG");
        
        sqlAddBook = conection.prepareCall(
                "{call PROC_addBook(?, ?, ?, ?, ?)}");
        
        sqlRemoveBook = conection.prepareCall(
                "{call PROC_removeBook(?, ?)}");
        sqlEditBook = conection.prepareCall(
                "{call PROC_updateBook(?, ?, ?, ?, ?, ?)}");
        sqlGetAuthorList = conection.prepareStatement(
                "select * from TAC_GIA");
        this.conection.setAutoCommit(false);
    }

    public ArrayList<BookInfor> getBookList(){
        ArrayList<BookInfor> list = null;
        try {
            list = new ArrayList<>();
            ResultSet result = sqlGetBookList.executeQuery();
            while(result.next()) {
                BookInfor book = new BookInfor();
                book.setBookID(result.getInt("MA_SACH"));
                book.setBookName(result.getString("TenSach"));
                book.setAuthorName(result.getString("HoTen"));
                book.setCost(result.getFloat("GiaTien"));
                book.setNumberOfPage(result.getInt("SoTrang"));
                book.setAuthorID(result.getInt("MA_TG"));
                list.add(book);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }
        
        return list;
        
    }

    public boolean addBook(Book book) throws SQLException {
        if(book == null) {
            return false;
        }
        sqlAddBook.setString(1, book.getBookName());
        sqlAddBook.setInt(2, book.getNumberOfPage());
        sqlAddBook.setFloat(3, book.getCost());
        sqlAddBook.setInt(4, book.getAuthorID());
        sqlAddBook.registerOutParameter(5, Types.INTEGER);
        sqlAddBook.execute();
        this.conection.commit();
        int result = sqlAddBook.getInt(5);
        
        return (result > 0)?true:false;
    }
    
    public boolean removeBook(int bookID) throws SQLException {
        if(bookID < 0) {
            return false;
        }
        sqlRemoveBook.setInt(1, bookID);
        sqlRemoveBook.registerOutParameter(2, Types.INTEGER);
        sqlRemoveBook.execute();
        this.conection.commit();
        int result = sqlRemoveBook.getInt(2);
        return (result > 0)?true:false;
    }
    
    public boolean editBook(Book book) throws SQLException {
        if(book == null) {
            return false;
        }
        sqlEditBook.setInt(1, book.getBookID());
        sqlEditBook.setString(2, book.getBookName());
        sqlEditBook.setInt(3, book.getNumberOfPage());
        sqlEditBook.setFloat(4, book.getCost());
        sqlEditBook.setInt(5, book.getAuthorID());
        sqlEditBook.registerOutParameter(6, Types.INTEGER);
        sqlEditBook.execute();
        this.conection.commit();
        int result = sqlEditBook.getInt(6);
        
        return (result > 0)?true:false;
    }
    
    public ArrayList<Author> getAuthorList(){
        ArrayList<Author> list = null;
        ResultSet result;
        try {
            result = sqlGetAuthorList.executeQuery();
            list = new ArrayList<>();
            while(result.next()){
                Author author = new Author();
                author.setAuthorID(result.getInt("MA_TG"));
                author.setAuthorName(result.getString("HoTen"));
                author.setPhone(result.getString("DienThoai"));
                list.add(author);
            }
        } catch (SQLException e) {
            list = null;
            e.printStackTrace();
        }
        
        return list;
    }
    
}
