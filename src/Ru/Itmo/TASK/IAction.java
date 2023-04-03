package Ru.Itmo.TASK;

public interface IAction {
    public void attack(BattleUnit unit);
    public void rest();
    default public void quitBattle() {
        // необходимо переопределить для боевых юнитов,
        // при бегстве с поля боя здоровье уменьшается на 1
        System.out.println("Þíèò ñáåæàë");
    }
}