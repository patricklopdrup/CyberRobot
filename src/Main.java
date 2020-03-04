import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Main {
    public static void main(String[] args) {
        EV3UltrasonicSensor ultraSensor = new EV3UltrasonicSensor(SensorPort.S1);

        SampleProvider sp = ultraSensor.getDistanceMode();
        float distValue = 0.0f;

        int iteration = 100;

        System.out.println("Starter op");
        for(int i = 0; i <= iteration; i++) {
            float[] sample = new float[sp.sampleSize()];
            sp.fetchSample(sample, 0);
            distValue = sample[0];

            System.out.println("iteration: " + i + "\ndist: " + distValue);

            Delay.msDelay(500);
        }
    }

}
