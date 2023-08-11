package frc.robot.hardware.drivebase;

import com.revrobotics.CANSparkMax;

public interface DrivebaseHardware {
    CANSparkMax getLeftPrimaryMotor();

    CANSparkMax getRightPrimaryMotor();
}
