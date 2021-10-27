package frc.robot.commands;

import com.revrobotics.CANSparkMax.IdleMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;

public class CoastMode extends CommandBase {
  public static final class Config {
    //variables are here :)

    //
  }

  private final DriveTrain driveTraIn;
  
  public CoastMode (DriveTrain dRive) {
    
    driveTraIn = dRive;
    
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    driveTraIn.coastMode();
  }

  
  @Override
  public void end(boolean interrupted) {
    // pls stop
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return driveTraIn.motorType() == IdleMode.kCoast;
  }
}
