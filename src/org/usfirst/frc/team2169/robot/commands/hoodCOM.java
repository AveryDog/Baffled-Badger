
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc.team2169.robot.Robot;

public class hoodCOM extends Command {
	
	public boolean finished;
    public hoodCOM() {
          
    }

    protected void initialize() {
    	Robot.solenoidSubsystem.hoodManipulator.set(Value.kReverse);
    	finished = false;
    }

    protected void execute() {
    	if(Robot.solenoidSubsystem.hoodManipulator.get() == DoubleSolenoid.Value.kOff){
    		Robot.solenoidSubsystem.hoodManipulator.set(DoubleSolenoid.Value.kForward);
    	}else if(Robot.solenoidSubsystem.hoodManipulator.get() == DoubleSolenoid.Value.kForward){
    		Robot.solenoidSubsystem.hoodManipulator.set(DoubleSolenoid.Value.kReverse);
    	}
    	else if(Robot.solenoidSubsystem.hoodManipulator.get() == DoubleSolenoid.Value.kReverse){
    		Robot.solenoidSubsystem.hoodManipulator.set(DoubleSolenoid.Value.kForward);
    	}
    	finished = true;
    }

    protected boolean isFinished() {
        return finished;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
