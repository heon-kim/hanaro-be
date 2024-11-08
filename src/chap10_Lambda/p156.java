package chap10_Lambda;

public class p156 {
    interface Mathematical {
        double calculate(double d);
    }

    interface Pickable {
        char pick(String s, int i);
    }

    interface Computable {
        int compute(int x, int y);
    }

    static class Utils {
        int add(int a, int b) {
            return a + b;
        }
    }

    public static void main(String[] args) {
        Mathematical m;
        Pickable p;
        Computable c;

        m = Math::abs;
        System.out.println(m.calculate(-5.5));  // 예시 출력

        p = String::charAt;
        System.out.println(p.pick("Hello Java~", 4));

        Utils utils = new Utils();
        c = utils::add;
        System.out.println(c.compute(20, 30));
    }
}
