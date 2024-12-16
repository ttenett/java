// Java 프로그래밍 - 람다식

interface ComputeTool {
    public abstract int compute(int x, int y);

    public abstract int compute2(int x, int y);
}



public class Main {

    public static void main(String[] args) {

        ComputeTool cTool1 = new ComputeTool() {
            @Override
            public int compute(int x, int y) {
                return x + y;
            }

            public int compute2(int x, int y) {
                return x - y;
            }
        };
        System.out.println(cTool1.compute(1, 2));

        // 람다식
        // 간결하지만, 인터페이스에 추상메소드가 2개인 경우 / 익명클래스는 한번 더 오버라이딩을 하면 됨. 그치만 람다식은 사용이 제한됨.
//        ComputeTool cTool2 = (x, y) -> { return x + y; };
//        System.out.println(cTool2.compute(1, 2));

    }
}
