/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import frc.robot.Constants;

public class AdjustTurnSensitivity extends BaseAdjust {
  public AdjustTurnSensitivity(double TSensChange) {
   super(TSensChange);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    Constants.TURN_SENSITIVITY += delta;
    return true;
  }

}