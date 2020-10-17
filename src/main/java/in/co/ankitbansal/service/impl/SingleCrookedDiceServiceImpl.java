package in.co.ankitbansal.service.impl;

import java.util.Random;
import in.co.ankitbansal.service.DiceService;
import in.co.ankitbansal.util.DiceUtil;

public class SingleCrookedDiceServiceImpl implements DiceService {

    @Override
    public int roll() {
        return DiceUtil.rollEvenDice();
    }

}
