package Kyu6;

//You probably know the "like" system from Facebook and other pages. People can "like" blog posts, pictures or other items.
// We want to create the text that should be displayed next to such an item.
//Implement the function which takes an array containing the names of people that like an item. It must return the display text as shown in the examples:
//
//        []                                -->  "no one likes this"
//        ["Peter"]                         -->  "Peter likes this"
//        ["Jacob", "Alex"]                 -->  "Jacob and Alex like this"
//        ["Max", "John", "Mark"]           -->  "Max, John and Mark like this"
//        ["Alex", "Jacob", "Mark", "Max"]  -->  "Alex, Jacob and 2 others like this"
//
//        Note: For 4 or more names, the number in "and 2 others" simply increases.

public class WhoLikesIt {
    public static void main(String args[]){
        System.out.println(whoLikesIt("Max", "John", "Mark"));
    }

    public static String whoLikesIt(String... names){
        String message = "no one likes this";
        int numLikes = names.length;

        if(numLikes > 3){
            message = String.format("%s, %s and %d others like this", names[0], names[1], numLikes - 2);
        }
        else if(numLikes > 0){
            for(int i = 0; i < numLikes; i++){
                if(i == 0){
                    message = names[i];
                }
                else if(i == numLikes - 1){
                    message += String.format(" and %s", names[i]);
                }
                else{
                    message += String.format(", %s", names[i]);
                }
            }
            message += numLikes == 1 ? " likes this" : " like this";
        }

        return message;
    }
}
