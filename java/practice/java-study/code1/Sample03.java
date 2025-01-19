package code1;// 제어문, 반복문문

public class Sample03 {
    
    public void test() {

        int a = 10;
        int b = 20;
        int c = 30;

        if (a > 10) {
            // 조건이 참인 경우
            System.out.println("!!");
        } else {
            // 조건이 거짓인 경우
        }

        if (a > 10) {
            if (b > 10) {
                if (c > 10) {

                }

            }

        } else if (a < 10) {

        } else if (a < 5) {

        } else {

        }

        // switch 문, 조건식: 정수값, enum값, 문자열

        int curMonth = 4;
        int curDay = 0;

        switch (curMonth) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                curDay = 31;
                break;

            case 2:
                curDay = 28;
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                curDay = 30;
                break;

            default:
        }

        // for 문 - 유한하게 정해져있음음
        for (int i = 0; i < 10; i++) {
            
        }

        // while 문 - 종료조건 상태를 줌, True일 때까지 무한히 반복.
        int i = 10;
        while (i > 10) {

            // 특정조건을 만족하면 빠져나가고 싶을대 if문
            //if (조건문) {
            //    break;
            //}
            // continue 아래 문장은 스킵, 다시 조건문으로 가서 수행.
            continue;

        }

        do {

        } while(i > 10);
    }

    
}
