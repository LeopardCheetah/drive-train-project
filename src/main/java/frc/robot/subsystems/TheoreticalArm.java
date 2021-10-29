/* 
package frc.robot.subsystems;
import frc.robot.RobotContainer;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class TheoreticalArm extends CommandBase {

  public static final class Config {
    public static final int leftMotorMasterID = 2;

    // filler button vars
    
    
  }


  
  public void setLeftMotor(double speed) {
    armMotor.set(speed);
}


  public TheoreticalArm() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  
  @Override
  public void initialize() {}

  
  @Override
  public void execute() {
    // if specific button pressed; make motor go up/down
    if (RobotContainer.m_upButton.whenPressed()) {
      setLeftMotor(0.5);
    } else if (RobotContainer.m_downButton.whenPressed()) {
      setRig
    }
    

    
  }

 
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
*/