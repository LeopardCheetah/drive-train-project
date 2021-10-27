package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;



//actually makes it a command
public class ArcadeDrive extends CommandBase {
    public static final class Config {
        public static final double speedMulti = 0.8;
        public static final double turnMulti = 0.7;

        // place holders 
        public static final int leftStick = 1;
        public static final int rightStick = 2;

        
    }

    //errors- complex vars 
    private final DriveTrain drivetrain;
    private final Joystick joystickVar;

    public ArcadeDrive (DriveTrain drive, Joystick joystick1) {

        // error here, an requirements thing
        /* 
        basically says if the subsystem != in use, tihis command will work
        */
        drivetrain = drive;
        joystickVar = joystick1;

        addRequirements(drivetrain);

    }

    
    public void initialize() {
        //nothing here usually
    }

    
    public void execute() {
        // speed calculations :OO
        double speedSpeed = joystickVar.getRawAxis(Config.leftStick) * Config.speedMulti;
        double turnSpeed = joystickVar.getRawAxis(Config.rightStick) * Config.turnMulti;

        // speed + turn speed are over here

        drivetrain.returnDiff().arcadeDrive(speedSpeed, turnSpeed);


    }

    public void end(boolean interrupted) {
        drivetrain.returnDiff().stopMotor();

        //to my knowledge this stops the motor .__.
    }

    public boolean isFinished() {
        return false;
        //nothing can be finished 
    }


    



}

