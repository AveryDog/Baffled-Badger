package org.usfirst.frc.team2169.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

public class HighGoalAutoCOM extends CommandGroup {
	
    public  HighGoalAutoCOM(){
    	
    	addSequential(new DriveForwardAutoCOM());
    	
    	Timer.delay(40);
    	
    	addSequential(new TurnNShoot());
    	
        //addParallel(new Command1());
        //ddSequential(new Command2());
    }
}
