/*
* Binary search tree data structure
* @author : 
*/

public class BST<T> {
    /*
    * The root of the BST
    */
    Node<T> root;

    /*
    * Node class for a BST
    */
    private class Node<T>
    {
        Comparable<T> data;
        Node<T> left;
        Node<T> right;
        int instance;

        Node(Comparable<T> item)
        {
            data = item;
            instance = 1;
        }
    }

    public BST()
    {
        root = null;
    }

   
    //finds an item, following the class notes
    public boolean find(Comparable<T> item)
    {
        return find(item, root);
    }


    private boolean find(Comparable<T> item, Node<T> node)
    {
        if (node == null) 
        {
            return false;
        }
        int key =Integer.parseInt(item.toString());
        int data = Integer.parseInt(node.data.toString());

        if (key == data) 
            return true;

        else if (key  < data) 
            return find(item, node.left);

        else if (key > data) 
        {
            return find(item, node.right);
        }

        return false;
      




    }

    /*
    * Insert an item to the tree
    * @param item to insert
    */
    public void insert(Comparable<T> item)
    {
        root = insert(item, root);
    }

    /*
    * Helper function for insert
    */

    //inserts an item, following the class notes
    private Node<T> insert(Comparable<T> item, Node<T> node)
    {
       
        if (node == null) 
        {
            Node<T> n = new Node<T>(item);
            node = n;
            return n;
        }

        int key =Integer.parseInt(item.toString());
        int data =Integer.parseInt(node.data.toString());

        if (key < data) 
            node.left = insert(item, node.left);

        else  
            node.right = insert(item, node.right);
        
        return node;
    }

    /*
    * Function for deletion of a node
    */
    public void delete(Comparable<T> item)
    {
        root = delete(item, root);
    }

    /*
    * Helper function for deletion of a node
    */
    //deletes a node, following the class notes
    private Node<T> delete(Comparable<T> item, Node<T> node)
    {
      
        if (node == null) 
            return null;
        
        if (item.compareTo((T) node.data) > 0) 
        {
            node.right = delete(item, node.right);
            return node;
        } 

        else if (item.compareTo((T) node.data) < 0) 
        {
            node.left = delete(item, node.left);
            return node;
        } 

        else 
        {
            if (node.left == null) 
                return node.right;
            
             else if (node.right == null)
                return node.left;
            
            else 
            {
                if (node.right.left == null) 
                {
                    node.data = node.right.data;
                    node.right = node.right.left;
                } 
                else
                    node.data = removeSmallest(node.right);
                
                return node;
            }
        }
    }

    public Comparable<T> removeSmallest(Node<T> node) 
    {
        if (node.left.left == null) 
        {
            Comparable<T> smallest = node.left.data;
            node.left = node.left.right;
            return smallest;
        } 
        else 
            return removeSmallest(node.left); 
    }

    /*
    * Function to find the range sum of the binary tree
    */
    int result;
    //finds the sum of the numbers between 2 values
    public int rangeSum(int L, int R)
    {
  
        result = 0;
        rangeSum(root, L, R);
        return result;
    }
    public void rangeSum(Node<T> node, int L, int R)
    {
        if(node == null)
            return;

        else
        {
            int data = Integer.parseInt(node.data.toString());
            if(data <= R && data >= L)
                result += data;
            
            if(data > L)
                rangeSum(node.left, L, R);
            
            if (data < R) 
                rangeSum(node.right, L, R);
        }

    }

    /*
    * Function to print the Binary tree
    */
    public void print()
    {
        print(root);
        System.out.println();
    }

    /*
    * Helper Function to print the Binary tree
    */
    private void print(Node<T> root)
    {

        // in order traversal following class notes
        if (root != null) {

            print(root.left);
            System.out.print(root.data + " ");
            print(root.right);

        }
    }

}