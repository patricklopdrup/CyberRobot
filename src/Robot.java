import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class Robot {

    private RegulatedMotor rightMotor;
    private RegulatedMotor leftMotor;

    public Robot(RegulatedMotor right, RegulatedMotor left) {
        rightMotor = right;
        leftMotor = left;
    }

    public void forwards(int delay) {
        rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});

        rightMotor.startSynchronization();
        rightMotor.forward();
        leftMotor.forward();
        rightMotor.endSynchronization();
        Delay.msDelay(delay);
    }

    public void backwards(int delay) {
        rightMotor.synchronizeWith(new RegulatedMotor[] {leftMotor});

        rightMotor.startSynchronization();
        rightMotor.backward();
        leftMotor.backward();
        rightMotor.endSynchronization();
        Delay.msDelay(delay);
    }

    public void rotate(int degree) {
        rightMotor.startSynchronization();
        rightMotor.forward();
        leftMotor.backward();
        rightMotor.endSynchronization();
        Delay.msDelay((int)(7.7*degree));
    }

}
