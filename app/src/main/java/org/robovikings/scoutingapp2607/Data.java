package org.robovikings.scoutingapp2607;

/**
 * Created by Tom on 2/10/2016.
 */
public class Data {
    static int[] teleopdefenses = new int[10];
    static int[] autonDefenses = new int[10];//replace with ints 0-9 each representing one defense

    static int autonDefenseses(){
        int temp = 0;
        for(int i = 0 ; i < autonDefenses.length - 1 ; i++){
            temp += autonDefenses[i];
        }
        return temp;
    }

    static int highMiss, lowMiss, High, Low, aHigh, aLow, aLowMiss, aHighMiss, fouls, techFouls, matchNumber;

    static boolean challenge, scale, spy, broken, absent, reach, nothing, matchOver3, matchOver1;

    static String teamNumber, defenseComments, crossingComments, skillComments, scoutName, position, CSV;



    //give Mike header of CSV file. (Where all the data lives)
}
