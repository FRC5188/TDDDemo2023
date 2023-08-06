package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.ballpath.BallPathHardware;

public class BallPath extends SubsystemBase {
    public enum BallPathState {
        Stopped,
        Loading,
        Shooting
    }

    private BallPathHardware _hardware;

    public BallPath(BallPathHardware hardware) {
        _hardware = hardware;
    }

    public BallPathState updateBallPathState(BallPathState currentState, int numBalls) {
        if (numBalls < 0 || numBalls > 2) {
            throw new IllegalArgumentException("Ball count must be between 0 and 2");
        }

        BallPathState newState = currentState;

        boolean lower = getLowerLightSensorValue();
        boolean upper = getUpperLightSensorValue();

        switch (currentState) {
            case Stopped:
                if (!lower && !upper) {
                    // We don't see a ball trying to come in so we stay stopped
                    newState = BallPathState.Stopped;
                } else if (lower && upper) {
                    // We see a ball and are holding at least one
                    newState = BallPathState.Stopped;
                }
            default:
                break;
        }
            
        

        return newState;
    }

    public boolean getLowerLightSensorValue() {
        return !(_hardware.getLowerLightSensor().get());
    }

    public boolean getUpperLightSensorValue() {
        return !(_hardware.getUpperLightSensor().get());
    }
}
