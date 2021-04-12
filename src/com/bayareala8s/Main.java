package com.bayareala8s;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        int n = 15;
        System.out.println(FizzBuzz(n));
    }

    public static ArrayList<String> FizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<>();

        for(int i = 1; i<=n; i++){
            if(i % 3 == 0 && i % 5 == 0)
                result.add("FizzBuzz");
            else if (i % 3 == 0)
                result.add("Fizz");
            else if (i % 5 == 0)
                result.add("Buzz");
            else
                result.add(String.valueOf(i));
        }
        return result;
    }
 }
