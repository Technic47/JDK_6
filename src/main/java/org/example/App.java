package org.example;

import java.util.Random;

public class App {
    public static void main(String[] args) {
        int[] results = check(1000);
        System.out.println("switchWins: " + results[0]);
        System.out.println("stayWins: " + results[1]);
    }

    public static int[] check(int playsCount){
        if (playsCount <= 0) {
            throw new RuntimeException("Wrong argument!!!");
        }
        int switchWins = 0;
        int stayWins = 0;
        Random gen = new Random();
        for (int plays = 0; plays < playsCount; plays++) {
            int[] doors = {0, 0, 0};//0 is a goat, 1 is a car
            doors[gen.nextInt(3)] = 1;//put a winner in a random door
            int choice = gen.nextInt(3); //pick a door, any door
            int shown; //the shown door
            do {
                shown = gen.nextInt(3);
                //don't show the winner or the choice
            } while (doors[shown] == 1 || shown == choice);

            stayWins += doors[choice];//if you won by staying, count it

            //the switched (last remaining) door is (3 - choice - shown), because 0+1+2=3
            switchWins += doors[3 - choice - shown];
        }
        return new int[]{switchWins, stayWins};
    }
}
