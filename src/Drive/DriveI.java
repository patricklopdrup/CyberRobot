package Drive;

public interface DriveI {

    void forward();
    void backward();
    void stop();
    boolean isMoving();
    void setMoveSpeed(int speed);
    float getMoveSpeed();
    void setTurnSpeed(int speed);
    float getTurnSpeed();
    void travel(float distance);
    void rotate(int angle);
    float getAngle();
    float getTravelDistance();
    void calibrate();

}
