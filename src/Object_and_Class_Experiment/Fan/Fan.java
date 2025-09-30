package Object_and_Class_Experiment.Fan;

public class Fan {
    // 风扇速度常量
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;          // 风扇转速
    private boolean on;         // 风扇是否开启
    private String brand;       // 风扇品牌

    public Fan(String brand) {
        this.brand = brand;
        this.on = false;        // 默认关闭
        this.speed = SLOW;      // 默认慢速
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSpeedString() {
        switch (speed) {
            case SLOW:
                return "慢";
            case MEDIUM:
                return "中";
            case FAST:
                return "快";
            default:
                return "未知";
        }
    }
}