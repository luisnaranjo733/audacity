/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class TankDrive extends CommandBase {
    double leftThrottle;
    double rightThrottle;
    
    public TankDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Starting tank drive...\n");
        System.out.print("Initial throttle speed: " + oi.getSecondThrottle() + "\n");
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        // Reduce speed by half when turning
        double leftSpeed = oi.leftStick.getY() * oi.getSecondThrottle(); // 
        double rightSpeed = oi.rightStick.getY() * oi.getSecondThrottle();
        driveTrain.tankDrive(leftSpeed, rightSpeed);
        out(1, "Drive Train state: " + driveTrain.state());
        out(6, "Drive Train speed: " + driveTrain.getLeftSpeed());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.print("Tank Drive interrupted!\n");
    }
}
