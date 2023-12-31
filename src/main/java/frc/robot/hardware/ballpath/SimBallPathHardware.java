package frc.robot.hardware.ballpath;

import org.easymock.EasyMock;

import edu.wpi.first.wpilibj.DigitalInput;

public class SimBallPathHardware implements BallPathHardware {
    private DigitalInput _lowerLightSensor;
    private DigitalInput _upperLightSensor;
    private DigitalInput _shooterLightSensor;

    public SimBallPathHardware() {
        _lowerLightSensor = EasyMock.mock(DigitalInput.class);
        _upperLightSensor = EasyMock.mock(DigitalInput.class);
        _shooterLightSensor = EasyMock.mock(DigitalInput.class);
    }

    @Override
    public DigitalInput getLowerLightSensor() {
        return _lowerLightSensor;
    }

    @Override
    public DigitalInput getUpperLightSensor() {
        return _upperLightSensor;
    }

    @Override
    public DigitalInput getShooterLightSensor() {
        return _shooterLightSensor;
    }

    public void replayHardware() {
        EasyMock.replay(_lowerLightSensor, _upperLightSensor);
    }

    public void verifyHardware() {
        EasyMock.verify(_lowerLightSensor, _upperLightSensor);
    }
}
