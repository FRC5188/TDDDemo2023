package ballpath;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DigitalInput;

import static org.junit.Assert.assertThrows;

import org.easymock.EasyMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frc.robot.hardware.ballpath.SimBallPathHardware;
import frc.robot.subsystems.BallPath;
import frc.robot.subsystems.BallPath.BallPathState;

public class BallPathTests {
    SimBallPathHardware _hardware;
    BallPath _ballPath;
    DigitalInput _lowerLightSensor;
    DigitalInput _upperLightSensor;

    @BeforeEach 
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        
        // Create our sim hardware
        _hardware = new SimBallPathHardware();
        _ballPath = new BallPath(_hardware);
    }

    @SuppressWarnings("PMD.SignatureDeclareThrowsException")
    @AfterEach
    void shutdown() throws Exception {
        
    }

    @Test
    void testUpdateBallPathState_withNeg1Balls_expectIllegalArgumentException() {
        BallPathState currentState = BallPathState.Stopped;
        int numBalls = -1;

        _hardware.replayHardware();

        assertThrows(IllegalArgumentException.class, () -> _ballPath.updateBallPathState(currentState, numBalls));
        _hardware.verifyHardware();
    }

    @Test
    void testUpdateBallPathState_with3Balls_expectIllegalArgumentException() {
        BallPathState currentState = BallPathState.Stopped;
        int numBalls = 3;

        _hardware.replayHardware();

        assertThrows(IllegalArgumentException.class, () -> _ballPath.updateBallPathState(currentState, numBalls));
        _hardware.verifyHardware();
    }

    @Test
    void testUpdateBallPathState_with0BallsStoppedLowFalseUpFalse_expectStopped() {
        BallPathState currentState = BallPathState.Stopped;
        int numBalls = 0;

        // This is how we tell EasyMock to expect a function call that returns something
        // And in the .andReturn() we tell it what value to return
        // For these light sensors, have it return false when it sees something and true otherwise
        EasyMock.expect(_hardware.getLowerLightSensor().get()).andReturn(true);
        EasyMock.expect(_hardware.getUpperLightSensor().get()).andReturn(true);

        _hardware.replayHardware();

        assertEquals(BallPathState.Stopped, _ballPath.updateBallPathState(currentState, numBalls));
        _hardware.verifyHardware();
    }
}
