package org.usfirst.frc4682.Audacity.commands;

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
    protected boolean isFinished() { // This command is run on a button press
        return stopped; // we only need to stop the wheels once per trigger.
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
