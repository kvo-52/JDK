package gb.calculater;

public interface CalcInterface <T extends Number>{
    T add(T a, T b);
    T subtract(T a, T b);
    T div (T a, T b);
    T multiply (T a, T b);

}
