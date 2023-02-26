package qa.automation.java.utils;

import java.util.Arrays;
import java.util.Random;

public class LargestNumber {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = rand.nextInt(1000);
        }
        int max = numbers[0];
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        System.out.println("The selected numbers are: " + Arrays.toString(numbers));
        System.out.println("The largest number is: " + max);
    }
}
