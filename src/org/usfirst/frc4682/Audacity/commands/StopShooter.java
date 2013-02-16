package org.usfirst.frc4682.Audacity.commands;

/*
 * This sets the shooter wheel speeds to 0 once.
 */

public class StopShooter extends CommandBase {
    boolean stopped = false;
    
    public StopShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.stopBothWheels();
        stopped = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
        return stopped; // This will return true after the first loop.
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Stopped the shooter\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
