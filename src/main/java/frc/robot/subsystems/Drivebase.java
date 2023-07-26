package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.drivebase.DrivebaseHardware;

public class Drivebase extends SubsystemBase {
    private DrivebaseHardware _hardware;

    public Drivebase(DrivebaseHardware hardware) {
        _hardware = hardware;
    }

    public void arcadeDrive(double throttle, double rotate) {
        // Handle exceptions
        if (throttle < -1 || throttle > 1) {
            throw new IllegalArgumentException("Throttle must be between -1 and 1");
        } else if (rotate < -1 || rotate > 1) {
            throw new IllegalArgumentException("Rotate must be between -1 and 1");
        }

        // Do the basic arcade math
        double left = throttle + rotate;
        double right = throttle - rotate;

        // Do scaling if needed
        double max = Math.max(Math.abs(left), Math.abs(right));
        if (max > 1) {
            left /= max;
            right /= max;
        } 

        // Round our values to the specificity we need
        // This will let our unit tests that use decimals to pass
        left = Math.floor(left * 100) / 100;
        right = Math.floor(right * 100) / 100;

        // Set motor speeds
        _hardware.getLeftPrimaryMotor().set(left);
        _hardware.getRightPrimaryMotor().set(right);
    }
}
