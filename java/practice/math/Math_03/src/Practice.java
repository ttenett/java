// Practice
// 약수 구하기, 두 수의 최대공약수와 최소공배수 구하기
// 활용) 1~10의 수 중 A의 약수 또는 B의 약수인 경우의 수
// 활용) 1~10의 수 중 A의 약수이면서 B의 약수인 경우의 수

import java.util.ArrayList;

public class Practice {
    
//  약수
    public ArrayList getDivisor(int num) {
        ArrayList result = new ArrayList();

        // 자기수의 절반까지만 for문을 돌림. 나눠서 떨어지는 수 구하기.
        for (int i = 1; i <= (int)num/2; i++) {
            // 나눠서 떨어지면 넣기
            if (num % i == 0) {
                result.add(i);
            }
        } // for문 끝나고 자기자신도 넣어주기
        result.add(num);


        return result;
    }

//  최대 공약수
//  GCD: the Greatest Common Denominator
    public int getGCD(int numA, int numB) {
        int gcd = -1;

        // 각 숫자들의 약수 구하기
        ArrayList divisorA = this.getDivisor(numA);
        ArrayList divisorB = this.getDivisor(numB);

        // 약수중 최대공약수 뽑기, 이중포문 돌리면서 약수들끼리 같은 수가 발견되면,
        for (int itemA: (ArrayList<Integer>)divisorA) {
            for (int itemB: (ArrayList<Integer>)divisorB) {
                if (itemA == itemB) {
                    // 약수가 gcd 값보다 크면, 큰 공약수로 변경
                    if (itemA > gcd) {
                        gcd = itemA;
                    }
                }
            }
        }
        return gcd;
    }

//  최소 공배수
//  LCM: the Lowest Common Multiple
    public int getLCM(int numA, int numB) {
        int lcm = -1;

        // 두 수의 최대공약수 구하기

        int gcd = this.getGCD(numA, numB);

        // 예외상황 피하기 (ex 0과 5일 경우)
        if (gcd != -1) {
            lcm = numA * numB / gcd;
        }

        return lcm;
    }

    public static void main(String[] args) {

//      Test code
        int number1 = 10;
        int number2 = 6;

        Practice p = new Practice();
        ArrayList l1 = p.getDivisor(number1);   // 10: 1, 2, 5, 10
        ArrayList l2 = p.getDivisor(number2);   // 6: 1, 2, 3, 6
        System.out.println("l1 = " + l1);
        System.out.println("l2 = " + l2);

        System.out.println("최대 공약수: " + p.getGCD(number1, number2));
        System.out.println("최소 공배수: " + p.getLCM(number1, number2));
    }
}
