// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.controller.PIDController;


import edu.wpi.first.wpilibj2.command.CommandBase;

public class MoveWithPID extends CommandBase {

  public final DriveTrain drivetrain;
  public final double setPoint;
  
  private PIDController m_PIDController = new PIDController( DriveTrain.Config.kP, DriveTrain.Config.kI, DriveTrain.Config.kD );
    

  public MoveWithPID(DriveTrain drivetrain, double setPoint) {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);

    this.drivetrain = drivetrain;
    this.setPoint = setPoint;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.EncoderResetting();
    m_PIDController.setSetpoint(setPoint);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double speed = m_PIDController.calculate(drivetrain.positionPlacement());
    drivetrain.returnDiff().tankDrive(speed, speed, false);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.returnDiff().stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return m_PIDController.atSetpoint();
  }
}
