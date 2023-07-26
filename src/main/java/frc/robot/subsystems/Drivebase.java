package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.drivebase.DrivebaseHardware;

public class Drivebase extends SubsystemBase {
    private DrivebaseHardware _hardware;

    public Drivebase(DrivebaseHardware hardware) {
        _hardware = hardware;
    }

    public void arcadeDrive(double throttle, double rotate) {
        if (throttle < -1 || throttle > 1) {
            throw new IllegalArgumentException("Throttle must be between -1 and 1");
        } else if (rotate < -1 || rotate > 1) {
            throw new IllegalArgumentException("Rotate must be between -1 and 1");
        }

        double left = throttle + rotate;
        double right = throttle - rotate;

        if (left < -1) {
            left = -1;
        } else if (left > 1) {
            left = 1;
        } 

        if (right < -1) {
            right = -1;
        } else if (right > 1) {
            right = 1;
        }

        _hardware.getLeftPrimaryMotor().set(left);
        _hardware.getRightPrimaryMotor().set(right);
    }
}
