// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.ballpath.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.ballpath.logic.BallPath;

public class CmdBallPathDefault extends CommandBase {
  private BallPath _ballPathSubsystem;
  private int _count;
  /** Creates a new CmdBallPathDefault. */
  public CmdBallPathDefault(BallPath ballPathSubsystem) {
    _ballPathSubsystem = ballPathSubsystem;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    _count = 0;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    _ballPathSubsystem.getLowerLightSensorValue();
    _count++;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return _count >= 5;
  }
}
