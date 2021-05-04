package com.bayareala8s;

import java.util.*;


public class Main {

    public static void main(String[] args) {

        //Reverse a string
        String original = "my dog ran";
        System.out.println(reverseString(original));

        //Check if string is a palindrome
        String palindrome = "madam";
        System.out.println("is palindrome: " + isPalindrome(palindrome));

        //Match substring from original string
        String s1 = "sanfrancisco";
        String s2 = "cisco";
        System.out.println("is sub string match: " + isSubStringMatch(s1, s2));

        //Check if string is unique
        String s3 = "madam";
        System.out.println("is unique: " + isUnique(s3));

        //Check 2 strings are Permutation of each other
        String s4 = "dog";
        String s5 = "god";
        System.out.println("is Anagrams: " + permutation(s4,s5));

        //Remove duplicates from String
        String s6 = "madam";
        System.out.println("Remove duplicates " + removeDuplicates(s6));

        //Remove vowels from String
        String s7 = "madam";
        System.out.println("Remove vowels " + removeVowels(s7));

        //Remove duplicates from sorted array
        int[] num = {1,1,1,1,22,24,24,25,30,30};
        System.out.println("Length of array after removing duplicates from sorted array " + removeDuplicatesFromSortedArray(num));

        //Get duplicate character count
        String s8 = "madam";
        System.out.println("Repeated character count " + getDuplicateCharacters(s8));

        //Compress string
        String s9 = "aabcccccaaa";
        System.out.println("Compressed string count " + compress(s9));

        //Check is string has valid number of closing and opening parenthesis
        String s10 = "[{()}]]]";
        System.out.println(isValidParenthesis("String has valid parenthesis " + isValidParenthesis(s10)));

        //Check if array is sorted
        int[] a = {10,20,30,50,100};
        System.out.println("is array sorted " + isArraySorted(a,a.length));

        //Print FizzBuzz from 1 to n
        int n = 15;
        System.out.println(FizzBuzz(n));

        //Remove adjacent duplicates from a string
        String s11 = "mississippi";
        System.out.println("String after removing adjacent duplicates " + removeAdjacentDuplicates(s11));

    }

    //Reverse a string
    public static String reverseString(String str) {


        StringBuffer buffer = new StringBuffer();
        for(int i = str.length() - 1; i >=0 ; i-- ) {
            buffer.append(str.charAt(i));
        }

        return buffer.toString();
    }

    //Check if string is a palindrome
    public static boolean isPalindrome(String str) {
        int head = 0;
        int tail = str.length() - 1;
        while(head < tail) {

            if(str.charAt(head) != str.charAt(tail))
                return false;

            head++;
            tail--;
        }
        return true;
    }

    //Match substring from original string
    public static boolean isSubStringMatch(String s1, String s2) {
        int i = 0;
        int j = 0;
        for (i = 0; i < s1.length(); ++i) {
            for (j = 0; j < s2.length(); ++j) {
                if(i < s1.length()) {
                    if (s1.charAt(i) != s2.charAt(j)) {
                        break;
                    }
                    i++;
                }
                else
                    return false;
            }
            if (j == s2.length()) {
                return true;
            }
        }
        return false;
    }

    //Check if string is unique
    public static boolean isUnique(String str) {
        if(str.length() > 128)
            return false;

        boolean[] char_set = new boolean[128];
        for(int i = 0; i < str.length(); i++) {
            int pos = str.charAt(i); //get ascii position of character
            if (char_set[pos])
                return false;
            char_set[pos] = true;
        }
        return true;
    }

    //Check 2 strings are Permutation of each other
    public static boolean permutation(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        return sort(s).equals(sort(t));
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        java.util.Arrays.sort(content);
        return new String(content);
    }

    //Remove duplicates from String
    public static String removeDuplicates(String words) {
        char[] characters = words.toCharArray();
        HashSet<Character> characterSet = new HashSet<Character>();

        for(char ch: characters) {
            if(!characterSet.add(ch))
                continue;
        }
        return characterSet.toString();
    }

