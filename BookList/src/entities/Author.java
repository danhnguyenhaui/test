package entities;

public class Author
{
    private int authorID = -1;
    private String authorName = "";
    private String phone = "";
    public Author()
    {
        super();
        // TODO Auto-generated constructor stub
    }
    public int getAuthorID()
    {
        return authorID;
    }
    public void setAuthorID(int authorID)
    {
        this.authorID = authorID;
    }
    public String getAuthorName()
    {
        return authorName;
    }
    public void setAuthorName(String authorName)
    {
        this.authorName = authorName;
    }
    public String getPhone()
    {
        return phone;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }
    
}
