package Kyu5;

import java.util.Arrays;
import java.util.HashMap;

public class UrlShortener {
    static HashMap<String, String> shortUrlAsKeyDB = new HashMap<>();
    static HashMap<String, String> longUrlAsKeyDB = new HashMap<>();
    static int databaseSize = 0;
    static int numLetters = 1;
    static int loopCounter = 0;
    static char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    static char[] counter = new char[]{'a'};

    public static void main(String[] args){
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c3e"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c31"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c32"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c33"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c34"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c35"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c36"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c37"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c38"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c39"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c310"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c311"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c312"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c313"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c314"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c315"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c316"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c317"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c318"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c319"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c320"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c321"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c322"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c323"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c324"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c325"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c326"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c327"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c328"));
        System.out.println(urlShortener("https://www.codewars.com/kata/5ef9ca8b76be6d001d5e1c329"));
    }

    public static String urlShortener(String longUrl){
        String shortedUrl = "";

        //first check if url is already in db
        if(longUrlAsKeyDB.containsKey(longUrl)){
            return longUrlAsKeyDB.get(longUrl);
        }
        else{
            shortedUrl = generateShortUrl();
            shortUrlAsKeyDB.put(shortedUrl, longUrl);
            longUrlAsKeyDB.put(longUrl, shortedUrl);
            databaseSize++;
        }

        return shortedUrl;
    }

    public static String urlRedirector(String shortUrl){
        return shortUrlAsKeyDB.get(shortUrl);
    }

    private static String generateShortUrl(){
        String shortUrl = "";

        //Checks if the actual counter has reached its limit. In that case create a new counter with one more letter
        if(databaseSize == Math.pow(letters.length, numLetters)){
            counter = new char[counter.length + 1];
            Arrays.fill(counter, 'a');
            loopCounter = 1;
        }
        else{
            //if we reached the last letter we start again
            if(loopCounter == letters.length){
                loopCounter = 0;
            }

            for(int i=counter.length; i>0; i--){
                counter[--i] = letters[loopCounter];
                loopCounter++;
            }
        }

        return new String(counter);
    }

}
