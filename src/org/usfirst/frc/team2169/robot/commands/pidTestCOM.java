package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class pidTestCOM extends Command {
	
	private PIDController pidleft = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveF);
	private PIDController pidleft1 = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveR);
	private PIDController pidright = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveF);
	private PIDController pidright1 = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveR);
	
	private double actualAngle;
	private boolean done;
	private boolean set;
	
    public pidTestCOM() {}

    protected void initialize() {
    	actualAngle = 0;
    	Robot.driveTrainSubsystem.gyro.reset();
    	done = false;
    	set = false;
    }

    protected void execute() {
    	
    	if(set == false){
    		Robot.driveTrainSubsystem.gyro.reset();
    		actualAngle = 90;
    		pidleft.setSetpoint(actualAngle);
    		pidleft1.setSetpoint(actualAngle);
    		pidright.setSetpoint(actualAngle);
    		pidright1.setSetpoint(actualAngle);
    		set = true;
    	}
		
    	pidleft.enable();
    	pidleft1.enable();
    	pidright.enable();
    	pidright1.enable();
		
		//if(pidleft.isEnable() && Robot.driveTrainSubsystem.gyro.getRate() < 0 && (pidleft.getSetpoint() - .4 <= Robot.driveTrainSubsystem.gyro.getAngle() && Robot.driveTrainSubsystem.gyro.getAngle() <= pidleft.getSetpoint() + .4)){
			pidleft.disable();
			pidleft1.disable();
			pidright.disable();
			pidright1.disable();
			done = true;
		//}
		
		SmartDashboard.putBoolean("Pid Test Boolean", done);
    }

    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    protected void interrupted() {
    	pidleft.disable();
    	pidleft1.disable();
    	pidright.disable();
    	pidright1.disable();
    }
}
