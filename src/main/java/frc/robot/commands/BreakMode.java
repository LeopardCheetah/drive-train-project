package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class BreakMode extends CommandBase {
  public static final class Config {
    
  }
   
  private final DriveTrain drivetrain;

  public BreakMode (DriveTrain drivey) {
    drivetrain = drivey;


  }


  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.breakMode();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return drivetrain.motorType() == IdleMode.kBrake;
  }
}
