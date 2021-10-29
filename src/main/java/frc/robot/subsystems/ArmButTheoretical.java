/* things to do:

- command to go up
- command to go down 
- seperate buttons (2 buttons)



*/








package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmButTheoretical extends SubsystemBase {

  public static final class Config {
    public static final int leftMotorMasterID = 2;
    public static final int armMotorID = 1;

    // filler button vars
  
  }

  private CANSparkMax armMotor = new CANSparkMax(Config.armMotorID, MotorType.kBrushless);
 


  public ArmButTheoretical() {
    // Use addRequirements() here to declare subsystem dependencies.
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void intakeUp(double speed) {
    armMotor.set(speed);
  }

  public void intakeDown(double speed) {
    armMotor.set(-speed);
  }
  
}
