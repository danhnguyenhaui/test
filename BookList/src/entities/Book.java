package entities;

public class Book
{
    private int bookID = -1;
    private String bookName = "";
    private float cost = 0.0F;
    private int authorID = -1;
    private int numberOfPage = 0;
    
    @Override
    public String toString()
    {
        return "Book [bookID=" + bookID + ", bookName=" + bookName + ", cost=" + cost + ", authorID=" + authorID
                + ", numberOfPage=" + numberOfPage + "]";
    }
    public Book()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getBookID()
    {
        return bookID;
    }
    public void setBookID(int bookID)
    {
        this.bookID = bookID;
    }
    public String getBookName()
    {
        return bookName;
    }
    public void setBookName(String bookName)
    {
        this.bookName = bookName;
    }
    public float getCost()
    {
        return cost;
    }
    public void setCost(float cost)
    {
        this.cost = cost;
    }
    public int getAuthorID()
    {
        return authorID;
    }
    public void setAuthorID(int authorID)
    {
        this.authorID = authorID;
    }
    public int getNumberOfPage()
    {
        return numberOfPage;
    }
    public void setNumberOfPage(int numberOfPage)
    {
        this.numberOfPage = numberOfPage;
    }
    
}
