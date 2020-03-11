package Drive;

import lejos.robotics.RegulatedMotor;

public class Drive implements DriveI {

    private RegulatedMotor rightmotor;
    private RegulatedMotor leftmotor;
    private boolean moving;
    private int movespeed;
    private int turnspeed;
    private int angle;

    public Drive(RegulatedMotor rightmotor, RegulatedMotor leftmotor){
        this.leftmotor = leftmotor;
        this.rightmotor = rightmotor;
        rightmotor.synchronizeWith(new RegulatedMotor[]{leftmotor});
    }

    @Override
    public void forward() {
        rightmotor.startSynchronization();
        rightmotor.forward();
        leftmotor.forward();
        rightmotor.endSynchronization();
        moving = true;
    }

    @Override
    public void backward() {
        rightmotor.startSynchronization();
        rightmotor.backward();
        leftmotor.backward();
        rightmotor.endSynchronization();
        moving = true;
    }

    @Override
    public void stop() {
        rightmotor.startSynchronization();
        rightmotor.stop();
        leftmotor.stop();
        rightmotor.endSynchronization();
        moving = false;
    }

    @Override
    public boolean isMoving() {
        // I like to move it
        return moving;
    }

    @Override
    public void setMoveSpeed(int speed) {
        this.movespeed = speed;
    }

    @Override
    public float getMoveSpeed() {
        return movespeed;
    }

    @Override
    public void setTurnSpeed(int speed) {
        this.turnspeed = speed;
    }

    @Override
    public float getTurnSpeed() {
        return turnspeed;
    }

    @Override
    public void travel(float distance) {

    }

    @Override
    public void rotate(int angle) {
        rightmotor.startSynchronization();
        rightmotor.rotate(angle);
        leftmotor.rotate(angle);
        rightmotor.endSynchronization();
        moving = true;
    }

    @Override
    public float getAngle() {
        return angle;
    }

    @Override
    public float getTravelDistance() {
        return 0;
    }

    @Override
    public void calibrate() {

    }
}
