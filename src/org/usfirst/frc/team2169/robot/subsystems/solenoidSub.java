
package org.usfirst.frc.team2169.robot.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class solenoidSub extends Subsystem {
    
	public DoubleSolenoid leftManipulator;
	public DoubleSolenoid rightManipulator;
	public DoubleSolenoid hoodManipulator;
	
	public Compressor compressor;
	
	
    public solenoidSub()
    {
    	compressor = new Compressor();
    	compressor.setClosedLoopControl(true);
    	leftManipulator = new DoubleSolenoid(0,1);
    	rightManipulator = new DoubleSolenoid(2,3);
    	hoodManipulator = new DoubleSolenoid(4,5);
    	
    }

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

