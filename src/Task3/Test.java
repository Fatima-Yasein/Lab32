package Task3;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Test
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException
    {
        Sender sender = new Sender("F_Yasein","Fatima","Yasein");

        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter the message you want to broadcast:");
        String msg= userInput.nextLine();

        System.out.println("***************************************************************************");
        System.out.println("\n Broadcasting to Group1");
        System.out.println("***************************************************************************");
        sender.broadcast("Group1",msg);

        System.out.println("***************************************************************************");
        System.out.println("\n Broadcasting to Group2");
        System.out.println("***************************************************************************");
        sender.broadcast("Group2",msg);

        System.out.println("***************************************************************************");
        System.out.println("\n Broadcasting to Group3");
        System.out.println("***************************************************************************");
        sender.broadcast("Group3",msg);

        System.out.println("***************************************************************************");
        List<Receiver> receivers = sender.getGroupMembers();

        for (int i=0;i<receivers.size();i++)
            System.out.println(receivers.get(i).getReceiverUserName()+ " received a message from "+ sender.getSenderUserName()+ " saying: "+
                    receivers.get(i).getMsgBody()+"\nThe receiver got notified of the message ( "+ receivers.get(i).getNotification()+" )");

        System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println("Please enter the message you want to unicast:");
        String msg2= userInput.nextLine();

        System.out.println("***************************************************************************");
        System.out.println("\nUnicasting to F_Yasein");
        System.out.println("***************************************************************************");
        sender.unicast("F_Yasein",msg2);

        System.out.println("***************************************************************************");
        System.out.println("\n Unicasting to A_Ali");
        System.out.println("***************************************************************************");
        sender.unicast("A_Ali",msg2);

        System.out.println("***************************************************************************");
        System.out.println("\n Unicasting to Z_Ahmed");
        System.out.println("***************************************************************************");
        sender.unicast("Z_Ahmed",msg2);


        System.out.println("***************************************************************************");
        System.out.println("\n Adding a new user and assign it to a group");
        System.out.println("***************************************************************************");


        User user1= new User("H_Yasein","Hassan","Yasein");
        user1.addUser();
        user1.assignGroup("Group1");

    }
}
