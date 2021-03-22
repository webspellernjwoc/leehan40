/*
 * Kevin Leehan
 * CS549
 * HW1
 * Perceptron Model

 * This Hw is meant to simulate the Perceptron Model
 * This class contains the main and calls the Perceptron.parameters method
 * parameters method inputs are as follows:
 * Initial Weight1, Initial Weight2, 
 * Learning Coefficient, Threshold, Logic Operator
*/
package cs549hw1;
public class Cs549Hw1 {
    
    public static void main(String[] args) {        
        //Name and class information for the output page
        System.out.println("Kevin Leehan\nCS549\nHW1\nThe Perceptron Model");
        
        Perceptron perceptron = new Perceptron();        
        System.out.println("\n----- Problem 2-1 ---------------------------");
        perceptron.parameters(0.4, 0.8, 0.5, 2.0, "AND");
                
        System.out.println("\n\n----- Problem 2-2 ---------------------------");
        perceptron.parameters(0.1, 0.5, 0.5, 2.0, "OR");
    }
}