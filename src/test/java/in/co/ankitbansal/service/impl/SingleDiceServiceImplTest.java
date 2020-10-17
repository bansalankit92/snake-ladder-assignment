package in.co.ankitbansal.service.impl;

import in.co.ankitbansal.util.DiceUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleDiceServiceImplTest {

    @Test
    void roll(){
        assertTrue(DiceUtil.rollSingleDice()>0);
        assertTrue(DiceUtil.rollSingleDice()<=6);
        assertTrue(DiceUtil.rollSingleDice()<7);

    }

}