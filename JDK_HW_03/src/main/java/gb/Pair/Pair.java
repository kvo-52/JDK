package gb.Pair;


/**
 * <p>Класс, который представляет из себя пару обобщенных значений</p>
 * */
class Pair<T> {
    private T first;
    private T second;

    /**
     * <p>Конструктор по умолчанию</p>
     * */
    public Pair() {
        this.first = null;
        this.second = null;
    }

    /**
     * <p>Конструктор, который принимает два значения</p>
     * @param first Первое значение
     * @param second Второе значение
     * */
    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    /**
     * <p>Функция для получения первого значения</p>
     * @return Первое значение
     * */
    public T getFirst() {
        return first;
    }

    /**
     * <p>Функция для изменения первого значения</p>
     * @param first Первое значение
     * */
    public void setFirst(T first) {
        this.first = first;
    }

    /**
     * <p>Функция для получения второго значения</p>
     * @return Второе значение
     * */
    public T getSecond() {
        return second;
    }

    /**
     * <p>Функция для изменения второго значения</p>
     * @param second Второе значение
     * */
    public void setSecond(T second) {
        this.second = second;
    }
}


