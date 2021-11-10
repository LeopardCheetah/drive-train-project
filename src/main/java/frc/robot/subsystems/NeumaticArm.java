// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import jdk.vm.ci.meta.PrimitiveConstant;

public class NeumaticArm extends SubsystemBase {

  public static final class Config {
    public static final int kPCMId = 2;
    public static final int kForwardChannel = 
    public static final int kReverseChannel = 
  }

 private final DoubleSolenoid m_solenoid = new DoubleSolenoid();
  
 private void set(Value v){
  m_solenoid.set(v);
 }

 public void armOut{
   set(Value.kForward);

 }

 public void armIn{
  set(Value.kReverse);
 }
  /** Creates a new NeumaticArm. */
  public NeumaticArm(){ }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
