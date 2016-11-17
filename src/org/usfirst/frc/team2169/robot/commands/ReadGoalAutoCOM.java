package org.usfirst.frc.team2169.robot.commands;

import org.usfirst.frc.team2169.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public
 class ReadGoalAutoCOM extends Command {

	private String com;
	//private String distanceS;
	private int characterPos;
	//private boolean info;
	
	//private double angle;
	
    public ReadGoalAutoCOM() {
    }

    protected void initialize() {
    	//angle = 0;
    	//angleS = "";
		//distanceS = "";
		//info = false;
		Robot.serial.writeString("begin");
    }

    protected void execute() {
    	
		com = Robot.serial.readString();
		characterPos = com.indexOf("*");
		
		if(com.isEmpty() == false)
		{
			System.out.println("com: " + com);
			//angleS = com.substring(0, characterPos);
			//distanceS = com.substring(characterPos + 1, com.length());
			//angle = Float.valueOf(angleS).doubleValue();
			//info = true;
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
