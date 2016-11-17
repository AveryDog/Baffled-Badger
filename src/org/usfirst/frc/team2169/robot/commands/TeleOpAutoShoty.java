package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TeleOpAutoShoty extends Command {
	
	private String serString;
	private String distS;
	private String angleS;
	private float distf;
	//private float anglef;
	
	private int characterPos;
	
    public TeleOpAutoShoty() {
    }
    
    public TeleOpAutoShoty(String s){
    	serString = s;
    }

    protected void initialize() {
    
    }

    protected void execute() {
    	characterPos = serString.charAt('*');
		distS = serString.substring(0, characterPos);
		angleS = serString.substring(characterPos + 1, serString.length());
		
		distf = Float.valueOf(distS);
		//anglef = Float.valueOf(angleS);
		
		Robot.value = (int)distf; //EQUATION
		
		
		Robot.flyWheelSubsystem.flyWheelF.setPID(0.15, 0.0002, 0.0035, 0.000001, 0, 360, 0);
    	Robot.flyWheelSubsystem.flyWheelR.set(9);
    	Robot.flyWheelSubsystem.flyWheelF.set(Robot.value * 6.8);
    	if(Robot.flyWheelSubsystem.inRange())
    	{
    			Robot.intakeSubsystem.intake.set(-1);
    			Robot.switchWasPressed = true;
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
