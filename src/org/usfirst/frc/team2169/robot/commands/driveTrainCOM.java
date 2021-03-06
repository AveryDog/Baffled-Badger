
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2169.robot.Robot;

/**
 *
 */
public class driveTrainCOM extends Command {

    public driveTrainCOM() {
        // Use requires() here to declare subsystem dependencies
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//if(Robot.primaryControlled){
    		Robot.driveTrainSubsystem.leftDriveF.set(Robot.oi.leftStick.getY());
    		Robot.driveTrainSubsystem.leftDriveR.set(Robot.oi.leftStick.getY());
    		Robot.driveTrainSubsystem.rightDriveF.set(-Robot.oi.rightStick.getY());
    		Robot.driveTrainSubsystem.rightDriveR.set(-Robot.oi.rightStick.getY());
    	//}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
