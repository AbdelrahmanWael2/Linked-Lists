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
    public void setPolynomial(char poly, int[][] terms){
        
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}
