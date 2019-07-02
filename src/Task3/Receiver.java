package Task3;

public class Receiver
{
    private String receiverUserName;
    private String receiverFirstName;
    private String receiverLastName;
    private String msgBody;
    private String notification;

    public Receiver(String receiverUserName, String receiverFirstName, String receiverLastName)
    {
        this.receiverUserName = receiverUserName;
        this.receiverFirstName = receiverFirstName;
        this.receiverLastName = receiverLastName;
    }

    public String getReceiverUserName() {
        return receiverUserName;
    }

    public void setReceiverUserName(String receiverUserName) {
        this.receiverUserName = receiverUserName;
    }

    public String getReceiverFirstName() {
        return receiverFirstName;
    }

    public void setReceiverFirstName(String receiverFirstName) {
        this.receiverFirstName = receiverFirstName;
    }

    public String getReceiverLastName() {
        return receiverLastName;
    }

    public void setReceiverLastName(String receiverLastName) {
        this.receiverLastName = receiverLastName;
    }

    public String getMsgBody() {
        return msgBody;
    }

    public void setMsgBody(String msgBody) {
        this.msgBody = msgBody;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public void receiveMsg(String msg)
    {
        setMsgBody(msg);

    }

    public void receiveNotification(String msg)
    {
        setNotification(msg);
    }
}
