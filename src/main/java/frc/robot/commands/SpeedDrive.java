/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.Robot;

public class SpeedDrive extends Command {
  public SpeedDrive() {
    requires(Robot.m_drive);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double stickY = - Robot.m_oi.getStick().getY();
    double stickTwist = - Robot.m_oi.getStick().getTwist();
    
    //Used to determine signs when using exponents
    double ySign = (stickY > 0) ? 1.0 : -1.0;
    double twistSign = (stickTwist > 0) ? 1.0 : -1.0;

    double useY = (Math.abs(stickY) < Constants.DEADBAND) ? 0.0 :
      (Math.abs(stickY) - Constants.DEADBAND) / (1.0 - Constants.DEADBAND);
    double useTwist = (Math.abs(stickTwist) < Constants.DEADBAND) ? 0.0 :
      (Math.abs(stickTwist) - Constants.DEADBAND) / (1.0 - Constants.DEADBAND);

    double powerForward = Math.pow(useY, Constants.FORWARD_SENSITIVITY) * ySign;
    double powerTwist = Math.pow(useTwist, Constants.TURN_SENSITIVITY) * twistSign;

    

    Robot.m_drive.setArcadeSpeed(powerForward, powerTwist);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
