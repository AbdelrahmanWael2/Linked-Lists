import java.util.Scanner;


interface IPolynomialSolver {
    public void setPolynomial(char poly , int[][] terms, int len);
}
public class PolynomialSolver implements IPolynomialSolver{
    class node {
        private int cof;
        private int exp;
        private node next;
        
        public node (){
            this.cof=0;
            this.exp=0;
            this.next=null;
        }
    
        public node(int cof, int exp, node next) {
            this.cof = cof;
            this.exp = exp;
            this.next = next;
        }
        
        
        public void setNext(node nextNode){
            this.next = nextNode;
        }
        
        
        public void setCof(int cof){
            this.cof = cof;
        }

        public void setExp(int exp){
            this.exp=exp;
        }
        
        public int getCof(){
         return this.cof;
        } 

        public int getExp(){
            return this.exp;
        }
        
        public node getNext(){
         return this.next;
        } 
    }

    private node head;
    public static int size;
    public static boolean error = false;
    public PolynomialSolver() {
        head = null;
        size = 0;
    } 


    public void add(int cof , int exp){
        node n = new node(cof,exp,null);
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

    public void setPolynomial(char poly, int[][] terms, int len )
    {   
        for(int i = 0 ; i < len; i++ )
        {   
            this.add(terms[0][i],terms[1][i]);
        }
    }
    public void display(){
        System.out.print("[");
        node n = new node();
        n = head;
        while(n!=null){
            System.out.print(n.getCof()+" "+n.getExp());
            if(n.getNext() != null){System.out.print(", ");}
            n = n.getNext();
        }
        System.out.print("]");
    }
    

   
    


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        char poly = sc.nextLine().charAt(0);

       // if(operation == "set")
        {
        String input = sc.nextLine().replaceAll("\\[|\\]", "");
        String[] in = input.split(", ");
        int[] inputs = new int[in.length];
        if(in.length == 1 && in[0].isEmpty())
        {
            inputs = new int[]{};
        }
        else{
         for(int i = 0; i < in.length; i++)
             {
                inputs[i] = Integer.parseInt(in[i]);   //inputs contains coefficients
             }
            }
        int[] powers = new int[inputs.length];
        int powCounter = inputs.length - 1 ;
        for(int i = 0 ; i < inputs.length ; i++)  //making array of powers
        {
          powers[i] = powCounter;
          powCounter--;
        }
        int[][] terms = new int[2][inputs.length];
       
        for(int i = 0 ; i < inputs.length ; i++)
        {
          terms[0][i] = inputs[i]; 
        }
        for(int i = 0 ; i < inputs.length ; i++)
        {
            terms[1][i] = powers[i];
        }
        //terms[][] contains coefficents + thier powers
        PolynomialSolver linked = new PolynomialSolver();
        
        linked.setPolynomial(poly, terms, inputs.length); //set the linkedlist
        linked.display();
        }



    }  
    
    
}
