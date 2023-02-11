package com.blz.datastructure;

import java.util.ArrayList;
import java.util.Arrays;

public class PrimeNumbersAnagramPalindrome {
    static ArrayList<Integer> arraylistPrime = new ArrayList<>();
    static ArrayList<String> arraylistAnagram = new ArrayList<>();
    static ArrayList<Integer> arraylistPalindrome = new ArrayList<>();

    public static void main(String[] args) {
        final int START_RANGE = 0;
        final int END_RANGE = 1000;
        primePrint(START_RANGE, END_RANGE);
        palindromePrint();
        printAllAnagram(arraylistPrime, arraylistPrime.size());
    }

    public static void printAllAnagram(ArrayList<Integer> arraylist, int size) {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                String str1 = Integer.toString(arraylist.get(i));
                String str2 = Integer.toString(arraylist.get(j));
                if (isAnagram(str1, str2)) {
//                    System.out.println(str1 + " is anagram of " + str2 + "\n");
                    arraylistAnagram.add("   {"+str1 + " is anagram of " + str2+"}   ");
                }
            }
        }
        System.out.println(arraylistAnagram);
    }

    private static void primePrint(int startRange, int endRange) {
        System.out.println("Prime numbers are in between " + startRange + " and " + endRange + " are :");
        for (int range = startRange; range <= endRange; range++) {
            if (isPrime(range)) {
                arraylistPrime.add(range);
            }
        }
        System.out.println("prime");
        System.out.println("Prime\n" + arraylistPrime);

    }

    public static boolean isPalindrome(int num) {
        int num1 = num;
        int rev = 0;
        for (int rem = 0; num1 != 0; num1 = num1 / 10) {
            rem = num1 % 10;
            rev = rev * 10 + rem;
        }
        if (num == rev)
            return true;
        else
            return false;
    }

    static public void palindromePrint() {
        for (int i = 0; i < arraylistPrime.size(); i++) {
            if (isPalindrome(arraylistPrime.get(i))) {
                arraylistPalindrome.add(arraylistPrime.get(i));
            }
        }
        System.out.println("palindrome\n" + arraylistPalindrome);
    }

    public static boolean isAnagram(String string1, String string2) {
        if (string1.length() != string2.length())
            return false;
        char[] array1 = string1.toCharArray();
        Arrays.sort(array1);
        char[] array2 = string2.toCharArray();
        Arrays.sort(array2);
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] != array2[i]) {
                return false;
            }
        }
        return true;
    }

    private static int primeRev(int num) {
        int num1 = num;
        int rev = 0;
        for (int rem = 0; num1 != 0; num1 = num1 / 10) {
            rem = num1 % 10;
            rev = rev * 10 + rem;
        }
        return rev;
    }

    public static boolean isPrime(int num) {
        int flag = 0;
        if (num == 0 || num == 1)
            return false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
