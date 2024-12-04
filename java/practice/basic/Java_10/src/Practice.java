// Practice
// 아래 Device 추상 클래스를 이용하여
// UsbPort1 클래스와 WiFi 클래스를 자유롭게 구현해보세요.
// 내가 쓴거ㅜ 생성자 새로 만들어줘야하나..
abstract class Device {
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();
}

// UsbPort1 클래스
class UsbPort1 extends Device {
//    int deviceId;
    public void deviceInfo() {
        System.out.println(deviceId + " UsbPort1 정보");
    }
    public void connect() {
        System.out.println(deviceId + " Usb 연결");
    }
    public void disconnect() {
        System.out.println(deviceId + " Usb 해제");
    }
    public void send() {
        System.out.println(deviceId + " Usb 신호 전송됨");
    }
    public void receive() {
        System.out.println(deviceId + "Usb 신호 받음");
    }
}

// WiFi 클래스
class WiFi extends Device {
//    int deviceId;
    public void deviceInfo() {
        System.out.println(deviceId + " WiFi 정보");
    }
    public void connect() {
        System.out.println(deviceId + " WiFi 연결");
    }
    public void disconnect() {
        System.out.println(deviceId + " WiFi 해제");
    }
    public void send() {
        System.out.println(deviceId + " WiFi 신호 전송됨");
    }
    public void receive() {
        System.out.println(deviceId + "WiFi 신호 받음");
    }
}

public class Practice {

    public static void main(String[] args) {
        // Test code
//        UsbPort1 usb1 = new UsbPort1(1);
//        WiFi wifi = new WiFi(0);
    }

}
