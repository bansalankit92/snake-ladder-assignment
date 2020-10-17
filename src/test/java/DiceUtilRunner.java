import in.co.ankitbansal.util.DiceUtil;

public class DiceUtilRunner {

    public static void main(String[] args) {
        System.out.println("Good dice");
        for (int i = 0; i < 20; i++) {
            System.out.print(DiceUtil.rollSingleDice()+",");
        }
        System.out.println("Crooked Dice");
        for (int i = 0; i < 20; i++) {
            System.out.print(DiceUtil.rollEvenDice()+",");
        }
    }
}
