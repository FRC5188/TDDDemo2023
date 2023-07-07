package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.drivebase.DrivebaseHardware;

public class Drivebase extends SubsystemBase {
    private DrivebaseHardware _hardware;

    public Drivebase(DrivebaseHardware hardware) {
        _hardware = hardware;
    }

    public void arcadeDrive(double throttle, double rotate) {
        _hardware.getLeftPrimaryMotor().set(0);
        _hardware.getRightPrimaryMotor().set(0);
    }
}
