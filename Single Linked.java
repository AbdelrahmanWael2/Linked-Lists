public class SingleLinkedList{
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
    
    public SingleLinkedList() {
        head = null;
        size = 0;
    }
    
    public void add(int index, Object element){
        node n = new node(element, null);
        node temp = new node();
        node temp2 = new node();
        temp = head;
        if(index == 0){
            n.setNext(head);
            head=n;
            size++;
        }

        if(index == size){
            add(element);
        }
        else if(index < size){
            
            for(int i = 0 ; i < index-1 ; i++){
                temp = temp.getNext();    
            }
            temp2 = temp;
            temp2 = temp2.getNext();
            temp.setNext(n);
            n.setNext(temp2);
            size++;
        }
        else{System.out.println("Error");}
        
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
        if(index > size-1 || index < 0){System.out.println("Error");}
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
        n=head;
        for(int i = 0; i< index ; i++){
            n= n.getNext();
        }
        n.setElement(element);

    }

    public void clear(){
        head.setElement(null);
        head.setNext(null);
    }

    public int size(){return size;}

    public boolean isEmpty(){
        if(size == 0){return true;}
        else{return false;}
    }
    
    public void display(){
        node n = new node();
        n = head;
        while(n!=null){
            System.out.println(n.getElement());
            n = n.getNext();
        }
    }

    public boolean contains(Object o){
        node n = new node();
        n = head;
        boolean found = false;
        while(!found && n.getNext() != null){
            if(n.getElement() == o){found = true;}
            n = n.getNext();
        }
        return found;
    }
        
    
    public static void main(String[] args){
        SingleLinkedList li = new SingleLinkedList();
        
    


       Scanner sc = new Scanner(System.in);
       String input = sc.nextLine().replaceAll("\[|\]", "");
       String[] s = input.split(", ");
       int[] inputs = new int[s.length];   //array of input integers
       for(int i = 0; i < s.length; ++i)
       {
            inputs[i] = Integer.parseInt(s[i]);
       }
       SingleLinkedList list = new SingleLinkedList();
        for( int i = 0; i < s.length ; i++)
        {
            list.add(inputs[i]);
        }
        

    }



}
