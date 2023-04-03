package Ru.Itmo.TASK;

public class Infantry extends BattleUnit {
    public Infantry(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    @Override
    public void quitBattle() {
        System.out.println("Þíèò ñáåæàë");
        minusInt(1);
    }
}