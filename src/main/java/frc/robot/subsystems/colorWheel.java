
// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import java.util.Random;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class colorWheel extends SubsystemBase {
  public static final class Config {
    // ok so 
    /*
    order of things,(blue, red, green, yellow, blue, red, green, yellow)
                    ( 1, 2 , 3, 4, 5, 6)

    */

    int spaceOne = 1;
    int spaceTwo = 2;
    int spaceThree = 3;
    int spaceFour = 4;
    int spaceFive = 5;
    int spaceSix = 6; 
    int spaceSeven = 7;
    int spaceEight = 8;
    int spaceNumbers = 8;
    // modulus addition
    //4 + space needed = x mod (8)

  }
  /** Creates a new colorWheel. */
  public colorWheel() {
    int ourSpace = Random.nextInt(7)+1;
    int destination = Random.nextInt(7)+1;
    // there are errors up here ^

    if (ourSpace == destination || ourSpace == destination + 4)  {
      System.out.println("No movement needed, already on color");
    } else {
      
      if ((ourSpace - destination) % 4 == 1) {
        System.out.println("Move one space forward lmao");
      } else if ((ourSpace - destination) % 4 == 2) {
        System.out.println("Move two spaces forward (or backward) :)");
      } else if ((ourSpace - destination) % 4 == -1) {
        System.out.println("Move one space backward");
      }

    } 
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
