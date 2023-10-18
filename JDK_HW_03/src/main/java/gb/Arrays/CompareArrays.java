package gb.Arrays;

import java.util.Objects;
import java.util.stream.IntStream;

public class CompareArrays {
    // Общий метод проверки равенства массивов в Java. Он принимает массивы как
    // проверяется на равенство и возвращает true, если два массива равны
    private static <U, V> boolean compareArrays(U[] a, V[] b)
    {
        // 1. Проверить наличие той же ссылки на массив
        if (a == b) {
            return true;
        }

        // 2. Проверяем, является ли какой-либо из массивов нулевым
        if (a == null || b == null) {
            return false;
        }

        // 3. Проверяем, имеют ли оба массива одинаковый тип или нет
        if (!a.getClass().equals(b.getClass())) {
            return false;
        }

        // 4. Проверяем, имеют ли оба массива одинаковую длину или нет
        if (a.length != b.length) {
            return false;
        }

        // 5. Наконец, сравним значения массива по каждому индексу
        return IntStream.range(0, a.length).allMatch(i -> Objects.equals(a[i], b[i]));
    }

    public static void main(String[] args)
    {
        String[] a = { "public", "static", "void", "main" };
        String[] b = { "public", "static", "void", "fun" };

        if (compareArrays(a, b)) {
            System.out.println("Arrays are equal");
        }
        else {
            System.out.println("Arrays are not equal");
        }
    }
}
