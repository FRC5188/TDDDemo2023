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

    private boolean _prevLowerLightSensorReading;
    private boolean _prevShooterLightSensorReading;

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
            if (numBalls == 0) {
                // We have no more balls, so stop trying to shoot
                newState = BallPathState.Stopped;
            }
        }

        return newState;
    }

    public boolean getLowerLightSensorValue() {
        return !(_hardware.getLowerLightSensor().get());
    }

    public boolean getUpperLightSensorValue() {
        return !(_hardware.getUpperLightSensor().get());
    }

    public boolean getShooterLightSensorValue() {
        return !(_hardware.getShooterLightSensor().get());
    }

    public int updateBallCount(BallPathState currentState, int numBalls) {

        //catch an invalid number of balls passed into the system
        if (numBalls > 2 || numBalls < 0) {
            throw new IllegalArgumentException("Invalid number of balls!");
        }

        //check which state the ballpath is in and perform logic from there
        switch (currentState) {
            case Stopped:
                return numBalls;
            case Loading:
                //add one ball when we detect a new ball into the ballpath
                if (lowerLightSensorTransitioned()) {
                    return numBalls + 1;
                }
                return numBalls;
            case Shooting:
                //remove one ball when we detect a ball leaving through the shooter
                if (shooterLightSensorTransitioned()) {
                    return numBalls - 1;
                }
                return numBalls;
            default:
                return numBalls;
        }
    }

    public boolean lowerLightSensorTransitioned() {
        return lightSensorTransitioned(getLowerLightSensorValue(),
                _prevLowerLightSensorReading);
    }

    public boolean shooterLightSensorTransitioned() {
        return lightSensorTransitioned(getShooterLightSensorValue(),
                _prevShooterLightSensorReading);
    }

    public boolean lightSensorTransitioned(boolean currentReading, boolean prevReading) {
        return currentReading ^ prevReading;
    }
}
