// Practice
// 기본 배열 자료형을 이용한 배열의 생성, 삽입, 삭제 기능 구현
// > 배열 생성시 사이즈 fix -> 삽입, 삭제할때 사이즈를 변경해줘야 함.
// ArrayList 도움 없이 기본적인 배열 타입을 받고, 삽입과 삭제를 처리하는 코드 작성.

import java.util.Arrays;

class MyArray {
    int[] arr;

//  배열의 초기 사이즈 설정
    MyArray(int size) {
        this.arr = new int[size];
    }


//  배열에 데이터 삽입
    public void insertData(int index, int data) {
        // 범위 외 데이터 들어올 시 예외처리
        if (index < 0 || index > this.arr.length) {
            System.out.println("Index Error");
            return;
        }

        // 정상적인 범위 들어왔을 때. 기존 배열의 데이터를 arrDup에 복사해둠.
        int[] arrDup = this.arr.clone();
        // 기존 배열에 원래사이즈보다 1개 더 큰 배열 생성
        this.arr = new int[this.arr.length + 1];

        // 0부터 기존 인덱스 추가하려는 위치까지는 기존 배열에 있던 데이터를 다시 할당
        for (int i = 0; i < index; i++) {
            this.arr[i] = arrDup[i];
        }

        // 데이터를 추가하려는 위치 그 다음부터 끝자리까지 기존 데이터 할당
        for (int i = index + 1; i < this.arr.length; i++) {
            this.arr[i] = arrDup[i - 1];
        }

        this.arr[index] = data;
    }


//  배열에서 특정 데이터 삭제
    public void removeData(int data) {
        int targetIndex = -1; // 아무것도 찾은게 없다란 표시

        // for 문을 돌면서 삭제하려는 데이터가 각각위치에 있는 데이터와 일치하는지 확인
        for (int i = 0; i < this.arr.length; i++) {
            // 만약 같은 데이터라면 타겟인덱스를 찾은 위치에 해당하는 인덱스로 넣어주고 종료
            if (this.arr[i] == data) {
                targetIndex = i;
                break;
            }
        }
        // 찾은 경우 없이 타겟인덱스가 그대로 -1일때
        if (targetIndex == -1) {
            System.out.println("해당 데이터가 없습니다.");
        } else {
            // 배열을 사이즈를 줄여서 다시 하나 만들어줌
            int[] arrDup = this.arr.clone();
            this.arr = new int[this.arr.length -1];

            // for문을 돌면서 지우려고 하는 인덱스의 위치 전까지 기존 배열을 다시 넣어줌
            for (int i = 0; i < targetIndex; i++) {
                this.arr[i] = arrDup[i];
            }

            //지우려고 하는 데이터에 해당하는 애만 빼고 나머지 데이터가 새로운 배열에 만들어짐
            for (int i = targetIndex; i < this.arr.length; i++) {
                this.arr[i] = arrDup[i + 1];
            }
        }
    }

}

public class Practice {
    public static void main(String[] args) {

//      Test code
        int size = 5;
        MyArray myArray = new MyArray(size);

        for (int i = 0; i < size; i++) {
            myArray.arr[i] = i + 1;
        }
        System.out.println(Arrays.toString(myArray.arr));   // [1, 2, 3, 4, 5]

        myArray.arr[0] = 10;
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 3, 4, 5]

        myArray.insertData(2, 20);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5]

        myArray.insertData(6, 60);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 4, 5, 60]

        myArray.insertData(-1, 0);  // Index Error

        myArray.removeData(4);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 5, 60]

        myArray.removeData(5);
        System.out.println(Arrays.toString(myArray.arr));   // [10, 2, 20, 3, 60]

        myArray.removeData(99); // 해당 데이터가 없습니다.
    }
}
