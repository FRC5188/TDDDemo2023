package ballpath.updateBallCount;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.wpilibj.DigitalInput;

import static org.junit.Assert.assertThrows;

import org.easymock.EasyMock;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import frc.robot.subsystems.BallPath;
import frc.robot.subsystems.BallPath.BallPathState;

public class UpdateBallCountTests {
    BallPath _ballPath;

    @BeforeEach 
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed
        
        // Create our sim hardware
        _ballPath = EasyMock.partialMockBuilder(BallPath.class)
                            .addMockedMethod("lowerLightSensorTransitioned")
                            .addMockedMethod("shooterLightSensorTransitioned")
                            .mock();
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
    void testUpdateBallCount_withCount0StateLoading_expect1() {
        BallPathState currentState = BallPathState.Loading;
        int currentNumBalls = 0;
        EasyMock.expect(_ballPath.lowerLightSensorTransitioned()).andReturn(true);

        int expectedNumBalls = 1;

        replayMocks();

        assertEquals(expectedNumBalls, _ballPath.updateBallCount(currentState, currentNumBalls));
        verifyMocks();
    }
}
