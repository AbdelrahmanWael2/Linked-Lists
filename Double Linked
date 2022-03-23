import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import LinkedList.Node;

interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/
public void add(int index, Object element);
/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
/**
* @param index
* @return the element at the specified position in this list.
*/
public Object get(int index);

/**
* Replaces the element at the specified position in this list with the
* specified element.
* @param index
* @param element
*/
public void set(int index, Object element);
/**
* Removes all of the elements from this list.
*/
public void clear();
/**
* @return true if this list contains no elements.
*/
public boolean isEmpty();
/**
* Removes the element at the specified position in this list.
* @param index
*/
public void remove(int index);
/**
* @return the number of elements in this list.
*/
public int size();
/**
* @param fromIndex
* @param toIndex
* @return a view of the portion of this list between the specified fromIndex and toIndex, inclusively.
*/
public ILinkedList sublist(int fromIndex, int toIndex);
/**
* @param o
* @return true if this list contains an element with the same value as the specified element.
*/
public boolean contains(Object o);
}


public class DoubleLinkedList implements ILinkedList {
	/* Implement your linked list class here*/
        public class doubleLinkedList
        {  
           

            
            
            public  class Node
            {

                    int data;
                    public Node next;
                    public Node previous;

            //constructor
             public Node(int data)
             {
                 this.data = data;
             }
            }
            //pointers
            public Node head;
            public Node tail;
            public int size;

            public doubleLinkedList()
            {
                this.head = null;
                this.tail = null;
                this.size = 0;
            }
        }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       String input = sc.nextLine().replaceAll("\\[|\\]", "");
       String[] s = input.split(", ");
       int[] inputs = new int[s.length];   //array of input integers
       for(int i = 0; i < s.length; ++i)
       {
            inputs[i] = Integer.parseInt(s[i]);
       }
        LinkedList list = new LinkedList();
        for( int i = 0; i < s.length ; i++)
        {
            list.addNode(inputs[i]);
        }
       
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    }
}
