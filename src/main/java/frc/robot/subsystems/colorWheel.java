package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import java.util.concurrent.ThreadLocalRandom;

// nextInt is normally exclusive of the top value,
// so add 1 to make it inclusive


public class ColorWheel extends SubsystemBase {
  public class Config {
    // ok so 
    /*
    order of things,(blue, red, green, yellow, blue, red, green, yellow)
                    ( 1, 2 , 3, 4, 5, 6)

    */

    // so it turns out that this part isnt needed smh me

    /*
    int spaceOne = 1;
    int spaceTwo = 2;
    int spaceThree = 3;
    int spaceFour = 4;
    int spaceFive = 5;
    int spaceSix = 6; 
    int spaceSeven = 7;
    int spaceEight = 8;
    int spaceNumbers = 8;
    */

    
    // modulus addition
    //4 + space needed = x mod (8)
    
  }
  /** Creates a new colorWheel. */
  public ColorWheel() {
    //so uh this part is kind of bad bc it screws itself but Main() or main() doesnt work ;-;
 
    
    int ourSpace = ThreadLocalRandom.current().nextInt(1, 11+1)+1;
    int destination = ThreadLocalRandom.current().nextInt(1, 11+1)+1;

    System.out.println("");
    System.out.println("");
    System.out.println("Our space/color that we started on is "+ourSpace);
    System.out.println("The space/color that we want to get to is "+destination);


    if (ourSpace < destination) {
      destination = destination - 4;
    }
    // ahahaha ineffecient code dont u love it <3
    if (ourSpace == destination || ourSpace == destination + 4)  {
      System.out.println("No movement needed, already on color");
    } else {
      
      if ((ourSpace - destination) % 4 == 1) {
        System.out.println("Move one space backward lmao");
      } else if ((ourSpace - destination) % 4 == 2) {
        System.out.println("Move two spaces forward (or backward) :)");
      } else if ((ourSpace - destination) % 4 == 3 ) {
        System.out.println("Move one space forward");
      }

    } 
  }
}
