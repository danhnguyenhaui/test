package model;

import java.sql.SQLException;
import java.util.ArrayList;

import connection.ConnectionBD;
import entities.Author;

public class AuthorModel
{
    ConnectionBD con = null;
    public ArrayList<Author> getAuthorList(){
        ArrayList<Author> list = null;
        try {
            con = new ConnectionBD();
            list = con.getAuthorList();
        } catch (ClassNotFoundException | SQLException e) {
            list = null;
            e.printStackTrace();
        }finally {
            con.close();
        }
        return list;
    }
}
