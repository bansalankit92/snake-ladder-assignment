package in.co.ankitbansal.util;

import java.util.Random;

public class DiceUtil {

    private DiceUtil() {
    }

    public static int rollSingleDice(){
        return new Random().nextInt(6)+1;
    }

    public static int rollEvenDice(){
        return (new Random().nextInt(3)+1)*2;
    }

}
