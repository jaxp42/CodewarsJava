package Kyu6;

//Johnny is a farmer and he annually holds a beet farmers convention "Drop the beet".
//Every year he takes photos of farmers handshaking. Johnny knows that no two farmers handshake more than once.
// He also knows that some of the possible handshake combinations may not happen.
//However, Johnny would like to know the minimal amount of people that participated this year just by counting all the handshakes.
//Help Johnny by writing a function, that takes the amount of handshakes and returns the minimal amount of people needed
// to perform these handshakes (a pair of farmers handshake only once).

public class HandshakeProblem {
    public static void main(String args[]){
        System.out.println(getParticipants(1));
    }

//    public static int getParticipants(int handshakes){
//        int minPeople = 0;
//        boolean foundMin = false;
//
//        while(!foundMin){
//            int auxHandshakes = 0;
//            for(int i=0; i<minPeople; i++){
//                auxHandshakes += i;
//            }
//            if(auxHandshakes >= handshakes){
//                foundMin = true;
//            }
//            else{
//                minPeople += 1;
//            }
//        }
//
//        return minPeople;
//    }


    //better solution
    public static int getParticipants(int handshakes){
        int minPeople = 0;

        while((minPeople * (minPeople -1)) / 2 < handshakes){
            minPeople += 1;
        }

        return minPeople;
    }
}
