/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import frc.robot.Constants;

public class AdjustKP extends BaseAdjust {
  
  public AdjustKP(double deltaKP) {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    super(deltaKP);
  }


  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    Constants.KP += delta;
    return true;
  }
}