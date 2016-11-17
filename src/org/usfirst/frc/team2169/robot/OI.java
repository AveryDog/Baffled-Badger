package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.commands.SwitchFlywheelGo;
import org.usfirst.frc.team2169.robot.commands.hoodCOM;
import org.usfirst.frc.team2169.robot.commands.leftManipSolCOM;
import org.usfirst.frc.team2169.robot.commands.rightManipSolCOM;
import org.usfirst.frc.team2169.robot.commands.velocityDownCOM;
import org.usfirst.frc.team2169.robot.commands.velocityUpCOM;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI {
   
	public Joystick leftStick;
	public Joystick rightStick;
	public Joystick secondaryStick;
	
	public OI()
	{
		leftStick = new Joystick(0);
		rightStick = new Joystick(1);
		secondaryStick = new Joystick(2);
		
		JoystickButton velocityUp = new JoystickButton(secondaryStick,11);
		JoystickButton velocityDown = new JoystickButton(secondaryStick,10);
		JoystickButton leftManip = new JoystickButton(secondaryStick,4);
		JoystickButton rightManip = new JoystickButton(secondaryStick,5);
		JoystickButton hoodManip = new JoystickButton(secondaryStick,9);
		JoystickButton flywheelGo = new JoystickButton(secondaryStick,6);
		//JoystickButton visionButton = new JoystickButton(secondaryStick,4);
		//JoystickButton Manip = new JoystickButton(secondaryStick,5);
		//JoystickButton lift = new JoystickButton(secondaryStick, 7);
		//JoystickButton liftUp = new JoystickButton(secondaryStick, 8);
		//JoystickButton shoot = new JoystickButton(secondaryStick, 1);
		
		velocityUp.whenPressed(new velocityUpCOM());
		velocityDown.whenPressed(new velocityDownCOM());
		leftManip.whenPressed(new leftManipSolCOM());
		rightManip.whenPressed(new rightManipSolCOM());
		hoodManip.whenPressed(new hoodCOM());
		flywheelGo.whenPressed(new SwitchFlywheelGo());
		//visionButton.whenPressed(new TeleOpHighGoalCOM());
		//lift.whenPressed(new liftCOM());
		//liftUp.whenPressed(new liftUpCOM());
	}
	
}

