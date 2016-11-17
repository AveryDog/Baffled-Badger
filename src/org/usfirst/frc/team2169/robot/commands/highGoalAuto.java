package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

public class highGoalAuto extends Command{

	private PIDController pidleft = new PIDController(-0.014,-0.00275,-0.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveF);
	private PIDController pidleft1 = new PIDController(-0.014,-0.00275,-0.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.leftDriveR);
	private PIDController pidright = new PIDController(-0.014,-0.00275,-0.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveF);
	private PIDController pidright1 = new PIDController(-0.014,-0.00275,-0.13,Robot.driveTrainSubsystem.gyro,Robot.driveTrainSubsystem.rightDriveR);
	private Timer time;
	
	private String com;
	private String angleS;
	private String distanceS;
	
	private double angle;
	private double flyWheelVal;
	
	private int characterPos;
	private boolean setpoint;
	private boolean enabled;
	private boolean disabled;
	private boolean done;
	private boolean timed;
	
    public highGoalAuto() {}

    protected void initialize() {
    	angleS = "";
    	distanceS = "";
    	setpoint = true;
    	enabled = true;
    	disabled = false;
    	done = false;
    	timed = false;
    	//driveForward = false;
    }

    protected void execute() {
    	//data output
    	//SmartDashboard.putString("angleS: ", angleS);
    	//SmartDashboard.putString("distanceS: ", distanceS);
    	
    	/*Drive over defenses
    	if(driveForward == false){
    		time.start();
    		Robot.driveTrainSubsystem.leftDriveF.set(1);
    		Robot.driveTrainSubsystem.leftDriveR.set(1);
    		Robot.driveTrainSubsystem.rightDriveF.set(-1);
    		Robot.driveTrainSubsystem.rightDriveR.set(-1);
    	}
    	
    	if(time.get() > 2 && driveForward == false){
    		Robot.driveTrainSubsystem.leftDriveF.set(0);
    		Robot.driveTrainSubsystem.leftDriveR.set(0);
    		Robot.driveTrainSubsystem.rightDriveF.set(0);
    		Robot.driveTrainSubsystem.rightDriveR.set(0);
    		driveForward = true;
    		time.reset();
    	}*/
    	
    	//starts vision code
    	Robot.serial.writeString("begin");
    	
    	//reads the string from the serial port
		com = Robot.serial.readString();
		characterPos = com.indexOf("*");
		
		//if there is a target(string is filled with data), assign string values to separated strings
		if(com.isEmpty() == false)
		{
			//separates com string for angle and distance
			angleS = com.substring(0, characterPos);
			distanceS = com.substring(characterPos + 1, com.length());
			
			Robot.robotAngle = Float.valueOf(angleS);
			Robot.visionDistance = Float.valueOf(distanceS);
			setpoint = false;
		}
		
		//grabs angle once and enables pid to follow that one angle that one time
		if(setpoint == false){
			angle = Robot.robotAngle.doubleValue();
			pidleft.setSetpoint(angle);
			pidleft1.setSetpoint(angle);
			pidright.setSetpoint(angle);
			pidright1.setSetpoint(angle);
			setpoint = true;
			enabled = false;
		}
		
		//enable turning
		if(setpoint && enabled == false){
			pidleft.enable();
			pidleft1.enable();
			pidright.enable();
			pidright1.enable();
		
			enabled = true;
		}
		
		//when in range and slow, disable
		//if(enabled && pidleft.isEnable() && disabled == false && (angle - 1 < Robot.driveTrainSubsystem.gyro.getAngle() && angle + 1 > Robot.driveTrainSubsystem.gyro.getAngle())){
			pidleft.disable();
			pidleft1.disable();
			pidright.disable();
			pidright1.disable();
			disabled = true;
		//}
		
		//when disabled(or in line with target), pass distance into equation and shoot
		if(disabled){
			//pass in distance
			flyWheelVal = /****EQUATION****/ 400;
			Robot.flyWheelSubsystem.flyWheelF.set(flyWheelVal * 6.8);
			
			if(Robot.flyWheelSubsystem.inRange() && timed == false){
    			Robot.intakeSubsystem.intake.set(-1);
    			//gives one second buffer for robot to shoot ball out of intakes
    			time.start();
    			if(time.get() > 1){
    				timed = true;
    				time.reset();
    			}
    		} else if(timed == true){
    			//finished and shot ball at goal
    			done = true;
    		}
		}
		
		//stops feeding data to robot when shot has been taken
		if(done){
			Robot.serial.writeString("end");
		}
		
    }
    
    protected boolean isFinished() {
        return done;
    }

    protected void end() {
    }

    //FAILSAFE for when pids do not disable and need to change to teleOP
    protected void interrupted() {
    	//pidleft.disable();
		//pidleft1.disable();
		//pidright.disable();
		//pidright.disable();
		//Robot.serial.writeString("end");
    }

}
