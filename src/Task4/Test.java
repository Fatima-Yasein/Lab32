package Task4;

import Task4.BST;

public class Test
{
    public static void main(String[] args)
    {
        BST bst = new BST();
        bst.addNode(50);
        bst.addNode(60);
        bst.addNode(30);
        bst.addNode(70);
        bst.addNode(55);
        bst.addNode(77);
        bst.addNode(65);
        bst.addNode(56);
        bst.addNode(52);
        bst.addNode(40);
        bst.addNode(20);
        bst.addNode(45);
        bst.addNode(35);
        bst.addNode(25);
        bst.addNode(15);

        System.out.println("\nIf adding 77 second time in the tree, the following msg appears:");
        bst.addNode(77);

        System.out.println("\nThe root node is: "+bst.getRootValue()+ ", and the number of nodes is: "+bst.getSize());


        System.out.print("\nDose number 33 exist in the tree? ");
        if(bst.searchNode(33))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.print("\nDose number 70 exist in the tree? ");
        if(bst.searchNode(70))
            System.out.println("Yes");
        else
            System.out.println("No");


        bst.removeNode(50);
        bst.removeNode(60);

        System.out.print("\nDose number 50 exist in the tree - after deleting it? ");
        if(bst.searchNode(50))
            System.out.println("Yes");
        else
            System.out.println("No");

        System.out.println("\nThe root node after deleting nodes 50 and 60 is: "+bst.getRootValue()+ ", and the number of nodes is: "+bst.getSize());



    }
}
