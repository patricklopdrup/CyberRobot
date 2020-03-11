import lejos.hardware.Sound;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.robotics.RegulatedMotor;
import lejos.utility.Delay;

public class MotorTest {

    public static void main(String[] args) {
        RegulatedMotor right = new EV3LargeRegulatedMotor(MotorPort.B);
        RegulatedMotor left = new EV3LargeRegulatedMotor(MotorPort.A);

        Robot robot = new Robot(right, left);

        robot.rotate(45);

        Sound.setVolume(100);
        Sound.systemSound(true, 1);
        Sound.systemSound(true, 2);
        Sound.systemSound(true, 3);
        Sound.systemSound(true, 4);
        //Sound.playSample(new File("hej.wav"), 100);
//		float angle = Motor.A.getPosition();
//		System.out.println("angle: " + angle);
//		Motor.A.rotateTo(90);
//		float nAngle = Motor.A.getPosition();
//		System.out.println("new angle: " + nAngle);
        //Delay.msDelay(5000);
    }


    private static void forwards(RegulatedMotor left, RegulatedMotor right, int delay) {
        left.synchronizeWith(new RegulatedMotor[] {right});

        left.startSynchronization();
        left.forward();
        right.forward();
        left.endSynchronization();
        Delay.msDelay(delay);
    }

}
