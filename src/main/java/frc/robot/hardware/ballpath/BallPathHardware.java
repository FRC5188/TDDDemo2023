package frc.robot.hardware.ballpath;

import edu.wpi.first.wpilibj.DigitalInput;

public interface BallPathHardware {
    public DigitalInput getLowerLightSensor();

    public DigitalInput getUpperLightSensor();
}
