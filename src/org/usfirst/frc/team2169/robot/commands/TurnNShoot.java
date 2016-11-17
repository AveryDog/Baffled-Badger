package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TurnNShoot extends Command {

	private PIDController pidleft = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveF);
	private PIDController pidleft1 = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveR);
	private PIDController pidright = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveF);
	private PIDController pidright1 = new PIDController(-0.014,-0.00296,-.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveR);
	
	private Timer time;
	
	private double actualAngle;
	private boolean done;
	private boolean set;
	private boolean aimed;
	private boolean enabled;
	
    public TurnNShoot() {
    }

    protected void initialize() {
    	time = new Timer();
    	actualAngle = 0;
    	Robot.driveTrainSubsystem.gyro.reset();
    	done = false;
    	set = false;
    	aimed = false;
    	enabled = false;
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
		
    	if(set && enabled == false){
    		pidleft.enable();
        	pidleft1.enable();
        	pidright.enable();
        	pidright1.enable();
        	enabled = true;
    	}
		
		if(pidleft.isEnable() && Robot.driveTrainSubsystem.gyro.getRate() < .05 && (pidleft.getSetpoint() - .1 <= Robot.driveTrainSubsystem.gyro.getAngle() && Robot.driveTrainSubsystem.gyro.getAngle() <= pidleft.getSetpoint() + .1)){
			pidleft.disable();
			pidleft1.disable();
			pidright.disable();
			pidright1.disable();
			aimed = true;
			
			//buffer
			time.delay(.1);
		}
		
		if(aimed){
			Robot.flyWheelSubsystem.flyWheelF.setPID(0.15, 0.0002, 0.0035, 0.000001, 0, 360, 0);
			Robot.value = /***EQUATION***/1000;
			Robot.flyWheelSubsystem.flyWheelF.set(Robot.value * 6.8);
			
			if(Robot.flyWheelSubsystem.inRange()){
    			Robot.intakeSubsystem.intake.set(-1);
    			
    			//gives one second buffer for robot to shoot ball out of intakes
    			time.delay(1.2);
    			
    			done = true;
    			Robot.value = 0;
    			Robot.flyWheelSubsystem.flyWheelF.set(Robot.value * 6.8);
    			Robot.intakeSubsystem.intake.set(0);
    			Robot.primaryControlled = true;
    		}
		}
		
    }
    protected boolean isFinished() {
        return done;
    }

    protected void end() {}

    protected void interrupted() {
    	pidleft.disable();
    	pidleft1.disable();
    	pidright.disable();
    	pidright1.disable();
    }
}
