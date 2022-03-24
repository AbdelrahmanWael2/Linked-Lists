import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



interface ILinkedList {
/**
* Inserts a specified element at the specified position in the list.
* @param index
* @param element
*/

/**
* Inserts the specified element at the end of the list.
* @param element
*/
public void add(Object element);
}


public class DoubleLinkedList implements ILinkedList {
	/* Implement your linked list class here*/
    class node {
        private Object element; 
        private node next;
        private node previous;
        
        public node (){
            this.element=null;
            this.next=null;
            this.previous=null;
        }
    
        public node(Object element, node next, node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }
        
        public void setNext(node nextNode){
            this.next = nextNode;
        }
        public void setPrevious(node previousNode)
        {
            this.previous = previousNode;
        }
        
        public void setElement(Object newElement){
            this.element = newElement;
        }
        
        public Object getElement(){
         return this.element;
        } 
        public node getPrevious()
        {
            return this.previous;
        }
        
        public node getNext(){
         return this.next;
        } 
    }

    private node head;
    private int size;
    public static boolean error = false;
    
    public DoubleLinkedList() {
        head = null;
        size = 0;
    }

    public void add(Object element)
    {
        node n = new node(element, null , null);
        node temphead = new node();
        temphead = head;
        if(size == 0){
            head = n;
            size++;
        }
        else{
            
            while(temphead.getNext()!=null){
                temphead = temphead.getNext();
            }
            temphead.setNext(n);
            size++;
        
        }

    }


     public void add(int index ,Object element)
     {
        node toAdd = new node(element, null, null);
        node pointer1 = new node();
        node pointer2 = new node();


        if(index == size)
        {
            error = true;
        }
        if(index == 0)
        { 

          pointer1.setNext(head.getNext());
          pointer1.setElement(head.getElement());
          toAdd.setNext(head);
          head = toAdd;
          pointer1.setPrevious(toAdd);
          size++;

          /*head.setPrevious(null);  
          pointer1.setElement(head.getElement());
          pointer1.setNext(head.getNext());
          pointer1.setPrevious(head.getPrevious());
          head =toAdd;
          size++;*/
        }
        else if(index == size){
            add(element);
        }
        else if(index < size && index > 0)
        {
            pointer1=head;
            for(int i = 0 ; i < index-1 ; i++)
            {
                pointer1 = pointer1.getNext(); //go to index -1 
            }
            pointer2.setNext(pointer1.getNext());
            pointer1.setNext(toAdd);
            toAdd.setPrevious(pointer1.getPrevious());
            pointer2.setPrevious(toAdd.getPrevious());
            toAdd.setNext(pointer2.getNext());
            size++;



        }
        else{error = true;}

     }

     public boolean isEmpty(){
        if(size == 0){return true;}
        else{return false;}
    }

     public void set(int index , Object element)
     {
         node pointer = new node();
         if( index >= 0 && index < size )
         {
             pointer = head;
         for( int i = 0 ; i < index ; i ++)
         {
             pointer = pointer.getNext();
         }
         pointer.setElement(element);
        }
        else
        {
            error = true; 
        }
     }

       public Object get(int index)
       {

            node pointer = new node();
            if(index >= 0 && index < size)
            {
                
                pointer = head;
                for(int i =0 ; i < index ; i++)
                {
                    pointer = pointer.getNext();
                }
            }
            else
            {
                error = true ;
            }
            return pointer.getElement();

       }

        public int size()
        {
            return size;
        }
        public boolean contains(Object o){

            while(head != null){
                String b = o.toString();
                String a = head.getElement().toString();
                if(a.equals(b)){return true;}
                head = head.getNext();
            }
            return false;
            
        }

        public void clear(){
            head = null;
         }

         public void remove(int index){
            node n, temp = new node();
            n = head;
            if(index == 0){
                    head = head.getNext();
            }
            else if(index > 0 && index < size){
                for(int i = 0 ; i < index-1; i++){
                    n=n.getNext();
                }
                temp = n.getNext();
                n.setNext(temp.getNext());
            }
            else{error = true;}
    
        }

        public DoubleLinkedList sublist(int fromIndex, int toIndex){
            DoubleLinkedList li = new DoubleLinkedList();
            if(fromIndex > toIndex || fromIndex > size-1 || toIndex > size-1 || fromIndex < 0 || toIndex < 0){error = true;}
            else{ 
                node n = new node();
                n = head;
                for(int i = 0 ; i < fromIndex ;i++){n = n.getNext();}
                for(int j = fromIndex ; j <= toIndex ; j++){
                    li.add(n.getElement());
                    n=n.getNext();
                } 
            }
            return li; 
        }

    public void display(){
        System.out.print("[");
        node n = new node();
        n = head;
        while(n!=null){
            System.out.print(n.getElement());
            if(n.getNext() != null){System.out.print(", ");}
            n = n.getNext();
        }
        System.out.print("]");
    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. */
       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine().replaceAll("\\[|\\]", "");
       String[] s = input.split(", ");
        int[] inputs = new int[s.length];   //array of input integers
       DoubleLinkedList list = new DoubleLinkedList();
       if(s.length == 1 && s[0].isEmpty()){
       inputs = new int[]{};
       }
       else{
            for(int i = 0; i < s.length; ++i)
            {
                    inputs[i] = Integer.parseInt(s[i]);
            }
       
       
            for( int i = 0; i < s.length ; i++)
            {
                list.add(inputs[i]);
            }
        }
        String inputfun = sc.nextLine();

        if(inputfun.equals("add")){
            Object element = sc.next();
            list.add(element);
            list.display();
        }
        if(inputfun.equals("addToIndex")){
            int index = sc.nextInt();
            Object element = sc.next();
            list.add(index, element);
            if(error){System.out.println("Error");}
            else{list.display();}
            
        }

        if(inputfun.equals("isEmpty")){
            if(list.isEmpty()){System.out.println("True");}
            else{System.out.println("False");}
        }

        if(inputfun.equals("set")){
            int index = sc.nextInt();
            Object element = sc.next();
            list.set(index, element);
            if(error){System.out.println("Error");}
            else{list.display();}
        }

        if(inputfun.equals("get")){
            int index = sc.nextInt();
            list.get(index);
            if(error){System.out.println("Error");}
            else{System.out.println(list.get(index));}
        }

        if(inputfun.equals("size")){
            System.out.println(list.size());
        }

        if(inputfun.equals("contains")){
            Object element = sc.next();
            if(list.contains(element)){
                System.out.println("True");
            }
            else{System.out.println("False");}
        }
       
        if(inputfun.equals("clear")){
            list.clear();
            list.display();
        }

        if(inputfun.equals("remove")){
            int index = sc.nextInt();
            list.remove(index);
            if(error){System.out.println("Error");}
            else{list.display();}
        }
        
        if(inputfun.equals("sublist")){
            int fromIndex = sc.nextInt();
            int toIndex = sc.nextInt();
            list = list.sublist(fromIndex , toIndex);
            if(error){System.out.println("Error");}
            else{list.display();}
        }



        sc.close();
    }
}
