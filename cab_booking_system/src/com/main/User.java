package  com.main;

public class User {
    private int id;
    private String username;
    private String password;
    private String phonenumber;
    private String role;
    private static int incrementcounter = 100;

    public User(String username,String password , String phonenumber, String role)
    {
        this.id = ++incrementcounter;
        this.username = username;
        this.password = password;
        this.phonenumber = phonenumber;
        this.role = role;
    }
    
    public int getId()
    {
        return id;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhonenumber()
    {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber)
    {
        this.phonenumber = phonenumber;
    }

    public String getRole()
    {
        return role;
    }

    public void setRole(String role)
    {
        this.role = role;
    }
}
