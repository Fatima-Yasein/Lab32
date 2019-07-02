package Task3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class User implements Users
{
    private String userName ;
    private String firstName ;
    private String lastName ;

    public User(String userName, String firstName, String lastName) {
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void addUser() throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();
        Statement stmt = connection.createStatement();

        String selectionQuery= "select UserName from userTable where UserName like '"+this.getUserName()+"'";
        ResultSet resultSet= stmt.executeQuery(selectionQuery);

        boolean userNameFounded=false;

        if (resultSet.next())
        {
            System.out.println("This user name has already been used. Please chose another one.");

            userNameFounded=true;
        }

        if(!userNameFounded)
        {
            String insertionQuery = "insert into userTable (UserName,LastName,FirstName) values " +
                    "('" + this.getUserName() + "','" + this.getLastName() + "','" + this.getFirstName() + "')";

            stmt.executeUpdate(insertionQuery);
            System.out.println("User "+this.getUserName()+" is added successfully");

        }


    }

    public void assignGroup(String groupName) throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();
        Statement stmt = connection.createStatement();

        String selectionQuery= "select UserId, UserName from userTable where UserName like '"+this.getUserName()+"'";
        ResultSet resultSet= stmt.executeQuery(selectionQuery);

        boolean userNameFounded=false;
        int userId;

        if (resultSet.next())
        {
            userId = resultSet.getInt(1);
            String selectionQuery2= "select GroupName from groupTable where GroupName like '"+groupName+"'";
            ResultSet resultSet2= stmt.executeQuery(selectionQuery2);

            boolean groupNameFounded=false;

            if (resultSet2.next())
            {
                String updateQuery = "update groupTable set UsersIds="+userId+" where GroupName like '"+groupName+"'";

               stmt.executeUpdate(updateQuery);

               System.out.println("User added to "+groupName+" successfully");

                groupNameFounded=true;

            }

            if(!groupNameFounded)
                System.out.println("This group does not exist.");


            userNameFounded=true;
        }

        if(!userNameFounded)
            System.out.println("This user does not exist.");

    }
}
