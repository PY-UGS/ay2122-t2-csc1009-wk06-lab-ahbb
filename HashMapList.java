import java.util.*;

public class HashMapList 
{
    public static void main(String[] args) 
    {
        Scanner input = new Scanner(System.in);

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        hash.put(0,1);
        hash.put(1,3);
        hash.put(2,5);
        hash.put(3,7);
        hash.put(4,9);

        //QN4
        System.out.println("Before Add and Sort: "+hash);

        System.out.println("Input integer to add and sort in hash: ");
        int value = input.nextInt();

        addAndSort(hash,value);
        System.out.println("After Add and Sort: "+hash);



        //QN5
        System.out.println("Enter the first index: ");
        int indexOne = input.nextInt();

        System.out.println("Enter the second index: ");
        int indexTwo = input.nextInt();

        swapValues(hash, indexOne, indexTwo);
        System.out.println("After swapping: "+hash);


        //QN6
        System.out.println("Enter a value from 1000 - 9999 to search within a hash: ");
        int searchVal = input.nextInt();

        int index = findValue(hash, searchVal);

        //System.out.println(hash);

        System.out.print("Index of "+searchVal+": "+index);


        input.close();
    }

    public static void addAndSort(HashMap<Integer, Integer>hash, int value)
    {
        int size = hash.size();
        int i,ii;
        int temp=0;
        int temp2=0;

        for(i=0;i<size;i++)
        {  
            if(hash.get(i)>value)
            {
                temp = hash.get(i);
                hash.remove(i);
                hash.put(i,value);
                break;
            }
        }

        int last = hash.get(size-1);
        
        for(ii=i+1;ii<size;)
        {
            if(ii !=i+1)
            {
                hash.put(ii,temp2);
                temp2 = hash.get(ii);
            }
            else
            {
                temp2 = hash.get(ii);
                hash.put(ii,temp);
            }
            ii++;
        }

        hash.put(size,last); 
    }

    public static void swapValues(HashMap<Integer, Integer>hash, int indexOne ,int indexTwo)
    {
        int valueOne = hash.get(indexOne);
        hash.put(indexOne,hash.get(indexTwo));
        hash.put(indexTwo,valueOne);
    }

    public static int findValue(HashMap<Integer,Integer>hash, int searchVal)
    {
        Random random = new Random();
        int index = -1;

        //adding 500 random integers to the hash
        for (int i=0;i<500;i++)
        {
            hash.put(i,random.nextInt(1000,9999));
        }

        if (!hash.containsValue(searchVal))
        {
            index = -1;
        }

        else
        {
            //traversing to see if searchVal exists in the hash
            for(int i=0;i<hash.size();i++)
            {
                if(searchVal == hash.get(i))
                {
                    index = i;
                }
            }
        }
        
        return index;
    }
}
