package DynamicProgramming;

public class Knapsack01 {
    public static void main(String args[]){
        int[] wt={2,3,4,5};
        int[] val={5,1,8,4};
        int bag_wt=5;
        System.out.println(knapsack(wt,val,bag_wt));

    }
    static int knapsack(int[] weights, int[] values,int maxW){
        return knapsack(weights,values,maxW,0);
    }

    private static  int knapsack(int[] weights, int[] values, int maxW, int i) {

        //if we reached end of given values or our bag is full
        if(i==weights.length || maxW==0) return 0;

        //if the weight of item is greater than bag leave item go to next item
        if(weights[i]>maxW){
            return knapsack(weights, values, maxW, i+1);
        }

        /*else we have two options
        * 1. select the item
        * 2. leave item
        * we calculate both and return the max of both*/
        else {
            int op1 = values[i] + knapsack(weights,values,maxW -weights[i],i+1);        //taking this value

            int op2 = knapsack(weights,values,maxW,i+1);                                      //not taking the value

            return Math.max(op1,op2);
        }
    }
}
