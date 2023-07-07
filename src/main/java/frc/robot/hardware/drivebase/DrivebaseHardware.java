package frc.robot.hardware.drivebase;

import com.revrobotics.CANSparkMax;

public interface DrivebaseHardware {
    public CANSparkMax getLeftPrimaryMotor();

    public CANSparkMax getRightPrimaryMotor();
}
