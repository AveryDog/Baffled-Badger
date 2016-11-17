package org.usfirst.frc.team2169.robot;

import org.usfirst.frc.team2169.robot.commands.DoNothingAutoCOM;
import org.usfirst.frc.team2169.robot.commands.DriveForwardAutoCOM;
import org.usfirst.frc.team2169.robot.commands.TurnNShoot;
import org.usfirst.frc.team2169.robot.commands.climbCOM;
import org.usfirst.frc.team2169.robot.commands.driveTrainCOM;
import org.usfirst.frc.team2169.robot.commands.flyWheelCOM;
import org.usfirst.frc.team2169.robot.commands.hoodCOM;
import org.usfirst.frc.team2169.robot.commands.intakeCOM;
import org.usfirst.frc.team2169.robot.commands.leftManipSolCOM;
import org.usfirst.frc.team2169.robot.commands.rightManipSolCOM;
import org.usfirst.frc.team2169.robot.subsystems.driveTrainSub;
import org.usfirst.frc.team2169.robot.subsystems.endGameSub;
import org.usfirst.frc.team2169.robot.subsystems.flyWheelSub;
import org.usfirst.frc.team2169.robot.subsystems.intakeSub;
import org.usfirst.frc.team2169.robot.subsystems.solenoidSub;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;

public class Robot extends IterativeRobot {

	//public static final ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	public static final intakeSub intakeSubsystem = new intakeSub();
	public static final flyWheelSub flyWheelSubsystem = new flyWheelSub();
	public static final solenoidSub solenoidSubsystem = new solenoidSub();
	public static final driveTrainSub driveTrainSubsystem = new driveTrainSub();
	public static final endGameSub endGameSubsystem = new endGameSub();
	public static OI oi;
	public static int value;
	public double angle;
	public static double visionAngle;
	public static boolean switchWasPressed;
	public static boolean primaryControlled;
	public static SerialPort serial;
	public static Float robotAngle;
	public static Float visionDistance;
	public static String com;
	public SendableChooser chooserAutos;
	public Command intakeCom;
	public Command flyWheelCom;
	public Command climbCom;
	public Command leftManipSolCom;
	public Command rightManipSolCom;
	public Command driveTrainCom;
	public Command hoodCom;
	public Command turnNShoot;
	public Command autonomousCommand; 
	public Command teleOpAutoShotyCOM;
    //SendableChooser autoChooser;
	
	public static boolean flywheelRunning;
	
	public static boolean intakesGo;
	public static int standardrpmVel = 1750;

	public CameraServer server;
	
    public void robotInit() {
    	switchWasPressed = false;
		angle = 67;
    	oi = new OI();
    	
    	intakesGo = true;
    	
    	chooserAutos = new SendableChooser();
        chooserAutos.addDefault("Do Nothing", new DoNothingAutoCOM());
        chooserAutos.addObject("Drive Forward", new DriveForwardAutoCOM(2.5));
        //chooserAutos.addObject("High Goal", new HighGoalAutoCOM());
        //chooserAutos.addObject("Pid Test", new pidTestCOM());
        //chooserAutos.addObject("TurnNShoot", new TurnNShoot());
        //chooserAutos.addObject("Read Goal Vision", new ReadGoalAutoCOM());
        SmartDashboard.putData("Autos", chooserAutos);
        
		value = standardrpmVel;
        intakeCom = new intakeCOM();
        flyWheelCom = new flyWheelCOM();
        leftManipSolCom = new leftManipSolCOM();
        rightManipSolCom = new rightManipSolCOM();
        driveTrainCom = new driveTrainCOM();
        climbCom = new climbCOM();
        hoodCom = new hoodCOM();
        turnNShoot = new TurnNShoot();
        
        Robot.solenoidSubsystem.compressor.start();
        
        
        //usb camera down below
        //axis is already preprogrammed on smartdashboard and just needs ip address
        /*server = CameraServer.getInstance();
        server.setQuality(50);
        server.startAutomaticCapture("cam2");*/
        //serial = new SerialPort(9600, SerialPort.Port.kUSB);
        //serial.enableTermination();
        robotAngle = (float)0.000000;
    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {
		Scheduler.getInstance().run();
    	autonomousCommand = (Command)chooserAutos.getSelected();
    	autonomousCommand.start();
    	
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();

    }
   
    public void teleopInit() {
        if (autonomousCommand != null) autonomousCommand.cancel(); 
        
        intakeCom.start();
        flyWheelCom.start();
        driveTrainCom.start();
        //hoodCom.start();
        climbCom.start();
        primaryControlled = true;
        /*if(!server.isAutoCaptureStarted()){
        	server.setQuality(50);
        	server.startAutomaticCapture("cam2");
        }*/
        
        //Robot.solenoidSubsystem.compressor.start();
    }

    public void disabledInit(){}

    @SuppressWarnings("deprecation")
	public void teleopPeriodic() {
    	//com = serial.readString();
    	
    	//if(!com.isEmpty())
    //		System.out.println(com);
    	
        Scheduler.getInstance().run();
        SmartDashboard.putBoolean("In Range", Robot.flyWheelSubsystem.flyWheelF.isEnabled());
        SmartDashboard.putInt("flywheel setpoint", value);
        SmartDashboard.putDouble("Rpm", Robot.flyWheelSubsystem.rpm());
        SmartDashboard.putDouble("flywheel enc velocity", Robot.flyWheelSubsystem.flyWheelF.getEncVelocity());
        SmartDashboard.putDouble("hang enc position", Robot.endGameSubsystem.winch.getEncPosition());
        SmartDashboard.putDouble("accel X: ",Robot.driveTrainSubsystem.accel.getX());
        SmartDashboard.putDouble("accel Y: ",Robot.driveTrainSubsystem.accel.getY());
        SmartDashboard.putDouble("accel Z: ",Robot.driveTrainSubsystem.accel.getZ());
        SmartDashboard.putBoolean("Jumped Defense", Robot.driveTrainSubsystem.jumpedDefense());
        SmartDashboard.putBoolean("switch", Robot.intakeSubsystem.switchTest.get());
        SmartDashboard.putBoolean("Trigger Down", Robot.oi.secondaryStick.getRawButton(1));
        SmartDashboard.putBoolean("Flywheel Spinning", Robot.flywheelRunning);
    }
    
    public void testPeriodic() {
        LiveWindow.run();
    }
}
