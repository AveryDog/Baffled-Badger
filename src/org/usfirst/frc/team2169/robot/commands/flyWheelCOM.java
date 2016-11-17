
package org.usfirst.frc.team2169.robot.commands;


import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class flyWheelCOM extends Command {
	
	private boolean flywheelRunning;

    public flyWheelCOM() {
        // Use requires() here to declare subsystem dependencies
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	flywheelRunning = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	if(Robot.oi.secondaryStick.getRawButton(1))
    	{
    		if(Robot.flyWheelSubsystem.inRange())
    		{
    			Robot.intakeSubsystem.intake.set(-1);
    			Robot.intakesGo = false;
    			Robot.switchWasPressed = true;
    		} else {
    			Robot.intakesGo = true;
    			//Robot.intakeSubsystem.intake.set(0);
    		}
    	}
    	
    	runFlywheel(Robot.flywheelRunning);
    	
    	
    
    	
    	/*if(Robot.switchWasPressed == true && !(Robot.oi.secondaryStick.getRawAxis(3)>0.8))
		{
			Robot.intakeSubsystem.intake.set(0);
			Robot.switchWasPressed = false;
		}
    	
    	else if(!(Robot.oi.secondaryStick.getRawAxis(3)>0.8))
    	{
    		Robot.flyWheelSubsystem.flyWheelF.set(0);
    		Robot.intakesGo = true;
    	}*/
    	
    	/*if(Robot.oi.secondaryStick.getRawAxis(3)>0.8){
    		Robot.flyWheelSubsystem.flyWheelF.setPID(0.15, 0.0002, 0.0035, 0.000001, 0, 360, 0);
    		Robot.flyWheelSubsystem.flyWheelR.set(9);
    		
    		Robot.flyWheelSubsystem.flyWheelF.set(Robot.value * 6.8);
    		
    		if(Robot.flyWheelSubsystem.inRange())
    		{
    			Robot.intakeSubsystem.intake.set(-1);
    		}
    	} else {
    		Robot.flyWheelSubsystem.flyWheelF.setPID(0.15, 0.0002, 0.0035, 0.000001, 0, 360, 0);
    		Robot.flyWheelSubsystem.flyWheelR.set(9);
    		
    		Robot.flyWheelSubsystem.flyWheelF.set(0);
    		Robot.flyWheelSubsystem.flyWheelR.set(0);
    	}*/
    	
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
    
    public void runFlywheel(boolean x){
    	if(x){
    		Robot.flyWheelSubsystem.flyWheelF.setPID(0.15, 0.0002, 0.0035, 0.000001, 0, 360, 0);
    		Robot.flyWheelSubsystem.flyWheelR.set(9);
    		Robot.flyWheelSubsystem.flyWheelF.set(Robot.value * 6.8);
    	} else {
    		Robot.flyWheelSubsystem.flyWheelF.set(0);
    		//Robot.intakeSubsystem.intake.set(0);
    	}
    }
}
