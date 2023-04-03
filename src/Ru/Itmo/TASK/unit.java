package Ru.Itmo.TASK;

abstract public class unit implements IAction {
    private int healthScore;
    private final int maxHealthScore;

    public unit(int healthScore) {
        this.healthScore = healthScore;
        this.maxHealthScore = healthScore;
    }

    public void plusInt(int count){
        if (!isAlive()) return;
        healthScore = Math.min(healthScore + count, maxHealthScore);
    }
    public void minusInt(int count){
        if (!isAlive()) return;
        healthScore -= count;
    }

    public boolean isAlive(){
        return healthScore > 0;
    }

    public int getInt() {
        return healthScore;
    }

    abstract public void rest();
}