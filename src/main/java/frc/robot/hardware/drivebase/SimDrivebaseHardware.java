package frc.robot.hardware.drivebase;

import com.revrobotics.CANSparkMax;
import org.easymock.EasyMock;

public class SimDrivebaseHardware implements DrivebaseHardware {
    private CANSparkMax _leftPrimary;
    private CANSparkMax _rightPrimary;

    public SimDrivebaseHardware() {
        _leftPrimary = EasyMock.mock(CANSparkMax.class);
        _rightPrimary = EasyMock.mock(CANSparkMax.class);
    }

    @Override
    public CANSparkMax getLeftPrimaryMotor() {
        return _leftPrimary;
    }

    @Override
    public CANSparkMax getRightPrimaryMotor() {
        return _rightPrimary;
    }

    public void replayHardware() {
        EasyMock.replay(_leftPrimary, _rightPrimary);
    }

    public void verifyHardware() {
        EasyMock.verify(_leftPrimary, _rightPrimary);
    }
    
}
