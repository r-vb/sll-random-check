//imports used.
import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//node creation for sll.
class Node 
{
    int info;
    Node nxt;

    Node(int info) 
    {
        this.info = info;
        this.nxt = null;
    }
}

// singlylinkedList CREATION.
class linkedlist 
{
    Node head;

    linkedlist()
    {
        this.head = null;
    }
    
    // sll insert node method.
    public void sllinsertnode(int info) 
    {
        Node newnode = new Node(info);
        if (head == null) 
        {
            head = newnode;
        } 
        else 
        {
            Node curr = head;
            while (curr.nxt != null) 
            {
                curr = curr.nxt;
            }
            curr.nxt = newnode;
        }
    }

    // sll printing all available nodes / data in ll.
    public void display() 
    {
        if (head == null) 
        {
            System.out.println("No ele present!");
            return;
        }

        Node curr = head;
        while (curr != null) 
        {
            System.out.print(curr.info + " ");
            curr = curr.nxt;
        }
        System.out.println();
    }
    
    // explored random numbers generation for huge dataset.
    public void insertrandomnos(int numinp)
    {
        Random any = new Random();
        int i = 0;
        while (numinp >= i)
        {
			int anynum = any.nextInt(20000001) - 10000000; // generates a random number b/w range -10000000 and 10000000.
			/* int anynum = any.nextInt(); */	   // was generating any long type value.
            sllinsertnode(anynum);
            i++;
        }
        System.out.println("Random " + numinp + " numbers inserted in SLL.");
    }
}

class CustomTailor071 
{	public static void main(String args[]) 
	{
	    Scanner scanner = new Scanner(System.in);
	    linkedlist sll = new linkedlist();

	    if (args.length == 0) 
	    {
	        System.out.println("No input in command line argument.");
	    }

	    int numinp = Integer.parseInt(args[0]);
	    if (numinp <= 0) 
	    {
	        System.out.println("No. of random numbers should be more than 0.");
	    }

	    sll.insertrandomnos(numinp);

	    long startTimeNano = System.nanoTime();
	    traversaltilllast(sll);
	    long endTimeNano = System.nanoTime();
	    
	    System.out.println((endTimeNano - startTimeNano));  //in nanosecs.
	    System.out.println();

	    // Saving output to file
	    try {
	        FileWriter fileWriter = new FileWriter("dataSLL.txt", true); // Set the second parameter to true for append mode
	        PrintWriter printWriter = new PrintWriter(fileWriter);
	        printWriter.println((endTimeNano - startTimeNano));
	        printWriter.close();
	    } 
	    catch (IOException e) 
	    {
	        System.out.println("Error occurred while saving output to file.");
	    }
	    scanner.close();
	}
    
    // to find length of sll and pass on to sorting.
    public static int sllistlen(linkedlist sll)
    {
        int len = 0;
        Node curr = sll.head;
        while (curr != null) 
        {
            len++;
            curr = curr.nxt;
        }
        return len;
    }

    // traversal method.
    public static void traversaltilllast(linkedlist sll) 
    {
        if (sll.head == null) 
        {
            System.out.println("No elements present in the singly linked list.");
            return;
        }

        Node curr = sll.head;
        while (curr.nxt != null) 
        {
            curr = curr.nxt;
        }
		 /* System.out.println(curr.info); // Print the last element*/
    }
}