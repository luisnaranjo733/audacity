package org.usfirst.frc4682.Audacity.commands;

/*
 * This command only manages the control of the shooter wheel speeds.
 * It uses the throttle on the first two connected joysticks.
 * A 90 degree throttle above the horizontal is full speed.
 */

public class TestShooter extends CommandBase {
    
    public TestShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Tuning shooter..\n.");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double shooterSpeed = -oi.getThirdThrottle();
        shooter.setSpeed(shooterSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !oi.thirdStick.getRawButton(2);
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stop();
        System.out.print("Stopping both shooter wheels\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
