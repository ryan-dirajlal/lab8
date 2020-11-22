// /*
// * Main testing class for BST
// * @author: USFCACS 245
// */

public class BSTtest
{
    public static void main(String[] args)
    {
        //TODO CHANGE CLASS AS NEEDED TO TEST CODE
        BST<String> tree = new BST<String>();


        int L = Integer.parseInt(args[0]);
        int R = Integer.parseInt(args[1]);
        for(int i=2; i < args.length; i++)
        {
            tree.insert(args[i]);

        }

        System.out.println("If a specific value can be removed, the program will return the new tree without that value. \nNow attempting to remove " + args[3]);
        tree.delete(args[3]);
        tree.print();


        System.out.println("\nWhen performing the find function, if a specific key exists, then the program returns true. \nNow trying to find " + (args[4]));
        System.out.println(tree.find(args[4]));

        System.out.println("\nNow trying to find 121\n" + tree.find("121") + "\n");

        System.out.println("Now using rangesum to calculate the sum of the numbers between " + L + " and " +R);
        System.out.println(tree.rangeSum(L, R) + "\n");




    }
}