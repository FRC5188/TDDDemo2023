package ballpath.commands.CmdBallPathDefault;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import edu.wpi.first.hal.HAL;
import frc.robot.ballpath.commands.CmdBallPathDefault;
import frc.robot.ballpath.logic.BallPath;
import frc.robot.hardware.ballpath.SimBallPathHardware;
import utils.CommandTestRunner;

public class CmdBallPathDefaultTests {
    BallPath _ballPath;
    SimBallPathHardware _hardware;
    CommandTestRunner _testRunner;

    @BeforeEach
    void setup() {
        assert HAL.initialize(500, 0); // initialize the HAL, crash if failed

        // Create our sim hardware
        _hardware = new SimBallPathHardware();
        _ballPath = new BallPath(_hardware);
        _testRunner = new CommandTestRunner(new CmdBallPathDefault(_ballPath));
    }

    @Test
    void testCmdBallPathDefault() {
        EasyMock.expect(_hardware.getLowerLightSensor().get()).andReturn(false).times(5);

        _hardware.replayHardware();

        _testRunner.runCommand(5, false);
        _hardware.verifyHardware();
    }
}
