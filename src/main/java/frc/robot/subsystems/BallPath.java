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
        throw new IllegalArgumentException("Ball count must be positive");
    }
}
