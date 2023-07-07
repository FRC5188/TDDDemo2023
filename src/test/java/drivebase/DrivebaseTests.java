package drivebase;
import edu.wpi.first.hal.HAL;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.revrobotics.CANSparkMax;
import frc.robot.hardware.drivebase.SimDrivebaseHardware;
import frc.robot.subsystems.Drivebase;

class DrivebaseTests {
    static final double DELTA = 1e-2; // acceptable deviation range

    SimDrivebaseHardware _hardware;
    Drivebase _drivebase;
    CANSparkMax _leftMotor;
    CANSparkMax _rightMotor;

    @BeforeEach 
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        
        // Create our sim hardware
        _hardware = new SimDrivebaseHardware();
        _drivebase = new Drivebase(_hardware);
    }

    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    @AfterEach
    void shutdown() throws Exception {
        
    }

    @Test 
    public void testArcadeDrive_withThrottleNeg1Point01Rotate1_expectIllegalArgumentException() {
        double throttle = -1.01;
        double rotate = 1;

        // Here we call a hardware method called replayHardware()
        // This causes EasyMock to run all of the stuff we just recorded
        _hardware.replayHardware();

        // Here is where we call the method under test
        // If we are expecting an exception, it is ok to have an assertion here
        assertThrows(IllegalArgumentException.class, 
            () -> _drivebase.arcadeDrive(throttle, rotate));

        // Here is where we make assertions about behavior and call verifyHardware()
        // In this test, we expect exceptions, so we only have the one assertion above
        // So we will only call verifyHardware() here
        _hardware.verifyHardware();
    }

    @Test 
    public void testArcadeDrive_withThrottle1Point01Rotate0_expectIllegalArgumentException() {
        double throttle = 1.01;
        double rotate = 0;

        // Here we call a hardware method called replayHardware()
        // This causes EasyMock to run all of the stuff we just recorded
        _hardware.replayHardware();

        // Here is where we call the method under test
        // If we are expecting an exception, it is ok to have an assertion here
        assertThrows(IllegalArgumentException.class, 
            () -> _drivebase.arcadeDrive(throttle, rotate));

        // Here is where we make assertions about behavior and call verifyHardware()
        // In this test, we expect exceptions, so we only have the one assertion above
        // So we will only call verifyHardware() here
        _hardware.verifyHardware();
    }

    @Test 
    public void testArcadeDrive_withThrottle0RotateNeg1Point01_expectIllegalArgumentException() {
        double throttle = 0;
        double rotate = -1.01; 

        // Here we call a hardware method called replayHardware()
        // This causes EasyMock to run all of the stuff we just recorded
        _hardware.replayHardware();

        // Here is where we call the method under test
        // If we are expecting an exception, it is ok to have an assertion here
        assertThrows(IllegalArgumentException.class, 
            () -> _drivebase.arcadeDrive(throttle, rotate));

        // Here is where we make assertions about behavior and call verifyHardware()
        // In this test, we expect exceptions, so we only have the one assertion above
        // So we will only call verifyHardware() here
        _hardware.verifyHardware();
    }

    @Test 
    public void testArcadeDrive_withThrottle1Rotate1Point01_expectIllegalArgumentException() {
        double throttle = 1;
        double rotate = 1.01; 

        // Here we call a hardware method called replayHardware()
        // This causes EasyMock to run all of the stuff we just recorded
        _hardware.replayHardware();

        // Here is where we call the method under test
        // If we are expecting an exception, it is ok to have an assertion here
        assertThrows(IllegalArgumentException.class, 
            () -> _drivebase.arcadeDrive(throttle, rotate));

        // Here is where we make assertions about behavior and call verifyHardware()
        // In this test, we expect exceptions, so we only have the one assertion above
        // So we will only call verifyHardware() here
        _hardware.verifyHardware();
    }

    @Test 
    public void testArcadeDrive_withThrottleNeg1RotateNeg1_expectLeftNeg1Right0() {
        double throttle = -1;
        double rotate = -1;

        // Here is where we tell EasyMock our expected behavior for our sim hardware
        // This is called recording
        _hardware.getLeftPrimaryMotor().set(-1);
        _hardware.getRightPrimaryMotor().set(0);

        // Here we call a hardware method called replayHardware()
        // This causes EasyMock to run all of the stuff we just recorded
        _hardware.replayHardware();

        // Here is where we call the method under test
        _drivebase.arcadeDrive(throttle, rotate);

        // Here is where we make assertions about behavior and call verifyHardware()
        // In this test, our assertions are handled by EasyMock, since
        // we tell it that we expect our motors will be set to 0.
        // So we will only call verifyHardware()
        _hardware.verifyHardware();
    }
}
