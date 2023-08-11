package frc.robot.hardware.drivebase;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import frc.robot.hardware.HardwareConstants;

public class RealDrivebaseHardware implements DrivebaseHardware {
    private CANSparkMax _leftPrimary;
    private CANSparkMax _rightPrimary;

    public RealDrivebaseHardware() {
        _leftPrimary = new CANSparkMax(
            HardwareConstants.CanIds.LEFT_PRIMARY_MOTOR_ID, MotorType.kBrushless);
        _rightPrimary = new CANSparkMax(
            HardwareConstants.CanIds.RIGHT_PRIMARY_MOTOR_ID, MotorType.kBrushless);
    }

    @Override
    public CANSparkMax getLeftPrimaryMotor() {
        return _leftPrimary;
    }

    @Override
    public CANSparkMax getRightPrimaryMotor() {
        return _rightPrimary;
    }
}
