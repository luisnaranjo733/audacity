package org.usfirst.frc4682.Audacity.commands;

public class TuneShooter extends CommandBase {
    
    public TuneShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double leftThrottle = (-oi.leftStick.getRawAxis(3) + 1)/2;
        double rightThrottle = (-oi.rightStick.getRawAxis(3) + 1)/2;
        shooter.setLeftWheel(leftThrottle);
        shooter.setRightWheel(rightThrottle);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        if(oi.leftButton2.get() || oi.rightButton2.get()){ // put return false in else statement
            return true;
        }
        else {
            return false;
        }
    }

    // Called once after isFinished returns true
    protected void end() {
        shooter.stopBothWheels();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