    //Remove vowels from String
    public static String removeVowels(String s) {
        char[] characters = s.toCharArray();
        StringBuffer bf = new StringBuffer();

        for(char c: characters) {
            switch(c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    continue;
            }
            bf.append(c);
        }
        return bf.toString();
    }

    //Remove duplicates from sorted array
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if(nums.length == 0)
            return 0;

        int i = 0;
        for(int j = 1; j < nums.length;j++) {
            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    //Get duplicate character count
    public static HashMap<Character,Integer> getDuplicateCharacters(String word) {
        char[] characters = word.toCharArray();
        HashMap<Character, Integer> characterMap = new HashMap<Character, Integer>();

        for(char ch: characters) {
            if(characterMap.containsKey(ch)) {
                characterMap.put(ch, characterMap.get(ch) + 1);
            }
            else {
                characterMap.put(ch,1);
            }
        }
        return characterMap;
    }

    //Compress string
    public static String compress(String input) {
        char[] characters = input.toCharArray();
        int countConsecutive = 0;
        StringBuffer sb = new StringBuffer();

        for(int i = 0; i < characters.length;i++) {
            countConsecutive++;
            if(i + 1 >= characters.length || characters[i] != characters[i + 1]) {
                sb.append(characters[i]); //character
                sb.append(countConsecutive); //countConsecutive
                countConsecutive = 0;
            }
        }

        return sb.length() <= characters.length ? sb.toString() : input;
    }

    //Check is string has valid number of closing and opening parenthesis
    public static boolean isValidParenthesis(String s) {
        if(s.length() % 2 != 0)
            return false;

        HashMap<Character,Character> parenthesisMap = new HashMap<Character, Character>();
        parenthesisMap.put('(',')');
        parenthesisMap.put('[',']');
        parenthesisMap.put('{','}');

        Stack<Character> stack = new Stack<Character>();

        for(char c: s.toCharArray()) {
            if(parenthesisMap.keySet().contains(c)) {
                stack.push(c); //opening braces goes on stack
            }
            else if(parenthesisMap.values().contains(c)) { //closing braces pop from stack
                if(!stack.empty() && parenthesisMap.get(stack.peek()) == c) {
                    stack.pop();
                }
                else
                    return false;

            }
        }
        return stack.isEmpty(); //returns true once all the elements are pop
    }

    //Check if array is sorted
    public static boolean isArraySorted(int[] a, int size) {
        if((size == 0) || (size == 1))
            return true; //base case

        if(a[0] > a[1])
            return false;

        return isArraySorted(Arrays.copyOfRange(a,1,size),size - 1);
    }

    //Print FizzBuzz from 1 to n
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

    //Merge sorted arrays
    public static  void merge(int[] a, int[] b, int lastA, int lastB) {
        int indexA = lastA - 1;//index of last element in a
        int indexB = lastB - 1;//index of last element in b

        int indexMerged = lastB + lastA - 1; //End of merged array

        //Merge a & b starting from last element in each
        while(indexB >= 0) {
            //end of a is > than end of b
            if(indexA >= 0 && a[indexA] > b[indexB]) {
                a[indexMerged] = a[indexA]; //copy element
                indexA--;
            }
            else {
                a[indexMerged] = b[indexB]; //copy element
                indexB--;
            }
            indexMerged--; //move indices
        }
    }

    //Delete middle node from linked list
    public boolean deleteNode(Node n) {
        if(n == null || n.next == null) {
            return false; //Failure
        }
        Node next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }

    //Remove duplicates from an unsorted linked list
    public void RemoveDuplicate(Node n) {
        HashSet<Integer> set = new HashSet<>();
        Node previous = null;
        while(n != null) {
            if(set.contains(n.data)) {
                previous.next = n.next; // remove node
            }
            else {
                set.add(n.data);
                previous = n;
            }
            n = n.next;
        }
    }


 }

 class Node {
    int data;
    Node next;
 }
