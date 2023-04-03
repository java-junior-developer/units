package Ru.Itmo.TASK;

public class Randoms {
    public int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public int getRandomInt(int max) {
        return (int) (Math.random() * max);
    }
}