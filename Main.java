package eg.edu.alexu.csd.datastructure.linkedList.cs;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Main {
   public static char checkScan(char poly,boolean print) {
 
      Scanner sc = new Scanner(System.in);
      try {
         String str = sc.next();
         poly = str.charAt(0);
         if(print==false) {
         if (!(poly == 'A' || poly == 'B' || poly == 'C')) {
            throw new RuntimeException();
         }
         }
         else if(print==true)
         {
        	 if (!(poly == 'A' || poly == 'B' || poly == 'C' || poly=='R'))
        		 throw new RuntimeException();
         }
 
      } catch (RuntimeException e) {
         System.out.println("Invalid Input");
         return 0;
 
      }
      return poly;
   }
 
   public static void main(String[] args) throws NullPointerException {
 
      PolynomialSolver P = new PolynomialSolver();
      SinglyLinkedList list = new SinglyLinkedList();
      char poly1 = ' ';
      char poly2 = ' ';
      char valid = ' ';
 
      do { 
 
         System.out.println("Please choose an action");
         System.out.println("-----------------------");
         System.out.println("1- Set a polynomial variable");
         System.out.println("2- Print the value of a polynomial variable");
         System.out.println("3- Add two polynomials");
         System.out.println("4- Subtract two polynomials");
         System.out.println("5- Multiply two polynomials");
         System.out.println("6- Evaluate a polynomial at some point");
         System.out.println("7- Clear a polynomial variable");
         System.out.println("0- Exit the program");
         System.out.println("====================================================================");
         Scanner sc = new Scanner(System.in);
         int x;
         try {
          x = sc.nextInt();
         if(x<0 || x>7)
           throw new IllegalArgumentException("Invalid Operation");
 
         }
         catch(IllegalArgumentException e) {
        	continue;
 
         }
         catch(InputMismatchException e)
         {
        	 continue;
         }
 
         switch (x) {
            case 1:
               System.out.println("Insert the variable name: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else poly1 = valid;
               System.out.println("Insert the polynomial terms in the form:(coeff1,exponent1),(coeff2,exponent2),..");
               String polyTerms = sc.next();
               int count = 0;
 
               for (int i = 0; i<polyTerms.length(); i++) {
                  if (polyTerms.charAt(i) == '(')
                     count++;
               }
 
               polyTerms = polyTerms.replace("(", "");
               polyTerms = polyTerms.replace(")", "");
 
               int[][] term = new int[count][2];
               String[] st = polyTerms.split(",");
               try {
                  int k = 0;
                  for (int i = 0; i<st.length; i++) {
                     for (int j = 0; j<2; j++) {
                        if (k<st.length) {
                           term[i][j] = Integer.parseInt(st[k]);
                           k++;
                        }
                     }
                  }
               } catch (NumberFormatException e) {
                  System.out.println("Invalid input");
                  continue;
               } catch (ArrayIndexOutOfBoundsException e) {
                  System.out.println("Invalid input");
                  continue;
               }
 
               int[][] terms = new int[count][2];
 
               for (int i = 0; i<count; i++) {
                  for (int j = 0; j<2; j++) {
                     terms[i][j] = term[i][j];
 
                  }
               }
 
               P.setPolynomial(poly1, terms);
               System.out.println("Polynomial " + poly1 + " is set");
               break;
 
            case 2:
               System.out.println("Insert the variable name: A, B C or R");
               valid = checkScan(poly1,true);
               if (valid == 0)
                  continue;
               else poly1 = valid;
               System.out.println(P.print(poly1));
               break;
 
            case 3:
               System.out.println("Insert the variable name of first polynomial: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else poly1 = valid;
               list = P.chooseList(poly1);
               if (list.isEmpty()) {
                  System.out.println("Variable not set");
                  continue;
               }
               System.out.println("Insert the variable name of second polynomial: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else poly2 = valid;
               list = P.chooseList(poly1);
               if (list.isEmpty()) {
                  System.out.println("Variable not set");
                  continue;
               }
               int[][] sum = P.add(poly1, poly2);
               System.out.println("Result set in R:");
               System.out.println(Arrays.deepToString(sum));
               P.R.clear();
 
               break;
            case 4:
               System.out.println("Insert the variable name of first polynomial: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else
                  poly1 = valid;
               list = P.chooseList(poly1);
               System.out.println(list.size);
               if (list.isEmpty()) {
                  System.out.println("Variable Not Set");
                  continue;
               }
               System.out.println("Insert the variable name of second polynomial: A, B or C");
               valid = checkScan(poly2,false);
               if (valid == 0)
                  continue;
               else
                  poly2 = valid;
               list = P.chooseList(poly1);
               if (list.isEmpty()) {
                  System.out.println("Variable Not Set");
                  continue;
               }
               int[][] result = P.subtract(poly1, poly2);
               System.out.println("Result set in R:");
               System.out.println(Arrays.deepToString(result));
               P.R.clear();
               break;
 
            case 5:
               System.out.println("Insert the variable name of first polynomial: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else poly1 = valid;
               list = P.chooseList(poly1);
               if (list.isEmpty()) {
                  System.out.println("Variable not set");
                  continue;
               }
               System.out.println("Insert the variable name of second polynomial: A, B or C");
               valid = checkScan(poly2,false);
               if (valid == 0)
                  continue;
               else poly2 = valid;
               list = P.chooseList(poly2);
               if (list.isEmpty()) {
                  System.out.println("Variable not set");
                  continue;
               }
               int[][] product = P.multiply(poly1, poly2);
               System.out.println("Result set in R:");
               System.out.println(Arrays.deepToString(product));
               P.R.clear();
               break;
 
            case 6:
               System.out.println("Insert the variable name: A, B or C");
               valid = checkScan(poly1,false);
               if (valid == 0)
                  continue;
               else poly1 = valid;
               list = P.chooseList(poly1);
               if (list.isEmpty()) {
                  System.out.println("Variable not set");
                  continue;
               }
               System.out.println("Insert value:");
               float value = sc.nextFloat();
               System.out.print(P.evaluatePolynomial(poly1, value) + "\n");
               break;
 
            case 7:
               System.out.println("Choose variable to remove");
               valid = checkScan(poly1,false);
 
               if (valid == 0)
                  continue;
               else
                  P.clearPolynomial(poly1);
               break;
 
            case 0:
               System.exit(0);
               break;
         }
 
      }
 
      while (true);
 
   }
 
}        	 
         	 