import java.util.*;

public class IntLinkedList 
{
    public static void main(String[] args) throws Exception 
    {
        LinkedList<Integer> l = new LinkedList<Integer>();
        LinkedList<Integer> l2 = new LinkedList<Integer>();
        Scanner input = new Scanner(System.in);

        l.add(1);
        l.add(3);
        l.add(5);
        l.add(7);
        l.add(9);

        //QN1
        System.out.println("Before Add and Sort: "+ l);

        System.out.println("Input integer to add and sort in linked list: ");
        int value = input.nextInt();
        addAndSort(l,value);

        System.out.println("After Add and Sort: "+l);


        //QN2
        System.out.println("Enter an index in the linked list (0-5): ");
        int indexOne = input.nextInt();

        System.out.println("Enter another index to swap with in the linked list (0-5): ");
        int indexTwo = input.nextInt();

        l = swapList(l, indexOne, indexTwo);

        System.out.println("After swap: "+l);


        //QN3
        System.out.println("Enter a value from 1000 - 9999 to search within a linked list: ");
        int searchVal = input.nextInt();
        
        //linked list l2 will have 500 random generated integers to search, returning the index
        int index = findValue(l2,searchVal);

        //System.out.println(l2);

        System.out.print("Index of "+searchVal+": "+index);

        input.close();
    }

    public static void addAndSort(LinkedList<Integer>list, int value)
    {
        int size = list.size();
        int i;

        for(i=0;i<size;i++)
        {  
            if(list.get(i)>value)
            {
                //eg. if list.get(0)>value, add new value to index 0. the original value at index 0 will be at index 1
                list.add(i,value);
                break;
            }
        }
    }

    public static LinkedList<Integer> swapList(LinkedList<Integer>list, int indexOne, int indexTwo)
    {
        int elementOne = list.get(indexOne);
        int elementTwo = list.get(indexTwo);

        //set indexOne with elementTwo
        list.set(indexOne, elementTwo);
        //set indexTwo with elementOne
        list.set(indexTwo, elementOne);
        
        return list;
    }

    public static int findValue(LinkedList<Integer> list, int searchVal)
    {
        Random random = new Random();
        int index = -1;

        //adding 500 random integers to a linked list
        for (int i=0;i<500;i++)
        {
            list.add(random.nextInt(1000,9999));
        }

        //traversing the linked list to see whether searchVal exists
        for (int i=0;i<500;i++)
        {
            if(searchVal == list.get(i))
            {
                index = i;
                break;
            }
        }

        return index;
    }
}
