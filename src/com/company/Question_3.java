package com.company;

public class Question_3 {
    /**
     *
     * Your quirky boss collects rare, old coins.
     * They found out you're a programmer and asked you to solve something they've been wondering for a long time.
     Write a function that, given an amount of money and an array of coin denominations,
     computes the number of ways to make the amount of money with coins of the available denominations.
     */


    public static void main(String[] args){
        int [] coinArray = {1, 2 , 3};

        changePossibilities(coinArray, 4);

    }

        //method that drives our recursive function, and to find our numbers of coin and assign it to a variable
    public static void changePossibilities(int[] coinDenominations, int coinSum){
        int coinCount = coinDenominations.length;

        //recursive call
        System.out.println(combinationFinder(coinDenominations, coinCount, coinSum));
    }

    private static int combinationFinder(int[] coinDenominations, int coinCount, int coinSum){
        //base cases
        if(coinSum == 0){
            return 1;
        }

        if(coinSum < 0){
            return 0;
        }

        if(coinCount == 0){
            return 0;
        }
        //recursion part which eventually reduces our problem until we reach base case by reducing our coin count
        // which requires us to subtract from our sum by an element in array
        return combinationFinder(coinDenominations, coinCount - 1, coinSum) +
                combinationFinder(coinDenominations, coinCount, coinSum - (coinDenominations[coinCount - 1] ));
    }

}
