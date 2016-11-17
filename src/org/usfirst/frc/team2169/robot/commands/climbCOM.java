
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.Joystick.RumbleType;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2169.robot.Robot;

public class climbCOM extends Command {

    public climbCOM() {
    }

    protected void initialize() {
    }

    protected void execute() {
    //if(Robot.oi.secondaryStick.getPOV() == 0)
    //{
    //	Robot.endGameSubsystem.claw.setPID(0.05, 0.0002, 0.0005);
    //	//Robot.endGameSubsystem.claw.set();
    //}
    if(Robot.oi.secondaryStick.getRawButton(3))
    {
    	if(Robot.endGameSubsystem.winch.getEncPosition() > -35000){
    		Robot.endGameSubsystem.winch.set(-1);
    	} 
    }
    else if(Robot.oi.secondaryStick.getRawButton(2))
    {
    	if(Robot.endGameSubsystem.winch.getEncPosition() < 0){
    		Robot.endGameSubsystem.winch.set(.6);
    	}
    }
    else
    {
    	Robot.endGameSubsystem.winch.set(0);
    }
    
    if(Robot.oi.secondaryStick.getRawButton(8))
    {
    	Robot.endGameSubsystem.claw.set(-1);
    	//Robot.oi.secondaryStick.setRumble(RumbleType.kLeftRumble, 1);
    }else {
    	Robot.endGameSubsystem.claw.set(0);
    	//Robot.oi.secondaryStick.setRumble(RumbleType.kLeftRumble, 0);
    }
    
   }
    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
