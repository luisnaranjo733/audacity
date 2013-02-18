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
    private boolean stopped;
    
    public StopFeeder() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        stopped = false;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        feeder.toggleEnabled();
        feeder.stop();
        stopped = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopped; // only runss once
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
