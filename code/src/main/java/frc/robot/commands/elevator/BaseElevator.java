/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class BaseElevator extends Command {

  public BaseElevator() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.elevator);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    // Update PID coefficients
    Robot.elevator.getPIDController().setP(SmartDashboard.getNumber("ElevatorP", RobotMap.kP));
    Robot.elevator.getPIDController().setI(SmartDashboard.getNumber("ElevatorI", RobotMap.kI));
    Robot.elevator.getPIDController().setD(SmartDashboard.getNumber("ElevatorD", RobotMap.kD));
    // Update tolerance
    Robot.elevator.setAbsoluteTolerance(SmartDashboard.getNumber("ElevatorTolerance", RobotMap.elevatorTolerance));
    System.out.println("Elevator Command starting");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.elevator.setSpeed(0.0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    this.end();
  }

}
