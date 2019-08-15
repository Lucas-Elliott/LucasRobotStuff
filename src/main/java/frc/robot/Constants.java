/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * Add your docs here.
 */
public class Constants {
    //Sensitivities for Turning and Driving
    public static double FORWARD_SENSITIVITY = 2.0;
    public static double TURN_SENSITIVITY = 3.0;
    
    //Speed Multipliers for Turning and Driving
    public static double TURNGAIN = 1.0;
    public static double FORWARDGAIN = 1.0;
    
    
    //Proportional Adjustment for Error (Tune Second)
    public static double KP = 1.5;
    
    // Integral under the Curve of the Error (Tune Third)
    public static double KI = 0;

    //First Guess on Speed (Tune First)
    public static double KF = 4.4;

    //Maximum Velocity of the Robot
    public static double MAX_VELOCITY = 230;

    //Threshold for Actual Movement of the Joystick (Dead zone)
    public static final double DEADBAND = 0.05;
}
