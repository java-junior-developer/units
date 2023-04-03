package Ru.Itmo.TASK;

abstract public class BattleUnit extends unit implements IAction{
    private int attackScore;

    public BattleUnit(int healthScore, int attackScore) {
        super(healthScore);
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    }

    public static BattleUnit getBattleUnit(){
        Randoms randoms = new Randoms();
        String[] types = {"knight", "infantry"};
        return switch (types[randoms.getRandomInt(types.length)]) {
            case "knight" -> new Knight(randoms.getRandomInt(10, 30), randoms.getRandomInt(10, 50));
            case "infantry" -> new Infantry(randoms.getRandomInt(10, 60), randoms.getRandomInt(10, 30));
            default -> null;
        };
    }

    public void attack(BattleUnit unit) {
        if (!isAlive() || !unit.isAlive()) return;
        unit.minusInt(getAttackScore());
    }

    public void rest() {
        plusInt(2);
    }
}