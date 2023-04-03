package Ru.Itmo.TASK;

import static Ru.Itmo.TASK.Game.*;

public final class King extends unit {
    private int gold = GOLD;
    private BattleUnit[] army = new BattleUnit[20];

    public King() {
        super(KING_HEALTH);
        generateArmy();
    }

    private boolean hasGold(){
        return gold > 0;
    }

    public void minusGold(int count){
        if (!hasGold()) return;
        gold -= count;
    }

    public void plusGold(int count) {
        gold += count;
    }

    public void generateArmy() {
        army = new BattleUnit[20];
        if (gold < ARMY_PRICE) return;
        for (int i = 0; i < army.length; i++) {
            army[i] = BattleUnit.getBattleUnit();
        }
        minusGold(ARMY_PRICE);
    }
    public void addUnits() {
        for (int i = 0; i < army.length; i++) {
            if (!army[i].isAlive()) {
                if ((gold - UNIT_PRICE) < 0) return;
                army[i] = BattleUnit.getBattleUnit();
                minusGold(UNIT_PRICE);
            }
        }
    }
    public void startBattle(King enemy) {
        Randoms randoms = new Randoms();

        for (int i = 0; i < 20; i++) {
            int unitIndex = randoms.getRandomInt(army.length);
            int enemyIndex = randoms.getRandomInt(army.length);
            if (!army[unitIndex].isAlive() || !enemy.army[enemyIndex].isAlive()) continue;
            army[unitIndex].attack(enemy.army[enemyIndex]);
            army[unitIndex].rest();
            enemy.army[enemyIndex].attack(army[unitIndex]);
            enemy.army[enemyIndex].rest();
        }
    }
    public int getWarResult() {
        int alive = 0;
        for (BattleUnit battleUnit : army) {
            if (battleUnit.isAlive()) alive++;
        }
        return alive;
    }

    public BattleUnit[] getArmy() {
        return army;
    }

    public void attack(BattleUnit unit) {
        // король не атакует отдельных юнитов,
        // тело метода остается пустым
    }

    public void rest() {
        if (gold < KING_REST_PRICE) return;
        plusInt(10);
        minusGold(KING_REST_PRICE);
    }

    @Override
    public void quitBattle() {
        // король не сбегает с поля боя,
        // тело метода остается пустым
    }
}