package entities;

public class BookInfor extends Book
{
    private String authorName = "";

    public BookInfor()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getAuthorName()
    {
        return authorName;
    }

    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }
    
}
