package service.impl;

import java.util.Random;
import service.DiceService;

public class SingleCrookedDiceService implements DiceService {

    @Override
    public int roll() {
        int dice = new Random().nextInt(12);
        return (int) Math.floor((double) dice/2);
    }

}
