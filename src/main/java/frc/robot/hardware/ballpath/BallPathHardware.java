package frc.robot.hardware.ballpath;

import edu.wpi.first.wpilibj.DigitalInput;

public interface BallPathHardware {
    DigitalInput getLowerLightSensor();

    DigitalInput getUpperLightSensor();
}
