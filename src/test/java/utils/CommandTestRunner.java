package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.easymock.EasyMock;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class CommandTestRunner {
    private CommandBase _commandToTest;

    public CommandTestRunner(CommandBase commandToTest) {
        _commandToTest = commandToTest;
    }

    public void runCommand(int numExecLoopsExpected, boolean isDefaultCommand) {
        // Run the command just like the scheduler
        _commandToTest.initialize();

        int loopCount = 0;
        while (!_commandToTest.isFinished()) {
            // Kill this loop in case isFinished isn't triggering 
            // so we don't get stuck in an infinite loop
            if (loopCount > numExecLoopsExpected) {
                fail("Execute loop count exceeded expected loop count. " 
                + "Check if your isFinished condition is valid");
            }

            _commandToTest.execute();
            loopCount++;

            if (isDefaultCommand && loopCount >= numExecLoopsExpected) {
                break;
            }
        }

        if (isDefaultCommand) {
            _commandToTest.end(true);
        } else {
            _commandToTest.end(false);
        }

        // Verify expected calls were made
        // and that loop executed expected num of times
        assertEquals(numExecLoopsExpected, loopCount);
    }
}
