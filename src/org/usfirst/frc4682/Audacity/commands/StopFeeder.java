/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class StopFeeder extends CommandBase {
    public boolean stopped = false;
    
    public StopFeeder() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        feeder.setSpeed(0.0);
        stopped = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopped;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Stopped the Feeder\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
