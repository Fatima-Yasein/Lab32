package Task4;

public class BST
{

    private Integer element;
    private BST left;
    private BST right;
    private BST root;
    private  int size=0;

    public BST()
    {
    }

    public Integer getElement()
    {
        return element;
    }

    public void setElement(Integer element)
    {
        this.element = element;
    }

    public Integer getRootValue()
    {
        return root.getElement();
    }

    public Integer getSize()
    {
        return size;
    }

    public boolean addNode (Integer num)
    {
        BST node = new BST();
        node.setElement(num);
        BST current = root;
        BST parent = null;

        if (root == null)
        {
            root = node;
            size++;
            return true;
        }

        else
        {
            while (current != null)
            {
                parent = current;

                if (node.element < current.element)
                    current = current.left;

                else if (node.element > current.element)
                    current = current.right; // Go right

                else
                {
                    System.out.println("Already existed elements can not be added.");
                    return false;

                }
            }
        }

        if(node.element> parent.element)
            parent.right=node;

        else if (node.element<parent.element)
            parent.left=node;

        else
        {
            System.out.println("Already existed elements can not be added.");
            return false;

        }

        size++;
        return true;
    }

    public boolean removeNode (Integer num)
    {
        BST current = root;
        BST parent = null;

        while (current != null)
        {

            if (current.element == num)
                break;

            else if (num > current.element)
            {
                parent = current;
                current = current.right;
            }

            else
            {
                parent = current;
                current = current.left;
            }
        }

        if (current == null)
            return false;

        if(current.left==null && current.right!=null)
        {
            if(parent==null)
                root= current.right;

            if(parent != null)
            {
                if (num>parent.element)
                    parent.right=current.right;

                if(num<parent.element)
                    parent.left=current.right;
            }
        }

        if(current.right==null && current.left!=null)
        {
            if(parent==null)
                root= current.left;

            if(parent != null)
            {
                if (num>parent.element)
                    parent.right=current.left;

                if(num<parent.element)
                    parent.left=current.left;
            }
        }

        if(current.right!=null && current.left!=null)
        {
            if(parent==null)
            {
                BST temp = current.left;
                current = current.right;
                root=current;

                while (current.left!=null)
                    current=current.left;

                current.left=temp;

            }


            if(parent != null)
            {
                if (num>parent.element)
                {
                    BST temp = current.left;
                    current = current.right;
                    parent.right=current;


                    while (current.left!=null)
                        current=current.left;

                    current.left=temp;
                }

                if(num<parent.element)
                {
                    BST temp = current.left;
                    current = current.right;
                    parent.left=current;

                    while (current.left!=null)
                        current=current.left;

                    current.left=temp;
                }


            }
        }

        if(current.right==null && current.left==null)
        {
            if (num>parent.element)
                parent.right=null;

            if (num<parent.element)
                parent.left=null;
        }

        size --;
        return true;
    }

    public boolean searchNode (Integer num)
    {
        BST current = root;

        if(root==null)
            return false;

        else
        {
            while (current != null)
            {
                if(current.element==num)
                    return true;
                else if(num>current.element)
                    current=current.right;
                else
                    current=current.left;
            }
            return false;
        }
    }

}
