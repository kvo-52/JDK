package gb.hw04;

public class PhilosopherStart {
    public static void main(String[] args) {
        final int nCounter = 3;
        String[] names = {
                "Кант", "Аристотель", "Платон", "Сократ","Пифагор"
        };

        Thread[] philosophers = new Thread[nCounter];
        Round round = new Round(nCounter);
        for (int i = 0; i < nCounter; ++i) {
            philosophers[i] = new Thread(
                    new Philosopher(names[i], i, nCounter, round, 1000*(1+i))
            );
        }
        System.out.println("Раунд " + round.getRound());
        for (Thread th : philosophers) {
            th.start();
        }

    }
}