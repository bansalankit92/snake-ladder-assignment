package service.impl;

import java.util.Random;
import service.DiceService;

public class SingleDiceService implements DiceService {

    @Override
    public int roll() {
        return new Random().nextInt(6);
    }

}