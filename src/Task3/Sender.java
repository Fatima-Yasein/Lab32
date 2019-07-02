package Task3;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Sender
{
    private String senderUserName;
    private String senderFirstName;
    private String senderLastName;
    private int senderId;
    private String groupName;
    private String msgBody;
    private List<Receiver> groupMembers = new ArrayList();


    public Sender(String senderUserName, String senderFirstName, String senderLastName)
    {
        this.senderUserName = senderUserName;
        this.senderFirstName = senderFirstName;
        this.senderLastName = senderLastName;
    }

    public String getSenderUserName() {
        return senderUserName;
    }

    public void setSenderUserName(String senderUserName) {
        this.senderUserName = senderUserName;
    }

    public String getSenderFirstName() {
        return senderFirstName;
    }

    public void setSenderFirstName(String senderFirstName) {
        this.senderFirstName = senderFirstName;
    }

    public String getSenderLastName() {
        return senderLastName;
    }

    public void setSenderLastName(String senderLastName) {
        this.senderLastName = senderLastName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public int getSenderId() throws SQLException, ClassNotFoundException
    {
        setSenderId();
        return senderId;
    }

    void setSenderId() throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();

        Statement stmt = connection.createStatement();

        ResultSet rs = stmt.executeQuery("SELECT UserId FROM userTable WHERE UserName = '" + this.getSenderUserName()+"'");

        if(rs.next())
        {
            this.senderId = rs.getInt(1);
        }
    }


    public void setGroupMembers(List<Receiver> groupMembers) {
        this.groupMembers = groupMembers;
    }

    public List<Receiver> getGroupMembers() {
        return groupMembers;
    }

    boolean getGroupMembers(String groupName) throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();

        Statement stmt = connection.createStatement();
        Statement stmt2 = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT UsersIds FROM groupTable WHERE groupName = '" + groupName+"'");
        int id =0;

        while(rs.next())
        {
            id = rs.getInt(1);

            if (id!=getSenderId())
            {

                ResultSet rs2 = stmt2.executeQuery("SELECT * FROM userTable WHERE UserId = " + id);

                if(rs2.next())
                {
                    Receiver receiver = new Receiver(rs2.getString(2), rs2.getString(4), rs2.getString(3));
                    this.groupMembers.add(receiver);
                }

            }

        }

        if (groupMembers.size()==0)
        {
            if (id==getSenderId())
                System.out.println("There is only the sender in this group");
            else
                System.out.println(groupName + " does not exist, or the group does not have any member");

            return false;
        }

        return true;

    }

    public void broadcast(String groupName, String msgBody ) throws SQLException, ClassNotFoundException
    {
        if (getGroupMembers(groupName))
        {

            this.setMsgBody(msgBody);

            for (int i = 0; i < this.groupMembers.size(); i++)
                this.groupMembers.get(i).receiveMsg(msgBody);

            System.out.println("Message sent to the group");

            saveBroadcastMsgToDB(msgBody, groupName, getSenderUserName());
            System.out.println("Message saved to the database");

            notifyReceivers(this.groupMembers);
            System.out.println("Receivers got notified");
        }

        else
            System.out.println("Broadcast failed");

    }

    void notifyReceivers( List<Receiver> groupMembers)
    {
        for (int i=0;i<this.groupMembers.size();i++)
            this.groupMembers.get(i).receiveNotification("You received a message from "+this.getSenderUserName());
    }

     void saveBroadcastMsgToDB(String msgBody,String receiverUserName ,String senderUserName) throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();

        Statement stmt = connection.createStatement();

        String insertionQuery = "insert into message (MsgContent,Sender,GroupReceiver) values " +
                "('"+msgBody+"','"+senderUserName+"','"+receiverUserName+"')";

        stmt.executeUpdate(insertionQuery);

    }

    void saveUnicastMsgToDB(String msgBody,String receiverUserName ,String senderUserName) throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();

        Statement stmt = connection.createStatement();

        String insertionQuery = "insert into message (MsgContent,Sender,UserReceiver) values " +
                "('"+msgBody+"','"+senderUserName+"','"+receiverUserName+"')";

        stmt.executeUpdate(insertionQuery);

    }
    void notifyReceivers( Receiver receiver)
    {
        receiver.receiveNotification("You received a message from "+this.getSenderUserName());
    }

    Receiver getReceiver(String userName) throws SQLException, ClassNotFoundException
    {
        Connection connection= Database.getConnection();

        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM userTable WHERE UserName = '" + userName+"'");

        Receiver receiver = null;
        int id = 0;

        if(rs.next())
        {
            id = rs.getInt(1);

            if (id!=getSenderId())
                 receiver = new Receiver(rs.getString(2), rs.getString(4), rs.getString(3));
        }

        if(receiver == null)
        {
            if (id==getSenderId())
                System.out.println("The sender is the receiver");
            else
                System.out.println(userName + " does not exist");
        }

        return receiver;

    }

    public void unicast(String userName, String msgBody ) throws SQLException, ClassNotFoundException
    {
        Receiver receiver = getReceiver(userName);

        if(receiver != null)
        {
            this.setMsgBody(msgBody);
            receiver.receiveMsg(msgBody);

            System.out.println("Message sent to "+ userName);

            saveUnicastMsgToDB(msgBody,userName,getSenderUserName());
            System.out.println("Message saved to the database");

            notifyReceivers(receiver);
            System.out.println("Receiver got notified");
        }

        else
            System.out.println("Unicast failed");

    }


}
