package com.bayareala8s;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        int n = 15;
        System.out.println(FizzBuzz(n));

        String s1 = "mississippi";
        System.out.println(removeAdjacentDuplicates(s1));

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

    public static String removeAdjacentDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for(char c: s.toCharArray()) {
            if(stack.empty() || c != stack.peek())
                stack.push(c);
            else
                stack.pop();
        }
        StringBuffer sb = new StringBuffer();
        while(!stack.empty()) {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.reverse().toString();
    }
 }
