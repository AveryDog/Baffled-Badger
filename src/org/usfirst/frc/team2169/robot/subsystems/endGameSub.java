
package org.usfirst.frc.team2169.robot.subsystems;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class endGameSub extends Subsystem {
    
	public CANTalon claw;
	public CANTalon winch;
	
	public endGameSub()
	{
		claw = new CANTalon(7);
		winch = new CANTalon(5);
		claw.setEncPosition(0);
		winch.setEncPosition(0);
	}
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

