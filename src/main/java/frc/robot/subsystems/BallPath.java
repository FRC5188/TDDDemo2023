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

        if (currentState != BallPathState.Shooting) {
            // We aren't shooting, so we are checking light sensors
            boolean lower = getLowerLightSensorValue();
            boolean upper = getUpperLightSensorValue();
    
            switch (currentState) {
                case Stopped:
                    if (lower && numBalls < 2) {
                        // We see a ball trying to come in and
                        // we can hold more so enter loading state
                        newState = BallPathState.Loading;
                    }
                case Loading:
                    if (!lower && upper) {
                        // The ball is in its stopped position so we need to stop the ball path
                        newState = BallPathState.Stopped;
                    }
                default:
                    break;
            }
        } else {
            // We are shooting so we only care about ball count

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
