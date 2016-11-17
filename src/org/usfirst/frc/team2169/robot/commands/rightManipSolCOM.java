
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2169.robot.Robot;

public class rightManipSolCOM extends Command {
	
	private boolean finished;

    public rightManipSolCOM() {

    }

    protected void initialize() {
    	finished = false;
    }

    protected void execute() {
    	if(Robot.solenoidSubsystem.rightManipulator.get() == DoubleSolenoid.Value.kOff){
    		Robot.solenoidSubsystem.rightManipulator.set(DoubleSolenoid.Value.kForward);
    	}else if(Robot.solenoidSubsystem.rightManipulator.get() == DoubleSolenoid.Value.kForward){
    		Robot.solenoidSubsystem.rightManipulator.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if(Robot.solenoidSubsystem.rightManipulator.get() == DoubleSolenoid.Value.kReverse){
    		Robot.solenoidSubsystem.rightManipulator.set(DoubleSolenoid.Value.kForward);
    	}
    	finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
