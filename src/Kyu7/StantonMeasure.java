package Kyu7;

//The Stanton measure of an array is computed as follows: count the number of occurences for value 1 in the array.
//Let this count be n. The Stanton measure is the number of times that n appears in the array.
//Write a function which takes an integer array and returns its Stanton measure.
//Examples
//The Stanton measure of [1, 4, 3, 2, 1, 2, 3, 2] is 3, because 1 occurs 2 times in the array and 2 occurs 3 times.
//The Stanton measure of [1, 4, 1, 2, 11, 2, 3, 1] is 1, because 1 occurs 3 times in the array and 3 occurs 1 time.


import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StantonMeasure {
    public static void main(String args[]){
        System.out.println(stantonMeasure(new int[] {1, 4, 3, 2, 1, 2, 3, 2}));
    }

    public static int stantonMeasure(int[] arr){
        int stantonMeasure = 0;
        List<Integer> numberList = Arrays.stream(arr).boxed().collect(Collectors.toList());

        int frecuency1 = Collections.frequency(numberList, 1);
        stantonMeasure = Collections.frequency(numberList, frecuency1);

        return stantonMeasure;
    }
}
