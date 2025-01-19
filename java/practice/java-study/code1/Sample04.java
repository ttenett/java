package code1;// 구구단 만들기 실습

public class Sample04 {

    public static void main(String[] args) {
        
        for (int j = 1; j <= 9; j++) {
            for (int i = 2; i <= 9; i++) {
                System.out.printf("%d * %d = %d", i, j, (j * i));
                System.out.print("\t");
               }
               System.out.println("");
        }
        

    }
    
}
