
package org.usfirst.frc.team2169.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

public class intakeSub extends Subsystem {
    
	public CANTalon intake;
	public DigitalInput switchTest;
	
	public boolean passedOnceLimitSwitch;
	
	public intakeSub()
	{
		intake = new CANTalon(4);
		//loadSensor = new AnalogInput(0);
		switchTest = new DigitalInput(6);
	}
	
	
	public int getDensityVal(){
		//return loadSensor.getValue();
		return 0;
	}
	
	public boolean getPassedBool(){
		return passedOnceLimitSwitch;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

