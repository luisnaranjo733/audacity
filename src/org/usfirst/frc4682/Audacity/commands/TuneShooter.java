package org.usfirst.frc4682.Audacity.commands;

/*
 * This command only manages the control of the shooter wheel speeds.
 * It uses the throttle on the first two connected joysticks.
 * A 90 degree throttle above the horizontal is full speed.
 */

public class TuneShooter extends CommandBase {
    
    public TuneShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Tuning shooter...");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        shooter.setLeftWheel(oi.getLeftThrottle());
        shooter.setRightWheel(oi.getRightThrottle());
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
    }
}
