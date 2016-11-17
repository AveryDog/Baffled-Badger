package org.usfirst.frc.team2169.robot.subsystems;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

import org.usfirst.frc.team2169.robot.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class imageStream implements Runnable{
	
	private States command;
	public double distance;
	ServerSocket serverSocket;
	public byte data;
	
	private Thread thread;
	 public imageStream(int port)  throws IOException
	   {
	      serverSocket = new ServerSocket(port);
	      serverSocket.setSoTimeout(10000);
	   }
	 	
	 
		 
		 public void run()
		 {
			System.out.println("Waiting for client on port " + serverSocket.getLocalPort() + "...");
			Socket server;
			try {
				server = serverSocket.accept();
				SmartDashboard.putString("Server connection",  "connected to " + server.getRemoteSocketAddress());
				DataInputStream in = new DataInputStream(server.getInputStream());
				byte[] b = null;
				while(true)
					{
						in.read(b);
						
					}
				} 
			catch (IOException e) {
				e.printStackTrace();
					}
			 	}
		 
	   public String getCommand(){
		   return command.toString();
	   }
	   public double getDistance(){
		   return distance;
	   }
	   
	   public enum States
	   {
	   	   turnLeft,turnRight,shoot,drive,shootAngle,shootSpeed,done;
	   }
}

