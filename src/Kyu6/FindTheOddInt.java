package Kyu6;

import java.util.*;
import java.util.stream.Collectors;

public class FindTheOddInt {
    public static void main(String[] args){
        System.out.println(findIt(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
    }

    public static int findIt(int[] a){
        List<Integer> numbers = Arrays.stream(a).boxed().collect(Collectors.toList());
        Set<Integer> unrepeatedNumbers = new HashSet<>(numbers);

        for(Integer number : unrepeatedNumbers){
            if (Collections.frequency(numbers, number) % 2 != 0){
                return number;
            }
        }

        return 0;
    }
}
