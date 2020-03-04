import lejos.hardware.BrickFinder;
import lejos.hardware.port.SensorPort;
import lejos.hardware.port.UARTPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.SampleProvider;
import lejos.utility.Delay;

public class Main {
    private static EV3UltrasonicSensor ultraSensor;
    public static void main(String[] args) {
        ShutDownTask shutDownTask = new ShutDownTask();
        Runtime.getRuntime().addShutdownHook(shutDownTask);
        ultraSensor = new EV3UltrasonicSensor(SensorPort.S4);

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

    private static class ShutDownTask extends Thread {
        @Override
        public void run() {
            try {
                ultraSensor.close();
                UARTPort port = BrickFinder.getDefault().getPort("S4").open(UARTPort.class);
                port.close();
            } catch (NullPointerException e) {

            }

        }
    }
}
