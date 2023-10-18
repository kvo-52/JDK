package gb.Pair;

/**
 * <p>Класс для поиска минимального и максимального элемента в массиве</p>
 * */
class ArrayAlg {
    /**
     * <p>Функция для поиска минимального и максимального элемента в массиве</p>
     * @param a Массив строк.
     * @return Минимальное и максимальное значение, упакованные в пару
     * */
    public static Pair<String> minmax(String[] a) {
        if (a == null || a.length == 0) {
            return null;
        }

        String min = a[0];
        String max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }

            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Pair<>(min, max);
    }
}
