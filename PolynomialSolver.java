import java.util.Scanner;
import java.math.*;
interface IPolynomialSolver {
    public void setPolynomial(char poly , int[][] terms);
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
    //PolynomialSolver a = new PolynomialSolver();
    //public static PolynomialSolver a ;
    //public static PolynomialSolver b ;
    //public static PolynomialSolver c ;
    //PolynomialSolver b = new PolynomialSolver();
    //PolynomialSolver c = new PolynomialSolver();

    public void add(int cof , int exp){
        node n = new node(cof,exp,null);
        node temp = new node();
        temp = this.head;
        if(size == 0){
            this.head = n;
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

    public void setPolynomial(char poly, int[][] terms)
    {   
        int len = terms[0].length;
        switch(poly){
            case 'A':
                for(int i = 0 ; i < len; i++)
                {   
                    add(terms[1][i],terms[0][i]);
                }
            break;
            case 'B':
                for(int i = 0 ; i < len; i++)
                {   
                    add(terms[2][i],terms[0][i]);
                }
            break;
            case 'C':
                for(int i = 0 ; i < len; i++)
                {   
                    add(terms[3][i],terms[0][i]);
                }
            break;
        }
        
    }

    public String print(char poly){
        String pol;
        node n = new node();
        n = head;
        // switch(poly){
        //     case 'A':
        //         n = a.head;
        //     break;
        //     case 'B':
        //         n = b.head;
        //     break;
        //     case 'C':
        //         n = c.head;
        //     break;
        // }
        if(n == null){return "[]";}
        else{
        pol = n.getCof() + "x^" + n.getExp();
        n = n.getNext();
        while(n != null){
                if(n.getCof() >= 0){
                    pol=pol+ "+" + n.getCof();
                    if(n.getExp() == 1){pol=pol+"x";}
                    if(n.getExp() != 1 && n.getExp() != 0){pol = pol + "x^" +n.getExp();}
                    n = n.getNext();
                }
                else{
                    pol=pol + n.getCof();
                    if(n.getExp() == 1){pol = pol + "x";}
                    if(n.getExp() != 1 && n.getExp() != 0){pol = pol + "x^" + n.getExp();}
                    n = n.getNext();
                } 
            }
            return pol;
        }
    }

    public void clearPolynomial(char poly){
        this.head = null;
        // switch(poly){
        //     case 'A':
        //         a.head = null;
        //     break;
        //     case 'B':
        //         b.head = null;
        //     break;
        //     case 'C':
        //         c.head = null;
        //     break;
        // }
    }

    public float evaluatePolynomial(char poly, float value){

        double ans = 0;
        node n = new node();
        n = this.head;
        // switch(poly){
        //     case 'A':
        //         n = a.head;
        //     break;
        //     case 'B':
        //         n = b.head;
        //     break;
        //     case 'C':
        //         n = c.head;
        //     break;
        // }
        while(n != null){
            ans =ans + n.getCof()*Math.pow((double)value,(double)n.getExp());
        }
        return (float)ans;
    }

    // int[][] add(char poly1, char poly2){
    //     node n1 , n2 = new node();
    //     switch(poly1){
    //         case 'A':
    //             n1 = a.head;
    //         break;
    //         case 'B':
    //             n1 = b.head;
    //         break;
    //         case 'C':
    //             n1 = c.head;
    //         break;
    //     }
    //     switch(poly2){
    //         case 'A':
    //             n2 = a.head;
    //         break;
    //         case 'B':
    //             n2 = b.head;
    //         break;
    //         case 'C':
    //             n2 = c.head;
    //         break;
    //     }
    //     int[][] ans = new int[][];
    // }
    

   
    


public static void main(String[] args) {
        int flag = 0;
        //PolynomialSolver a = new PolynomialSolver();
        PolynomialSolver a = new PolynomialSolver();
        PolynomialSolver b = new PolynomialSolver();
        PolynomialSolver c = new PolynomialSolver();
        Scanner sc = new Scanner(System.in);
        while(flag == 0)
        {
            String operation = sc.nextLine();
            if(operation == null)
            {
                System.exit(0);
            }
            char poly = sc.nextLine().charAt(0);

            if(operation.equals("print"))
            {
            if(poly == 'A')
            {
            System.out.print(a.print(poly));
            }
            if(poly == 'B')
            {
                System.out.print(b.print(poly));
            }
            if(poly == 'C')
            {
                System.out.print(c.print(poly));
            }
            }
            if(operation.equals("set"))
            {
                String input = sc.nextLine().replaceAll("\\[|\\]", "");
                String[] in = input.split(", ");
                int[] inputs = new int[in.length];
                if(in.length == 1 && in[0].isEmpty())
                {
                    System.out.print("Error");
                    System.exit(0);
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
                int[][] terms = new int[4][inputs.length];
                if(poly == 'A')
                {
                for(int i = 0 ; i < inputs.length ; i++)
                {
                terms[1][i] = inputs[i]; 
                }
                }
                if(poly == 'B')
                {
                    for(int i = 0 ; i < inputs.length ; i++)
                    {
                    terms[2][i] = inputs[i]; 
                    }
                }
                if(poly == 'C')
                {
                    for(int i = 0 ; i < inputs.length ; i++)
                {
                terms[3][i] = inputs[i]; 
                }
                }
                
                for(int i = 0 ; i < inputs.length ; i++)
                {
                    terms[0][i] = powers[i];
                }
                //terms[][] contains coefficents + thier powers
                if(poly == 'A')
                {
                a.setPolynomial(poly, terms);
                }
                if(poly == 'B')
                {
                    b.setPolynomial(poly, terms);
                }
                if(poly == 'C')
                {
                    c.setPolynomial(poly, terms);
                }           
            }        //sc.close();
        }
    }  
   
}
