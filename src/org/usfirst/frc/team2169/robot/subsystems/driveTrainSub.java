
package org.usfirst.frc.team2169.robot.subsystems;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.BuiltInAccelerometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Accelerometer;

public class driveTrainSub extends Subsystem {
    
	public CANTalon leftDriveF;
	public CANTalon leftDriveR;
	public CANTalon rightDriveF;
	public CANTalon rightDriveR;
	public CANTalon lift;
	
	public Encoder leftEncoder;
	public Encoder rightEncoder;
	
	public Accelerometer interalAccel;
	public AnalogGyro gyro;
	
	public BuiltInAccelerometer accel;
	
	
    public driveTrainSub(){
    	
    	leftDriveF = new CANTalon(0);
    	leftDriveR = new CANTalon(1);
    	rightDriveF = new CANTalon(2);
    	rightDriveR = new CANTalon(3);
    	lift = new CANTalon(6);
    	leftEncoder = new Encoder(0,1);
    	rightEncoder = new Encoder(2,3);
    	//interalAccel = new BuiltInAccelerometer();
    	gyro = new AnalogGyro(0);
    	gyro.setSensitivity(0.007);
    	gyro.calibrate();
    	
    	accel = new BuiltInAccelerometer();
    	
    	
    }

    public void initDefaultCommand() {
    }
    
    public void leftDriveSide(double power)
    {
    	leftDriveF.set(-power);
    	leftDriveR.set(-power);
    }
    public void rightDriveSide(double power)
    {
    	rightDriveF.set(power);
    	rightDriveR.set(power);
    }
    
    public boolean jumpedDefense(){
    	if(accel.getX() > 1.8 && accel.getY() > .3 && accel.getZ() > 0){
    		return true;
    	} else {
    		return false;
    	}
    }
}

