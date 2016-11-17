package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class ExampleAuto extends Command{
	
	Timer time = new Timer();
	boolean drive;
	
	protected void initialize()
	{
		time.start();
		drive = true;
	}
	@Override
	
	protected void execute()
	{
		if(drive == true)
		{
		System.out.println(time.get());
		Robot.driveTrainSubsystem.leftDriveF.set(-1.0);
		Robot.driveTrainSubsystem.leftDriveR.set(-1.0);
		Robot.driveTrainSubsystem.rightDriveF.set(1.0);
		Robot.driveTrainSubsystem.rightDriveR.set(1.0);
		}
		if(time.get() > 2.5)
		{
		drive = false;
		}
		if(drive == false)
		{
			Robot.driveTrainSubsystem.leftDriveF.set(0);
			Robot.driveTrainSubsystem.leftDriveR.set(0);
			Robot.driveTrainSubsystem.rightDriveF.set(0);
			Robot.driveTrainSubsystem.rightDriveR.set(0);
		}
	}
	
	protected boolean isFinished()
	{
		return false;
	}
	
	protected void end()
	{
		
	}
	
	protected void interrupted()
	{
		
	}

}
