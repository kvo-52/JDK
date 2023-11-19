package gb.hw06;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {

    static int numberDoor=3;
    static int numberIteration=1000;

    public static void main(String[] args) {



        }

    /**
     * Метод получения парадокс Монти Холла
     *
     * @return коллекция результатов комбинаций
     */
    public static Map<Integer, Boolean> processingGame() {
        int counterIteration = 0;
        Map<Integer, Boolean> result = new HashMap<>();
        while (counterIteration < numberIteration) {
            int winningDoor = new Random().nextInt(numberDoor) + 1;
            int selectedDoor = new Random().nextInt(numberDoor) + 1;
            result.put(counterIteration + 1, resultGame(winningDoor, selectedDoor));
            counterIteration++;
        }
        return result;
    }
    /**
     * Метод получения результата за один проход
     *
     * @param winningDoor  Дверь с выигрышем
     * @param selectedDoor Выбранная дверь
     * @return true если выбранная дверь оказалась выигрышной
     */
    public static boolean resultGame(int winningDoor, int selectedDoor) {
        int setNewDoor = new Random().nextInt(2); // Смена решения выбора: если 0 то не меняем, если 1 меняем
        if (winningDoor == selectedDoor) {
            return setNewDoor == 0;
        }
        return setNewDoor == 1;
    }


    }
