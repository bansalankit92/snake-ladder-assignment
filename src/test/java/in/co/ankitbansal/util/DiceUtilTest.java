package in.co.ankitbansal.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceUtilTest {

    @Test
    void rollSingleDice() {
        assertTrue(DiceUtil.rollSingleDice()>0);
        assertTrue(DiceUtil.rollSingleDice()<=6);
        assertTrue(DiceUtil.rollSingleDice()<7);

    }

    @Test
    void rollEvenDice() {
        assertTrue(DiceUtil.rollEvenDice()>0);
        assertTrue(DiceUtil.rollEvenDice()<=6);
        assertTrue(DiceUtil.rollEvenDice()<7);
        assertEquals(DiceUtil.rollEvenDice() % 2, 0);
    }

}