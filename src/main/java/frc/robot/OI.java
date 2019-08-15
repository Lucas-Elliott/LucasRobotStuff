/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.AdjustKP;
import frc.robot.commands.AdjustKI;
import frc.robot.commands.AdjustKF;
import frc.robot.commands.DistanceDrive;
//import frc.robot.commands.AdjustTurnSensitivity;
//import frc.robot.commands.TimedDrive;
//import frc.robot.commands.AdjustSensitivity;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  private final Joystick stick = new Joystick(0);

  private final JoystickButton button12 = new JoystickButton(stick, 12);
  private final JoystickButton button8 = new JoystickButton(stick, 8);
  private final JoystickButton button9 = new JoystickButton (stick, 9);
  private final JoystickButton button10 = new JoystickButton (stick, 10);
  private final JoystickButton button6 = new JoystickButton (stick, 6);
  private final JoystickButton button7 = new JoystickButton (stick, 7);
  private final JoystickButton button11 = new JoystickButton (stick, 11);

  public Joystick getStick() {
    return stick;
  }

  public OI() {

    //button12.whenPressed(new TimedDrive(1, 0.5));
    button12.whenPressed(new DistanceDrive(30, 0.5));
    //button7.whenPressed(new AdjustForwardSensitivity(.1));
    //button8.whenPressed(new AdjustForwardSensitivity(-.1));
    //button9.whenPressed(new AdjustTurnSensitivity (.1));
    //button10.whenPressed(new AdjustTurnSensitivity(-.1));
    button6.whenPressed(new AdjustKP(.1));
    button7.whenPressed(new AdjustKP(-.1));
    button8.whenPressed(new AdjustKI(.0005));
    button9.whenPressed(new AdjustKI(-.0005));
    button10.whenPressed(new AdjustKF(.1));
    button11.whenPressed(new AdjustKF(-.1));
  }




  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  // Joystick stick = new Joystick(port);
  // Button button = new JoystickButton(stick, buttonNumber);

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:

  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenPressed(new ExampleCommand());

  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  // button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
