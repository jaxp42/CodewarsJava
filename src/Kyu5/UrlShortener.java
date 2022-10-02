package Kyu5;

import java.util.Arrays;
import java.util.HashMap;

public class UrlShortener {
    private static HashMap<String, String> shortUrlAsKeyDB = new HashMap<>();
    private static HashMap<String, String> longUrlAsKeyDB = new HashMap<>();
    private static int databaseSize = 0;
    private static int[] loopCounters = new int[]{0};
    private static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static char[] counter = new char[]{'a'};
    private static boolean endLoop = false;

    public static void main(String[] args){
        for(int i=1; i<20000; i++){
            if(i == 702){
                System.out.println("");
            }
            urlShortener("https://www.codewars.com/kata/" + i);
        }

        System.out.println(urlRedirector("short.ly/aaaa"));
    }

    public static String urlShortener(String longURL){
        String shortedURL = "";

        //first check if url is already in db
        if(longUrlAsKeyDB.containsKey(longURL)){
            return longUrlAsKeyDB.get(longURL);
        }
        else{
            shortedURL = "short.ly/" + generateShortUrl();
            shortUrlAsKeyDB.put(shortedURL, longURL);
            longUrlAsKeyDB.put(longURL, shortedURL);
            databaseSize++;
        }

        return shortedURL;
    }

    public static String urlRedirector(String shortURL){
        return shortUrlAsKeyDB.get(shortURL);
    }

    private static String generateShortUrl(){
        String shortURL = "";

        //Checks if the actual counter has reached its limit. In that case create a new counter with one more letter
        if(isCounterLimit()){
            counter = new char[counter.length + 1];
            loopCounters = new int[loopCounters.length + 1];
            Arrays.fill(counter, 'a');
            Arrays.fill(loopCounters, 1);
        }
        else{
            endLoop = false;

            //if we reached the last letter start again the loop
            for(int i = counter.length; i > 0; i--){
                if(endLoop || i == counter.length){
                    //if we reached the last letter start again the loop
                    if(loopCounters[i - 1] == letters.length){
                        loopCounters[i - 1] = 0;
                        endLoop = true;
                    }
                    else {
                        endLoop = false;
                    }
                    counter[i - 1] = letters[loopCounters[i - 1]];
                    loopCounters[i - 1] = (loopCounters[i - 1] + 1);
                }
            }
        }

        return new String(counter);
    }

    private static boolean isCounterLimit(){
        double pow = 0;

        for(int i=1; i<=counter.length; i++){
            pow += Math.pow(letters.length, i);
        }

        return databaseSize == pow;
    }

}
