package org.usfirst.frc4682.Audacity.commands;

/*
 * This sets the shooter wheel speeds to 0 once.
 */

// this should work
// if it doesn't, set this command to never end
// replace RestartShooter with TuneShooter or something in Restart() group
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
        shooter.disable();
        shooter.stopBothWheels();
        stopped = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() { 
        return stopped; // This will return true after the first loop.
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
