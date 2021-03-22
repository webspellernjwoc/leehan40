/*
 * Kevin Leehan
 * CS549
 * HW1
 * Perceptron Model
 */

package cs549hw1;
import java.util.Arrays; //Used to compare Actual and Target outputs

public class Perceptron {
    private double weight1, weight2, coeff, threshold;
    private String operator;
    
    private final int[] input1 = {0,0,1,1}; 
    private final int[] input2 = {0,1,0,1};
    
    //Sets the initial variables and prints them to screen
    //Then starts the calculation
    public void parameters(double a, double b, double c, double d, String e){
        weight1=a;
        weight2=b;
        coeff=c;
        threshold=d;
        operator=e;
        System.out.println("Intial Weights: "+a+" and "+b+"\n"+
                           "Learning Coefficient: "+c+"\n"+
                           "Threshold: "+d+"\n"+
                           "Logic Operator: "+e);
        calculation(input1, input2);
    }
    private void calculation(int input1[], int input2[]){
        int[] target = new int[input1.length];//Initialize target outputs
        int[] actual = new int[target.length];//Initialize actual outputs
        
        //Calls setLogic for calculation and subsquently sets target outputs
        //determined by the string in parameters method
        setLogic(operator, input1, input2, target);
        int epoch = 1; //counter
        //Increases the weights until the target and actual outputs are equal
        while(!Arrays.equals(actual, target)){
            //Prints out what epoch the loop is currently on
            System.out.println("--------------------------- epoch "+epoch+" ---------");
            //Header for the output, printed by the function printWeights
            System.out.println("Input1 | Input2 | Target | Actual | Weights");
            epoch++;
            
            for(int i=0; i<target.length; i++){
                double sum = (weight1*(double)input1[i])+(weight2*(double)input2[i]);
                //Assigns 1 to actual output if theshold is met
                if(sum >= threshold)
                    actual[i]=1;
                //Updates weight values
                weight1=weight1+(coeff*(target[i]-actual[i])*(double)input1[i]);
                weight2=weight2+(coeff*(target[i]-actual[i])*(double)input2[i]);
            //Prints the epoch weights
            printEpoch(input1,input2, weight1, weight2, target, actual, i);              
            }
        //Bottom border of each epoch
        System.out.println("---------------------------------------------");
        }
    }
        
    //Sets the logic operator and target outputs.
    //Able to be expanded to use other operators.
    private void setLogic(String a, int in1[], int in2[], int t[]){
        if("AND".equals(a)||
                "And".equals(a)|| 
                "and".equals(a)|| 
                "&&".equals(a))
            for(int i=0; i<in1.length; i++)
                if(in1[i]==1 && in2[i]==1) //AND is true
                    t[i] = 1;
        if("OR".equals(a)||
                "Or".equals(a)||
                "or".equals(a)||
                "||".equals(a))
            for(int i=0; i<in1.length; i++)
                if(in1[i]!=0 || in2[i]!=0) //OR is true
                    t[i] = 1;
    }
        
    //Prints out the Input1, Input2, Target, Actual, and Weights 
    //in an easy to read table format
    private void printEpoch(int input1[], int input2[], double weight1, double weight2, int target[], int actual[], int i){
        System.out.println("  "+input1[i]+"    |   "+ input2[i]+"    |   "+target[i]+"    |   "+actual[i]+"    |  "+weight1+", "+weight2);
    }
}
