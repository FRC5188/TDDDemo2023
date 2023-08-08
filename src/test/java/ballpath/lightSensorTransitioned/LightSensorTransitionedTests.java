package ballpath.lightSensorTransitioned;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;
// Make sure this import is org.junit.jupiter.api.Test, not org.junit.Test
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import edu.wpi.first.hal.HAL;
import frc.robot.hardware.ballpath.SimBallPathHardware;
import frc.robot.subsystems.BallPath;

public class LightSensorTransitionedTests {
    BallPath _ballPath;
    SimBallPathHardware _hardware;

    @BeforeEach 
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        
        // Create our sim hardware
        _hardware = new SimBallPathHardware();
        _ballPath = new BallPath(_hardware);
    }

    void replayMocks() {
        EasyMock.replay(_ballPath);
    }

    void verifyMocks() {
        EasyMock.verify(_ballPath);
    }

    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    @AfterEach
    void shutdown() throws Exception {
        
    }

    @Test
    void testLightSensorTransitioned_withCurrentFalsePrevFalse_expectFalse() {
        // Set up test parameters
        boolean currentReading = false;
        boolean prevReading = false;

        // Set expected outputs
        boolean expected = false;

        // Run test
        assertEquals(expected, _ballPath.lightSensorTransitioned(currentReading, prevReading));
    }

    @Test
    void testLightSensorTransitioned_withCurrentFalsePrevTrue_expectTrue() {
        // Set up test parameters
        boolean currentReading = false;
        boolean prevReading = true;

        // Set expected outputs
        boolean expected = true;

        // Run test
        assertEquals(expected, _ballPath.lightSensorTransitioned(currentReading, prevReading));
    }
}
