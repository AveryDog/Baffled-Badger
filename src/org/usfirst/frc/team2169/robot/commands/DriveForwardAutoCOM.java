package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class DriveForwardAutoCOM extends Command {

	private double driveTime;
	private double delayAfterDefense = .5;
	private double accelXLimit = 7.1;
	
    public DriveForwardAutoCOM() {
    	driveTime = 1;
    }
    
    public DriveForwardAutoCOM(double seconds){
    	driveTime = seconds;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.driveTrainSubsystem.leftDriveF.set(-1);
        Robot.driveTrainSubsystem.leftDriveR.set(-1);
        Robot.driveTrainSubsystem.rightDriveF.set(1);
        Robot.driveTrainSubsystem.rightDriveR.set(1);
    	
    	Timer.delay(driveTime);
    	
    	Robot.driveTrainSubsystem.leftDriveF.set(0);
    	Robot.driveTrainSubsystem.leftDriveR.set(0);
    	Robot.driveTrainSubsystem.rightDriveF.set(0);
    	Robot.driveTrainSubsystem.rightDriveR.set(0);
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
