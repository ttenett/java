// Practice
// 아래 Device 추상 클래스를 이용하여
// UsbPort2 클래스와 WiFi 클래스를 자유롭게 구현해보세요.
// 수업내용

abstract class Device2 {
    int deviceId2;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();
}

// UsbPort2 클래스
class UsbPort2 extends Device2 {
    UsbPort2(int id) {
        this.deviceId2 = id;
    }

    void deviceInfo() {
        System.out.println("id = " + this.deviceId2);
    }
    void connect() {
        System.out.println("연결 하였습니다.");
    }
    void disconnect() {
        System.out.println("연결이 해제되었습니다.");
    }
    void send() {
        System.out.println("데이터를 전송합니다.");
    }
    void receive() {
        System.out.println("데이터를 수신합니다.");
    }
}

// WiFi1 클래스
class WiFi1 extends Device2 {
    public WiFi1(int id) { // 생성자 만들기
        this.deviceId2 = id;
    }

    @Override
    void deviceInfo() {

    }

    @Override
    void connect() {

    }

    @Override
    void disconnect() {

    }

    @Override
    void send() {

    }

    @Override
    void receive() {

    }
}

public class Practice2 {

    public static void main(String[] args) {
        // Test code
        UsbPort2 usb2 = new UsbPort2(1);
        WiFi1 wifi = new WiFi1(0);
    }

}
