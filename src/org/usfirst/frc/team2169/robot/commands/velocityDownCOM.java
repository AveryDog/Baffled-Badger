
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2169.robot.Robot;

public class velocityDownCOM extends Command {

	
	public boolean finished;
	
    public velocityDownCOM() {
    }

    protected void initialize() {
    	finished = false;
    }

    protected void execute() {
    	Robot.value -= 50;
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
