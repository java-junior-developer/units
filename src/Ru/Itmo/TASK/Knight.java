package Ru.Itmo.TASK;

public class Knight extends BattleUnit {
    public Knight(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    }

    @Override
    public void quitBattle() {
        System.out.println("Þíèò ñáåæàë");
        minusInt(1);
    }
}