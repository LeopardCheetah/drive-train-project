package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {

    public static final class Config {

        // cool filler variables :D
        public static final int leftMotorMasterID = 0;
        public static final int rightMotorMasterID = 0;
        public static final int leftMotorSlaveID = 0;
        public static final int rightMotorSlaveID = 0;
    }

    // cool motor assigning :)

    private CANSparkMax RightMasterMotor = new CANSparkMax(Config.rightMotorMasterID, MotorType.kBrushless);
    private CANSparkMax LeftMasterMotor = new CANSparkMax(Config.leftMotorMasterID, MotorType.kBrushless);
    private CANSparkMax RightSlaveMotor = new CANSparkMax(Config.rightMotorSlaveID, MotorType.kBrushless);
    private CANSparkMax LeftSlaveMotor = new CANSparkMax(Config.leftMotorSlaveID, MotorType.kBrushless);

    private DifferentialDrive m_drive = new DifferentialDrive(LeftMasterMotor, RightMasterMotor);

    public DriveTrain () {
        RightMasterMotor.setInverted(true);
        LeftMasterMotor.setInverted(true);
        //??- i dont understand these inversions

        RightSlaveMotor.follow(RightMasterMotor);
        LeftSlaveMotor.follow(LeftMasterMotor);

        //motors follow each other

    }

    //breaking (break driving or smth) (break driving)
    public void breakMode() {
        RightMasterMotor.setIdleMode(IdleMode.kBrake);
        LeftMasterMotor.setIdleMode(IdleMode.kBrake);
        RightSlaveMotor.setIdleMode(IdleMode.kBrake);
        LeftSlaveMotor.setIdleMode(IdleMode.kBrake);
    }

    //cruising mode 
    public void coastMode() {
        RightMasterMotor.setIdleMode(IdleMode.kCoast);
        LeftMasterMotor.setIdleMode(IdleMode.kCoast);
        RightSlaveMotor.setIdleMode(IdleMode.kCoast);
        LeftSlaveMotor.setIdleMode(IdleMode.kCoast);
    }

    public DifferentialDrive returnDiff() {
        return m_drive;

    }

}