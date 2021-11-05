// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;



import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;

import frc.robot.commands.ArcadeDrive;
import frc.robot.subsystems.DriveTrain;
import frc.robot.commands.CoastMode;
import frc.robot.commands.MoveWithPID;
import frc.robot.commands.BreakMode;

//import frc.robot.subsystems.ArmButTheoretical;
/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  public static final class Config {
    // not a filler var
    public static final int joystickPort = 1;
    public static final int breakButton = 9;
    public static final int coastButton = 8;
    public static final int upButton = 7;
    public static final int downButton = 6;
    public static final int PIDButton = 5;
  }

  // cool command vars

  public final DriveTrain m_DriveTrain = new DriveTrain();
  public final Joystick m_Joystick = new Joystick(Config.joystickPort);


  public final ArcadeDrive m_ArcadeDrive = new ArcadeDrive(m_DriveTrain, m_Joystick);
  public final CoastMode CoastMode = new CoastMode(m_DriveTrain);
  public final BreakMode BreakMode = new BreakMode(m_DriveTrain);


  public final JoystickButton m_upButton = new JoystickButton(m_Joystick, Config.upButton);
  public final JoystickButton m_downButton = new JoystickButton(m_Joystick, Config.downButton);

  private final JoystickButton m_breakButton = new JoystickButton(m_Joystick, Config.breakButton);
  private final JoystickButton m_coastButton = new JoystickButton(m_Joystick, Config.coastButton);
  private final JoystickButton m_PIDButton = new JoystickButton(m_Joystick, Config.PIDButton);
  // The robot's subsystems and commands are defined here...
  



  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
    
  }

  public Command teleop() {
    m_DriveTrain.setDefaultCommand(m_ArcadeDrive);
    return m_ArcadeDrive;
  }
  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {

    m_breakButton.whenPressed(new BreakMode(m_DriveTrain));
    m_coastButton.whenPressed(new CoastMode(m_DriveTrain));
    m_PIDButton.whenPressed(new MoveWithPID(m_DriveTrain, 5.0));
    // m_upButton.whenPressed();
  }

  


  //speed definition

  //public void setLeftMotor(double speed) {
  //  ArmButTheoretical.armMotor.set(speed);
  //}

  
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  
}
