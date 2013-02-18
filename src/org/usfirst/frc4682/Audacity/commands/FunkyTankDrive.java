/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class FunkyTankDrive extends CommandBase {
    double leftThrottle;
    double rightThrottle;
    
    public FunkyTankDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Starting funky tank drive...\n");
        System.out.print("Initial throttle speed: " + oi.getRightThrottle() + "\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        leftThrottle = 0.5 + (oi.getLeftThrottle() / 2);
        rightThrottle = 0.5 + (oi.getRightThrottle() / 2);
        driveTrain.tankDrive(leftThrottle, rightThrottle);
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
