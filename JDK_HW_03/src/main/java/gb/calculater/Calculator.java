package gb.calculater;

public class Calculator {

    public static class calculator implements CalcInterface <Integer> {

        public Integer add(Integer a, Integer b) {
            return a+b;
        }


        public Integer subtract (Integer a, Integer b) {
            return a - b;
        }


        public Integer div (Integer a, Integer b){
            return a/b;
        }

        public Integer multiply(Integer multiplicand, Integer multiplier) {
            return multiplicand * multiplier; }
    }

}
