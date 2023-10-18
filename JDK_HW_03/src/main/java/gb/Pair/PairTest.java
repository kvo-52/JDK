package gb.Pair;

public class PairTest {
    public static void main(String[] args) {
        String[] words = {"name1", "b", "name3", "c", "name2", "a"};
        Pair mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
