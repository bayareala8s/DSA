package com.bayareala8s;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //Reverse a string
        String original = "my dog ran";
        System.out.println(reverseString(original));

        //Reverse a string in-place
        String s = "my dog ran";
        char[] charArray = s.toCharArray();
        reverseStringInPlace(charArray);
        System.out.println(charArray);

        //Check if string is a palindrome
        String palindrome = "madam";
        System.out.println("is palindrome: " + isPalindrome(palindrome));

        //Rotate Array
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println("Array after rotation");
        for (int element: nums) {
            System.out.print(element + " ");
        }

        //Print FizzBuzz from 1 to n
        int n = 15;
        System.out.println(FizzBuzz(n));

        //Check if array is sorted
        int[] a = {10,20,30,50,100};
        System.out.println("is array sorted " + isArraySorted(a,a.length));

        //Binary Search
        int[] sortedArray = {3,5,10,17,20};
        int pos = BinarySearch(sortedArray,20);
        if( pos == -1)
            System.out.println("Number not found");
        else
            System.out.println("Number found at: " + pos);

        //Remove vowels from String
        String s7 = "madam";
        System.out.println("Remove vowels " + removeVowels(s7));

        //Check 2 strings are Permutation of each other
        String s4 = "dog";
        String s5 = "god";
        System.out.println("is Anagrams: " + permutation(s4,s5));

        //Check if string is unique
        String s3 = "madam";
        System.out.println("is unique: " + isUnique(s3));

        //Match substring from original string
        String s1 = "sanfrancisco";
        String s2 = "cisco";
        System.out.println("is sub string match: " + isSubStringMatch(s1, s2));

        //Remove duplicates from String
        String s6 = "madam";
        System.out.println("Remove duplicates " + removeDuplicates(s6));

        //Remove Duplicates from Sorted Array
        int[] num = {1,1,1,1,22,24,24,25,30,30};
        int length = removeDuplicatesFromSortedArray(num);
        System.out.println("Length of array after removing duplicates from sorted array: " + length);

        for (int i = 0; i < length; i++) {
           System.out.println(num[i]);
        }
        //Get duplicate character count
        String s8 = "madam";
        System.out.println("Repeated character count " + getDuplicateCharacters(s8));

        //Compress string
        String s9 = "aabcccccaaa";
        System.out.println("Compressed string count " + compress(s9));

        //Check is string has valid number of closing and opening parenthesis
        String s10 = "[{()}]]]";
        System.out.println(isValidParenthesis("String has valid parenthesis " + isValidParenthesis(s10)));

        int[] nums1 = {11,2,1,4,5,3,72,7};
        int target = 7;
        int[] result = twoSum(nums1,target);
        for (int element: result) {
            System.out.print(element + " ");
        }

        //Remove adjacent duplicates from a string
        String s11 = "mississippi";
        System.out.println("String after removing adjacent duplicates " + removeAdjacentDuplicates(s11));

        int[] nums4 = {1,2,2,2,3,4};
        int[] nums5 = {2,2,3};
        int[] intersection = intersect(nums4,nums5);
        for(int element: intersection)
            System.out.print(" " + element);

        int[] num1 = {1,2,3,0,0,0};
        int[] num2 = {2,5,6};
        merge(num1,num2,3,3);
        System.out.println("Merged sorted array: " + num1);
        for(int element: num1)
            System.out.print(" " + element);

        System.out.println(" ");

        //Contains Duplicate
        int[] nums3 = {1,1,1,3,3,4,3,2,4,2};
        boolean containsDuplicate = containsDuplicate(nums3);
        System.out.println("Array contains duplicate: " + containsDuplicate);

        MaxItemStack maxItemStack = new MaxItemStack();
        maxItemStack.push(5);
        maxItemStack.push(10);
        maxItemStack.push(20);
        maxItemStack.push(100);
        maxItemStack.push(50);

        System.out.println("Max item is: " + maxItemStack.getMaxItem());

        maxItemStack.pop();
        maxItemStack.pop();

        System.out.println("Max item is: " + maxItemStack.getMaxItem());

        MinItemStack minItemStack = new MinItemStack();
        minItemStack.push(5);
        minItemStack.push(10);
        minItemStack.push(20);
        minItemStack.push(100);
        minItemStack.push(50);

        System.out.println("Min item is: " + minItemStack.getMinItem());

        minItemStack.pop();
        minItemStack.pop();

        System.out.println("Min item is: " + minItemStack.getMinItem());
    }

    //Reverse a string
    public static String reverseString(String str) {

        //Allocate new buffer to hold characters
        StringBuffer buffer = new StringBuffer();

        //Iterate string from last to first.
        //Append each char to string buffer
        for(int i = str.length() - 1; i >=0 ; i-- ) {
            buffer.append(str.charAt(i));
        }

        //Return String
        return buffer.toString();
    }

    public static void reverseStringInPlace(char[] str) {

        int head = 0;
        int tail = str.length - 1;

        while(head < tail) {
            char temp = str[head];
            str[head] = str[tail];
            str[tail] = temp;
            head++;
            tail--;
        }
    }

    //Check if string madam is a palindrome
    public static boolean isPalindrome(String str) {
        int head = 0;
        int tail = str.length() - 1;
        while(head < tail) {

            if(str.charAt(head) != str.charAt(tail))
                return false; // Chars at head and tail are not same, so return false

            head++;
            tail--;
        }
        return true;
    }

    //Rotate Array
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1); //Reverse whole array
        reverse(nums, 0, k - 1 ); //Reverse 1st K numbers
        reverse(nums, k, nums.length - 1 ); //Reverse the numbers from n - k
    }

    static void reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
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

    //Check if array is sorted
    public static boolean isArraySorted(int[] a, int size) {
        if((size == 0) || (size == 1))
            return true; //base case

        if(a[0] > a[1])
            return false;

        return isArraySorted(Arrays.copyOfRange(a,1,size),size - 1);
    }

    public static int BinarySearch(int[] sortedArray, int num) {

        return BinarySearchRecursion(sortedArray,num,0, sortedArray.length - 1);
    }

    //O(logn) complexity
    private static int BinarySearchRecursion(int[] sortedArray, int num, int head, int tail) {

        if(head > tail)
            return -1; //Num not found

        //Mid of the sorted array
        int mid = (head + tail) / 2;

        if(num == sortedArray[mid])
            return mid;

        //search in left half
        if(num < sortedArray[mid])
            return BinarySearchRecursion(sortedArray,num, head,mid - 1);


        //search in right half
        if(num > sortedArray[mid])
            return BinarySearchRecursion(sortedArray,num,mid + 1, tail);

        return -1;
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

    //Remove Duplicates from Sorted Array
    public static int removeDuplicatesFromSortedArray(int[] nums) {
        if(nums.length == 0)
            return 0;

        int i = 0;
        for(int j = 1; j < nums.length;j++) { //We need only 1 loop
            if(nums[j] != nums[i]) {
                i++; //Next and previous elements are different so increment i

                nums[i] = nums[j]; //Always copy element from next to previous
            }
        }
        return i + 1; //i will give length of array
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
            if(i + 1 >= characters.length || characters[i] != characters[i + 1]) { //Append to StringBuffer if next and prev are different
                sb.append(characters[i]); //character
                sb.append(countConsecutive); //countConsecutive
                countConsecutive = 0; //reset to 0 for next character
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

    //Contains Duplicate
    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> integerSet = new HashSet<>();

        for(int element: nums) {
            if(!integerSet.add(element))
                return true;
        }
        return false;
    }



    //Single Number
    public int singleNumber(int[] nums) {
        int result = 0; //result should be zero
        for(int i = 0; i < nums.length; i++) {
            result ^= nums[i]; //XOR
        }
        return result;
    }

    //intersection of 2 arrays
    public static int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length)
            return intersect(nums2,nums1);

        List<Integer> arrayList = new ArrayList<>();
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        //Frequency map of nums1
        for(int i = 0; i < nums1.length;i++) {
            if(hm1.containsKey(nums1[i]))
                hm1.put(nums1[i], hm1.get(nums1[i]) + 1);
            else
                hm1.put(nums1[i], 1);
        }

        System.out.println(hm1);

        //Frequency map of nums2
        for(int j = 0; j < nums2.length;j++) {
            if(hm2.containsKey(nums2[j]))
                hm2.put(nums2[j], hm2.get(nums2[j]) + 1);
            else
                hm2.put(nums2[j], 1);
        }

        System.out.println(hm2);


        for(Integer key: hm1.keySet()) { //iterate through all the keys in keyset
            if(hm2.containsKey(key)) {
                int x = Math.min(hm2.get(key), hm1.get(key));
                while(x-- > 0) {
                    arrayList.add(key);
                }
            }
        }

        int[] result = new int[arrayList.size()];
        for(int k = 0; k < arrayList.size(); k++)
            result[k] = arrayList.get(k);

        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        HashMap<Integer,Integer> searchMap = new HashMap<>();

        for(int i = 0; i < length; i++) {
            int search = target - nums[i];
            if(searchMap.containsKey(search)) {
                result[0] = searchMap.get(search); //position from hashmap value
                result[1] = i;
            }
            else {
                searchMap.put(nums[i],i); //hashmap of num[i] as key and position i as value
            }
        }
        return result;
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

class MaxItemStack {

    //this is the original stack
    private Stack<Integer> mainStack;
    //this stack is just for tracking the maximum item
    private Stack<Integer> maxStack;

    public MaxItemStack() {
        this.mainStack = new Stack<>();
        this.maxStack = new Stack<>();
    }

    public void push(int item) {

        //push the new item onto the stack
        mainStack.push(item);

        //first item is the same in both stacks
        if(mainStack.size()==1) {
            maxStack.push(item);
            return;
        }

        //if the item is the largest one so far: we insert it onto the stack
        if(item > maxStack.peek()) {
            maxStack.push(item);
        } else {
            //if not the largest one then we duplicate the largest one on the maxStack
            maxStack.push(maxStack.peek());
        }
    }

    //when removing an item we remove it from both stacks
    public int pop() {
        maxStack.pop();
        return mainStack.pop();
    }

    //max item is the last item we have inserted into the maxStack O(1)
    public int getMaxItem() {
        return maxStack.peek();
    }
}

class MinItemStack {

    //this is the original stack
    private Stack<Integer> mainStack;
    //this stack is just for tracking the minimum item
    private Stack<Integer> minStack;

    public MinItemStack() {
        this.mainStack = new Stack<>();
        this.minStack = new Stack<>();
    }

    public void push(int item) {

        //push the new item onto the main stack
        mainStack.push(item);

        //first item is the same in both stacks
        if (mainStack.size() == 1) {
            minStack.push(item);
            return;
        }

        //if the item is the smallest one so far: we insert it onto the stack
        if (item < minStack.peek()) {
            minStack.push(item);
        } else {
            //if not the smallest one then we duplicate the smallest one on the minStack
            minStack.push(minStack.peek());
        }
    }

    //when removing an item we remove it from both stacks
    public int pop() {
        //if(mainStack.peek() == minStack.peek())
            minStack.pop();
        return mainStack.pop();
    }

    //min item is the last item we have inserted into the minStack O(1)
    public int getMinItem() {
        return minStack.peek();
    }
}

 class Node {
    int data;
    Node next;
 }
