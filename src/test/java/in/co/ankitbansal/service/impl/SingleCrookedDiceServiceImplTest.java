package in.co.ankitbansal.service.impl;

import in.co.ankitbansal.util.DiceUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleCrookedDiceServiceImplTest {
    @Test
    void roll(){
        assertTrue(DiceUtil.rollEvenDice()>0);
        assertTrue(DiceUtil.rollEvenDice()<=6);
        assertTrue(DiceUtil.rollEvenDice()<7);
        assertEquals(DiceUtil.rollEvenDice() % 2, 0);
    }
}