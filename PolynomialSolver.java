import java.util.Scanner;

public class PolynomialSolver {
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
    public PolynomialSolver() {
        head = null;
        size = 0;
    } 

    public void setPolynomial(char poly, int[][] terms, int length)
    {
        PolynomialSolver list = new PolynomialSolver();
        node pointer = new node();
        
        pointer = head;
        for(int i = 0 ; i < len ; i++)
        {
          System.out.print("Hello ahmed");

        }

        
       
    }
    

    public static void set(){
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        char poly = sc.next().charAt(0);
        String coof = sc.nextLine();
    }
    


    public static void main(String[] args) {
        set();
        Scanner sc = new Scanner(System.in);
        String operation2 = sc.nextLine();
        if(operation2.equals("set")){
            set();
        }
        else if(operation2.equals("print")){

        }
    
    }
}
