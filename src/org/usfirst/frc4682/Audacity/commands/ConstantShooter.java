/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class ConstantShooter extends CommandBase {
    private double counter = 0.1;
    private double maxSpeed = 1.0;
    private double incrementer = 0.05;
    
    public ConstantShooter() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (counter < maxSpeed) {
            counter += incrementer;
        }
        shooter.setBothWheels(counter);
        // this increments the speed so it's not so sudden on the motors
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false; // run until interrupted
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
