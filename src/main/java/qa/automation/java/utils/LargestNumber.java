package qa.automation.java.utils;

import java.util.Arrays;
import java.util.Random;

public class LargestNumber {
    static int[] randomNumbers(int count, int upperBound){
        Random rand = new Random();
        int[] numbers = new int[count];
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = rand.nextInt(upperBound);
        }
        return numbers;
    }

    static int findLargestNumber(int[] numbers){
        int max = numbers[0];
        for (int i : numbers) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] numbers = randomNumbers(10,1000);
        int maxNumber = findLargestNumber(numbers);
        System.out.println("The selected numbers are: " + Arrays.toString(numbers));
        System.out.println("The largest number is: " + maxNumber);
    }
}
