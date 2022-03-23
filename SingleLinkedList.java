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


public class SingleLinkedList implements ILinkedList {
    /* Implement your linked list class here*/
    class node {
        private Object element; 
        private node next;
        
        public node (){
            this.element=null;
            this.next=null;
        }
    
        public node(Object element, node next) {
            this.element = element;
            this.next = next;
        }
        
        public void setNext(node nextNode){
            this.next = nextNode;
        }
        
        public void setElement(Object newElement){
            this.element = newElement;
        }
        
        public Object getElement(){
         return this.element;
        } 
        
        public node getNext(){
         return this.next;
        } 
    }

    private node head;
    private int size;
    public static boolean error = false;
    
    public SingleLinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int index, Object element){
        node n = new node(element, null);
        node temp = new node();
        node temp2 = new node();
        
        if(index == 0){
            if(size == 0){add(element);}
            else{
                temp.setElement(head.getElement());
                temp.setNext(head.getNext());
                n.setNext(temp);
                head=n;
                size++;
            }
        }

        else if(index == size){
            add(element);
        }
        else if(index < size && index > 0){
            temp = head;
            for(int i = 0 ; i < index-1 ; i++){
                temp = temp.getNext();    
            }
            temp2 = temp.getNext();
            temp.setNext(n);
            n.setNext(temp2);
            size++;
        }
        else{error = true;}
        
    }

    public void add(Object element){
        node n = new node(element,null);
        node temp = new node();
        temp = head;
        if(size == 0){
            head = n;
            size++;
        }
        else{
            
            while(temp.getNext()!=null){
                temp = temp.getNext();
            }
            temp.setNext(n);
            size++;
        
        }
    }

    public Object get(int index){
        node n = new node();
        if(index > size-1 || index < 0){error = true;}
        else{
            n =  head;
            for(int i = 0 ; i <= index-1 ; i++){
                n = n.getNext();
            }  
        }
        return n.getElement(); 
    }

    public void set(int index, Object element){
        node n = new node();
        if(index >= 0 && index < size){
            n=head;
            for(int i = 0; i< index ; i++){
                n= n.getNext();
            }
            n.setElement(element);
        }
        else{error = true;}
    }

    public void clear(){
       head = null;
    }

    public boolean isEmpty(){
        if(size == 0){return true;}
        else{return false;}
    }

    public void remove(int index){
        node n, temp = new node();
        n = head;
        if(size == 0){error = true;}
        else if(index == 0){
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

    public int size(){return size;}

    public SingleLinkedList sublist(int fromIndex, int toIndex){
        SingleLinkedList li = new SingleLinkedList();
        if(fromIndex > toIndex || fromIndex > size-1 || toIndex > size-1){error = true;}
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

    public boolean contains(Object o){

        while(head != null){
            String b = o.toString();
            String a = head.getElement().toString();
            if(a.equals(b)){return true;}
            head = head.getNext();
        }
        return false;
        
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
       SingleLinkedList list = new SingleLinkedList();
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
    }
}
