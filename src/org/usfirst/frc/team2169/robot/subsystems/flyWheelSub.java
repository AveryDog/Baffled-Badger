
package org.usfirst.frc.team2169.robot.subsystems;

import org.usfirst.frc.team2169.robot.Robot;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.command.Subsystem;

public class flyWheelSub extends Subsystem {
    
	public CANTalon flyWheelF;
	public CANTalon flyWheelR;
	
	public Encoder hoodEncoder;
	public Servo hoodServo;
	
	public flyWheelSub()
	{
		flyWheelF = new CANTalon(9);
		flyWheelR = new CANTalon(8);
		flyWheelF.reverseOutput(false);
		flyWheelR.reverseOutput(true);
		flyWheelF.changeControlMode(TalonControlMode.Speed);
		flyWheelR.changeControlMode(TalonControlMode.Follower);
	
		hoodEncoder = new Encoder(7,8);
		hoodServo = new Servo(6);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public double rpm()
    {
    	return (flyWheelF.getEncVelocity()*0.14686936356609121360474104612213);
    	//return 1.0;
    }
    
    public boolean inRange()
    {
    	//return (this.rpm() >= Robot.value + 10 || this.rpm() >= Robot.value - 10);
    	//return (Math.abs((this.rpm()) >= Robot.value - 10 && Math.abs((this.rpm()) <= Robot.value + 10);
    	boolean x = Math.abs(this.rpm()) > Robot.value - 10 && Math.abs(this.rpm()) < Robot.value + 10;
    	return x;
    }
    
    public void resetEncoders()
    {
    	hoodEncoder.reset();
    }
    
    public double returnAngle()
    {
    	return(hoodEncoder.get()/89.259259259259259259259259259259);
    }
    
}

