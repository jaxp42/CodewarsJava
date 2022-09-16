package Kyu7;//You might know some pretty large perfect squares. But what about the NEXT one?
//Complete the findNextSquare method that finds the next integral perfect square after the one passed as a parameter.
//Recall that an integral perfect square is an integer n such that sqrt(n) is also an integer.
//If the parameter is itself not a perfect square then -1 should be returned. You may assume the parameter is non-negative.

public class FindNextSquare {
    public static void main(String args[]){
        System.out.println(findNextSquare(121));
    }

    public static long findNextSquare(long n){
        double sqrt = Math.sqrt(n);
        return sqrt % 1 == 0 ? (long) Math.pow(sqrt + 1, 2) : -1;
    }
}
