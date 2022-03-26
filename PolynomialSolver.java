import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
interface IPolynomialSolver {
    public void setPolynomial(char poly , int[][] terms);
}
public class PolynomialSolver implements IPolynomialSolver{

    SingleLinkedList a = new SingleLinkedList();
    SingleLinkedList b = new SingleLinkedList();
    SingleLinkedList c = new SingleLinkedList();
    SingleLinkedList r = new SingleLinkedList();
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
                    b.add(terms[1][i],terms[0][i]);
                }
            break;
            case 'C':
                for(int i = 0 ; i < len; i++)
                {   
                    c.add(terms[1][i],terms[0][i]);
                }
            break;
            case 'R':
                for(int i = 0 ; i < len; i++)
                {   
                    r.add(terms[1][i],terms[0][i]);
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
            case 'R':
                    n = r;
            break;
        }
        if(n.head == null){return "Error";}
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
                        pol =pol+ "-1x^" + n.head.getExp();
                    }
                    else{pol =pol+ "-1";}
                 }
                 else if(n.head.getCof() == 0){
                    pol =pol+ "" ;
                 }
                 else if(n.head.getCof() > 0){
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

   
    void clearPolynomial(char poly){
        SingleLinkedList n = new SingleLinkedList();
        switch(poly){
            case 'A':  
                    a = null;
            break;
            case 'B':
                    b = null;
            break;
            case 'C':  
                    c = null;
            break;
        }
        System.out.println("[]");

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
        while(n.head != null){
            ans =ans + n.head.getCof()*Math.pow((double)value,(double)n.head.getExp());
            n.head = n.head.getNext();
        }
        return (float)ans;
    }

    int[][] add(char poly1, char poly2){
        SingleLinkedList n1 , n2 , sum = new SingleLinkedList();
        n1 = a;
        n2= a;
        switch(poly1){
            case 'A':  
                    n1 = a;
            break;
            case 'B':
                    n1= b;
            break;
            case 'C':  
                    n1 = c;
            break;
        }

        switch(poly2){
            case 'A':  
                    n2 = a;
            break;
            case 'B':
                    n2= b;
            break;
            case 'C':  
                    n2 = c;
            break;
        }

        
        
        while(n2.size < n1.size){
            n2.addPrevNode(n2.size);
            n2.size++;
        }

        while(n1.size < n2.size){
            n1.addPrevNode(n1.size);
            n1.size++;
        }

        for(int i = 0 ; i < n1.size ; i++){
            int res = n1.head.getCof() + n2.head.getCof();
            sum.add(res, n1.head.getExp());
            n1.head = n1.head.getNext();
            n2.head = n2.head.getNext();
        }
        int[] powers = new int[n1.size];
        int powCounter = n1.size - 1 ;
        for(int i = 0 ; i < n1.size ; i++)  //making array of powers
        {
            powers[i] = powCounter;
            powCounter--;
        }
        int ans[][] = new int [2][n1.size];
        for(int i = 0 ; i < n1.size ; i++){
            ans[1][i] = sum.head.getCof();
            sum.head = sum.head.getNext();
        }
        for(int i = 0 ; i < n1.size ; i++){
            ans[0][i] = powers[i];
        }
        return ans;
    }

    int[][] subtract(char poly1, char poly2){
        SingleLinkedList n1 , n2 , sub = new SingleLinkedList();
        n1 = a;
        n2= a;
        switch(poly1){
            case 'A':  
                    n1 = a;
            break;
            case 'B':
                    n1= b;
            break;
            case 'C':  
                    n1 = c;
            break;
        }

        switch(poly2){
            case 'A':  
                    n2 = a;
            break;
            case 'B':
                    n2= b;
            break;
            case 'C':  
                    n2 = c;
            break;
        }
        while(n2.size < n1.size){
            n2.addPrevNode(n2.size);
            n2.size++;
        }

        while(n1.size < n2.size){
            n1.addPrevNode(n1.size);
            n1.size++;
        }

        for(int i = 0 ; i < n1.size ; i++){
            int res = n1.head.getCof() - n2.head.getCof();
            sub.add(res, n1.head.getExp());
            n1.head = n1.head.getNext();
            n2.head = n2.head.getNext();
        }
        int[] powers = new int[n1.size];
        int powCounter = n1.size - 1 ;
        for(int i = 0 ; i < n1.size ; i++)  //making array of powers
        {
            powers[i] = powCounter;
            powCounter--;
        }
        int ans[][] = new int [2][n1.size];
        for(int i = 0 ; i < n1.size ; i++){
            ans[1][i] = sub.head.getCof();
            sub.head = sub.head.getNext();
        }
        for(int i = 0 ; i < n1.size ; i++){
            ans[0][i] = powers[i];
        }
        return ans;
    }

    int[][] multiply(char poly1, char poly2){
        SingleLinkedList n1 , n2,mul = new SingleLinkedList();
        n1 = a;
        n2= a;
        switch(poly1){
            case 'A':  
                    n1 = a;
            break;
            case 'B':
                    n1= b;
            break;
            case 'C':  
                    n1 = c;
            break;
        }
        switch(poly2){
            case 'A':  
                    n2 = a;
            break;
            case 'B':
                    n2= b;
            break;
            case 'C':  
                    n2 = c;
            break;
        }

        while(n2.size < n1.size){
            n2.addPrevNode(n2.size);
            n2.size++;
        }

        while(n1.size < n2.size){
            n1.addPrevNode(n1.size);
            n1.size++;
        }
        int[] m1 = new int[n1.size];
        int[] m2 = new int[n2.size];

        for(int i =0 ;i < n1.size;i++){
            m1[i] = n1.head.getCof();
            n1.head = n1.head.getNext();
        }

        for(int i =0 ;i < n2.size;i++){
            m2[i] = n2.head.getCof();
            n2.head = n2.head.getNext();
        }

        int max = 0;
        for(int i = 0 ; i < m1.length ; i++){
            for(int j = 0 ; j < m2.length ;j++){
                int res = m1[i] * m2[j];
                int exp = m1.length-1-i + m2.length-1-j;
                if(exp > max){max = exp;}
                mul.add(res, exp);
            }
        }
        int ans[][] = new int [2][mul.size];
        for(int i = 0 ; i < mul.size ; i++){
            ans[1][i] = mul.head.getCof();
            ans[0][i] = mul.head.getExp();
            mul.head = mul.head.getNext();
        }
        int [][] finalAns = new int[2][max+1];
        int count = max;
        while(count <= max && count >=0){
            
            for(int i = 0; i< ans[0].length ;i++){
                if(ans[0][i] == count){
                    finalAns[0][max-count] = count;
                    finalAns[1][max-count] = finalAns[1][max-count] + ans[1][i];
                }
            }
            count--;
        }
        
        return finalAns;

    }


    
public static void main(String[] args) {
    int flag = 0;int tempSize = 0;char poly = 'X';
    //PolynomialSolver a = new PolynomialSolver();
    // PolynomialSolver a = new PolynomialSolver();
    // PolynomialSolver b = new PolynomialSolver();
    // PolynomialSolver c = new PolynomialSolver();
    PolynomialSolver r = new PolynomialSolver();

    Scanner sc = new Scanner(System.in);
    while(sc.hasNextLine())
    {
        String operation = sc.next();
        if( operation.equals("print") || operation.equals("add") || operation.equals("sub") || operation.equals("mult") || operation.equals("set") || operation.equals("eval") || operation.equals("clear"))
        {
        if( operation.equals("set") || operation.equals("print"))
        {    
        poly = sc.next().charAt(0);
        if(poly != 'A')
       {
           if(poly != 'B')
           {
               if(poly != 'C')
               {
                   System.out.print("Error");
                   System.exit(0);
               }
           }
       }}
        if(operation.equals(null))
        {
            System.exit(0);
        }
        
        
       

       
        if(operation.equals("print"))
        {
            
        if(poly == 'A')
        {
        System.out.println(r.print(poly));
        }
        if(poly == 'B')
        {
            System.out.println(r.print(poly));
        }
        if(poly == 'C')
        {
            System.out.println(r.print(poly));
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
            int[][] terms = new int[2][inputs.length];
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
                terms[1][i] = inputs[i]; 
                }
            }
            if(poly == 'C')
            {
                for(int i = 0 ; i < inputs.length ; i++)
            {
            terms[1][i] = inputs[i]; 
            }
            }
            
            for(int i = 0 ; i < inputs.length ; i++)
            {
                terms[0][i] = powers[i];
            }
            //terms[][] contains coefficents + thier powers
            if(poly == 'A')
            {
            r.setPolynomial(poly, terms);
            }
            if(poly == 'B')
            {
                r.setPolynomial(poly, terms);
            }
            if(poly == 'C')
            {
                r.setPolynomial(poly, terms);
            }   
             tempSize = inputs.length;         
        }
        
        if(operation.equals("add"))
        {   char poly1 , poly2;
            //char poly3, poly4;
            int[][] result = new int[2][tempSize];
            poly1 = sc.next().charAt(0);
            poly2 = sc.next().charAt(0);
            result = r.add(poly1, poly2);
            r.setPolynomial('R', result);
            System.out.print(r.print('R'));

        }

        if(operation.equals("sub"))
        {
            char poly1 , poly2;
            int[][] result = new int[2][tempSize];
            poly1 = sc.next().charAt(0);
            poly2 = sc.next().charAt(0);
            result = r.subtract(poly1, poly2);
            r.setPolynomial('R', result);
            System.out.print(r.print('R'));

        }
        
        if(operation.equals("eval"))
        {
            char polyE; float value ; 
            polyE = sc.next().charAt(0);
            value = sc.nextFloat();
            float ans;
            ans = r.evaluatePolynomial(polyE, value);
            System.out.print((int)ans); 
        }
        if(operation.equals("clear"))
        {
            char toClear;
            toClear = sc.next().charAt(0);
            r.clearPolynomial(toClear);
        }
        if(operation.equals("mult"))
        {
            char poly1 , poly2;
            int[][] result = new int[2][tempSize];
            poly1 = sc.next().charAt(0);
            poly2 = sc.next().charAt(0);
            result = r.multiply(poly1, poly2);
            r.setPolynomial('R', result);
            System.out.print(r.print('R'));

        }
        //sc.close();
        }
            else{
                System.out.print("Error");
                System.exit(0);
            }
        }
    }}

   
    





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

    public void addPrevNode(int size)
    {
        node tempNode = new node();
        tempNode.setCof(0);
        tempNode.setExp(size);
        tempNode.setNext(head);
        head = tempNode;

    }
    

}
