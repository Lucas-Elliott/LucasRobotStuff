/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;
import frc.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
//import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.SpeedDrive;

import com.ctre.phoenix.motorcontrol.ControlMode;

/**
 * Add your docs here.
 */
public class Drive extends Subsystem {

  public static final double TICKS_PER_INCH = 25.6;
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  final public WPI_TalonSRX
  rightMaster = new WPI_TalonSRX(RobotMap.rightMaster),
  rightSlave2 = new WPI_TalonSRX(RobotMap.rightSlave2),
  rightSlave3 = new WPI_TalonSRX(RobotMap.rightSlave3),
  leftMaster = new WPI_TalonSRX(RobotMap.leftMaster),
  leftSlave2 = new WPI_TalonSRX(RobotMap.leftSlave2),
  leftSlave3 = new WPI_TalonSRX(RobotMap.leftSlave3);

  private double rightTargetVelocity = 0;
  private double leftTargetVelocity = 0; 

  public Drive() {
    super();
    //constructs and configures all six drive motors
    // restore everything to known factory default state
    rightMaster.configFactoryDefault();
    rightSlave2.configFactoryDefault();
    rightSlave3.configFactoryDefault();
    leftMaster.configFactoryDefault();
    leftSlave2.configFactoryDefault();
    leftSlave3.configFactoryDefault();
    // now configure them
    rightSlave2.follow(rightMaster);
    rightSlave3.follow(rightMaster);
    leftSlave2.follow(leftMaster);
    leftSlave3.follow(leftMaster);
    rightSlave2.setInverted(InvertType.FollowMaster);
    rightSlave3.setInverted(InvertType.FollowMaster);
    leftSlave2.setInverted(InvertType.FollowMaster);
    leftSlave3.setInverted(InvertType.FollowMaster);
    setNeutralMode(NeutralMode.Brake);
    rightMaster.setInverted(InvertType.InvertMotorOutput);
    configMaster(rightMaster);
    configMaster(leftMaster);
    
    
  
  }

  private void configMaster(TalonSRX master){
  master.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative);
  configPID(master);
  }

  private void configPID(TalonSRX master){
  master.config_kF(0, Constants.KF);
  master.config_kP(0, Constants.KP);
  master.config_kI(0, Constants.KI);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SpeedDrive());
  }


  public void setNeutralMode(NeutralMode mode) {
 //method to easily set the neutral mode of all of the driveTrain motors
  rightMaster.setNeutralMode(mode);
  rightSlave2.setNeutralMode(mode);
  rightSlave3.setNeutralMode(mode);
  leftMaster.setNeutralMode(mode);
  leftSlave2.setNeutralMode(mode);
  leftSlave3.setNeutralMode(mode);
  }

  public void setPower(double power) {
    rightMaster.set(power);
    leftMaster.set(power);
  }

  public void setPower(double leftPower, double rightPower) {
    rightMaster.set(rightPower);
    leftMaster.set(leftPower);
  }

  public void setArcadePower(double forward, double rotate) {
    double max = Math.abs(forward) + Math.abs(rotate);
    double scale = (max <= 1.0) ? 1.0 : (1.0 / max);
    rightMaster.set(scale * (forward + rotate));
    leftMaster.set(scale * (forward - rotate));
  }

  public void setArcadeSpeed(double forward, double rotate) {
    double max = Math.abs(forward) + Math.abs(rotate);
    double scale = (max <= 1.0) ? 1.0 : (1.0 / max);
    configPID(rightMaster);
    configPID(leftMaster);
    rightTargetVelocity = scale * (forward + rotate) * Constants.MAX_VELOCITY;
    leftTargetVelocity = scale * (forward - rotate) * Constants.MAX_VELOCITY;
    
    rightMaster.set(ControlMode.Velocity, rightTargetVelocity);
    leftMaster.set(ControlMode.Velocity, leftTargetVelocity);
   
  }



  public double getLeftPosition() {
    return leftMaster.getSelectedSensorPosition();
  }

  public double getRightPosition() {
    return rightMaster.getSelectedSensorPosition();
  }

  public double getRightVelocity() {
    return rightMaster.getSelectedSensorVelocity();
  }

  public double getLeftVelocity() {
    return leftMaster.getSelectedSensorVelocity();
  }

  public double getRightTargetVelocity() {
    return rightTargetVelocity;
  }

  public double getLeftTargetVelocity() {
    return leftTargetVelocity;
  }

  public void resetEncoders() {
    rightMaster.setSelectedSensorPosition(0, 0, 10);
    leftMaster.setSelectedSensorPosition(0, 0, 10);
  }

  public void resetIntegral() {
    rightMaster.setIntegralAccumulator(0);
    leftMaster.setIntegralAccumulator(0);
  }


}


