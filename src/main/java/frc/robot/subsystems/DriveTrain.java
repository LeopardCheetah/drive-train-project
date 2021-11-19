package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class DriveTrain extends SubsystemBase {

    public static final class Config {

        // cool filler variables :D
        public static final int leftMotorMasterID = 2;
        public static final int rightMotorMasterID = 1;
        // used to be 7

        
        // public static final int leftMotorSlaveID = 0;
        // public static final int rightMotorSlaveID = 0;

        //woah PID commands
        public static final double kI = 0.0;
        public static final double kD = 0.0;
        public static final double kP = 0.0;

    }



    // cool motor assigning :)

    private CANSparkMax RightMasterMotor = new CANSparkMax(Config.rightMotorMasterID, MotorType.kBrushless);
    private CANSparkMax LeftMasterMotor = new CANSparkMax(Config.leftMotorMasterID, MotorType.kBrushless);

    private CANEncoder m_RightEncoder = RightMasterMotor.getEncoder();
    private CANEncoder m_LeftEncoder = LeftMasterMotor.getEncoder(); 

    /*
    private CANSparkMax RightSlaveMotor = new CANSparkMax(Config.rightMotorSlaveID, MotorType.kBrushless);
    private CANSparkMax LeftSlaveMotor = new CANSparkMax(Config.leftMotorSlaveID, MotorType.kBrushless);
    */

    private DifferentialDrive m_drive = new DifferentialDrive(LeftMasterMotor, RightMasterMotor);

    public DriveTrain () {
        RightMasterMotor.setInverted(true);
        LeftMasterMotor.setInverted(true);
        /*??- i dont understand these inversions

        RightSlaveMotor.follow(RightMasterMotor);
        LeftSlaveMotor.follow(LeftMasterMotor);
        */

        //motors follow each other

    }


    public double positionPlacement() {
       // Gets the distance traveled
       return m_RightEncoder.getPosition();
       
       /*
       System.out.println("the right encoder position is at "+m_RightEncoder.getPosition());
       System.out.println("the left encoder position is at "+m_LeftEncoder.getPosition());
       */
    }

    public void EncoderResetting() {
        m_RightEncoder.setPosition(0.0);
        m_LeftEncoder.setPosition(0.0);
    }

    

    //breaking (break driving or smth) (break driving)
    public void breakMode() {
        RightMasterMotor.setIdleMode(IdleMode.kBrake);
        LeftMasterMotor.setIdleMode(IdleMode.kBrake);
        // RightSlaveMotor.setIdleMode(IdleMode.kBrake);
        // LeftSlaveMotor.setIdleMode(IdleMode.kBrake);
    }

    //cruising mode 
    public void coastMode() {
        RightMasterMotor.setIdleMode(IdleMode.kCoast);
        LeftMasterMotor.setIdleMode(IdleMode.kCoast);
        // RightSlaveMotor.setIdleMode(IdleMode.kCoast);
        // LeftSlaveMotor.setIdleMode(IdleMode.kCoast);
    }

    public void upMode() {

    }

    public IdleMode motorType() {
        return LeftMasterMotor.getIdleMode();
    }    

    public DifferentialDrive returnDiff() {
        return m_drive;

    }

}