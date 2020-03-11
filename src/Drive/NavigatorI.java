package Drive;

import lejos.robotics.navigation.Pose;

public interface NavigatorI {

    void setPose(float x, float y, float heading);
    Pose getPose();
    void goTo(float x, float y);

}
