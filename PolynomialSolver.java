import java.util.Scanner;
import java.math.*;
interface IPolynomialSolver {
    public void setPolynomial(char poly , int[][] terms);
}
public class PolynomialSolver implements IPolynomialSolver{

    SingleLinkedList a = new SingleLinkedList();
    SingleLinkedList b = new SingleLinkedList();
    SingleLinkedList c = new SingleLinkedList();
    public void setPolynomial(char poly, int[][] terms)
    {   
        int len = terms[0].length;
        switch(poly){
            case 'A':
                for(int i = 0 ; i < len; i++)
                {   
                    a.add(terms[1][i],terms[0][i]);
                }
            break;
            case 'B':
                for(int i = 0 ; i < len; i++)
                {   
                    b.add(terms[2][i],terms[0][i]);
                }
            break;
            case 'C':
                for(int i = 0 ; i < len; i++)
                {   
                    c.add(terms[3][i],terms[0][i]);
                }
            break;
        }
        
    }

    public String print(char poly){
        String pol;
        SingleLinkedList n = new SingleLinkedList();
        switch(poly){
            case 'A':  
                    n = a;
            break;
            case 'B':
                    n = b;
            break;
            case 'C':  
                    n = c;
            break;
        }
        if(n == null){return "[]";}
        else{
            if(n.head.getCof() == 1){
                if(n.head.getExp() != 0){
                    pol = "x^" + n.head.getExp();
                }
                else{pol = "1";}
             }
             else if(n.head.getCof() == -1){
                if(n.head.getExp() != 0){
                    pol = "-x^" + n.head.getExp();
                }
                else{pol = "-1";}
             }
             else if(n.head.getCof() == 0){
                pol = "" ;
             }
             else if(n.head.getExp() == 0){
                 pol = Integer.toString(n.head.getCof());
             }
             else if(n.head.getExp() == 1){
                 pol =  n.head.getCof() + "x";
             }
            //  else if(n.head.getExp() == n.size){
            //     pol = n.head.getCof() + ;
            //  }
             else{
                 pol = n.head.getCof() + "x^" + n.head.getExp();
             }
             n.head= n.head.getNext();
             while(n.head != null){
                if(n.head.getCof() == 1){
                    if(n.head.getExp() != 0){
                        pol = pol+"+x^" + n.head.getExp();
                    }
                    else{pol =pol+ "1";}
                 }
                 else if(n.head.getCof() == -1){
                    if(n.head.getExp() != 0){
                        pol =pol+ "-x^" + n.head.getExp();
                    }
                    else{pol =pol+ "-1";}
                 }
                 else if(n.head.getCof() == 0){
                    pol =pol+ "" ;
                 }
                 if(n.head.getCof() > 0){
                    if(n.head.getExp() == 0){
                        pol = pol + "+" + n.head.getCof();
                    }
                    else if(n.head.getExp() == 1){
                        pol = pol+ "+" +  n.head.getCof() + "x";
                    }
                     else{
                         pol = pol+"+"+n.head.getCof() + "x^" + n.head.getExp();
                     }
                 }
                 else{
                    if(n.head.getExp() == 0){
                        pol = pol  + n.head.getCof();
                    }
                    else if(n.head.getExp() == 1){
                        pol = pol+  n.head.getCof() + "x";
                    }
                     else{
                         pol = pol+n.head.getCof() + "x^" + n.head.getExp();
                     }
                 }
                 
                 n.head= n.head.getNext();
                 
             } 
        }
        return pol;
    }

   

    public float evaluatePolynomial(char poly, float value){

        double ans = 0;
        SingleLinkedList n = new SingleLinkedList();
        switch(poly){
            case 'A':  
                    n = a;
            break;
            case 'B':
                    n = b;
            break;
            case 'C':  
                    n = c;
            break;
        }
        while(n != null){
            ans =ans + n.head.getCof()*Math.pow((double)value,(double)n.head.getExp());
        }
        return (float)ans;
    }

    // int[][] add(char poly1, char poly2){
    //     node n1 , n2 = new node();
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
            String operation = sc.next();
            if(operation.equals(null))
            {
                System.exit(0);
            }
            char poly = sc.next().charAt(0);

            
            
            if(operation.equals("print"))
            {
            if(poly == 'A')
            {
            System.out.println(a.print(poly));
            }
            if(poly == 'B')
            {
                System.out.println(b.print(poly));
            }
            if(poly == 'C')
            {
                System.out.println(c.print(poly));
            }
            }
            if(operation.equals("set"))
            {
                String input = sc.next().replaceAll("\\[|\\]", "");
                String[] in = input.split(",");
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
   
    





class SingleLinkedList {
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

    public node head;
    public int size;
    public static boolean error = false;
    public SingleLinkedList() {
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
}
