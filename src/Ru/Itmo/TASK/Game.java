package Ru.Itmo.TASK;

public class Game {
    public final static int GOLD = 500;
    public final static int ARMY_PRICE = 250;
    public final static int UNIT_PRICE = 20;
    public final static int KING_REST_PRICE = 15;
    public final static int KING_HEALTH = 400;

    public static void start(){
        King king01 = new King();
        king01.generateArmy();

        King king02 = new King();
        king02.generateArmy();

        king01.startBattle(king02);

        System.out.println(king01.getWarResult());
        System.out.println(king02.getWarResult());
    }
}