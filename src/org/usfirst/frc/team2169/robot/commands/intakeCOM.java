
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2169.robot.Robot;

public class intakeCOM extends Command {
	
	public boolean density;
	
	
    public intakeCOM() {
        requires(Robot.intakeSubsystem);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {

    	/*if(Robot.oi.secondaryStick.getRawAxis(1) > .5)
    	{
    		Robot.intakeSubsystem.intake.set(-0.5);
    		density = false;
    	}
    	else if(Robot.oi.leftStick.getRawButton(3)&& Robot.intakeSubsystem.switchTest.get())
    	{
    		Robot.intakeSubsystem.intake.set(-0.5);
    		density = false;
    	}
    	else if (Robot.intakeSubsystem.switchTest.get() == false && density == false)
    	{
    		Robot.intakeSubsystem.intake.set(0);
    		density = true;
    	}
    	else if(Robot.switchWasPressed == true && Robot.oi.secondaryStick.getRawAxis(3)>0.8)
    	{
    		Robot.intakeSubsystem.intake.set(-1);
    	}
    	else
    	{
    		Robot.intakeSubsystem.intake.set(0);
    	}*/
    	
    	//if(Robot.intakesGo){
    		if(Robot.oi.secondaryStick.getRawAxis(1) > .5){
        		Robot.intakeSubsystem.intake.set(-.6);
        		density = false;
        	} else if(Robot.oi.secondaryStick.getRawAxis(1) < -.5){
        		Robot.intakeSubsystem.intake.set(0.6);
        		density = false;
        	} else {
        		Robot.intakeSubsystem.intake.set(0);
        	}
    	//}
    	//Robot.intakeSubsystem.intake.set(Robot.oi.secondaryStick.getRawAxis(1));
    
    	
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
