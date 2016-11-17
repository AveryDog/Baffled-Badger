
package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2169.robot.Robot;

public class ExampleCommand extends Command {

	public int distance;
    public ExampleCommand(int x) {
        //requires(Robot.exampleSubsystem);
        distance = x;
    }

    protected void initialize() {
    }

    protected void execute() {
    	while((Robot.driveTrainSubsystem.leftEncoder.get() + Robot.driveTrainSubsystem.rightEncoder.get()) / 2 < distance){
    		Robot.driveTrainSubsystem.leftDriveF.set(1);
    		Robot.driveTrainSubsystem.leftDriveR.set(1);
    		Robot.driveTrainSubsystem.rightDriveF.set(-1);
    		Robot.driveTrainSubsystem.rightDriveR.set(-1);
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
