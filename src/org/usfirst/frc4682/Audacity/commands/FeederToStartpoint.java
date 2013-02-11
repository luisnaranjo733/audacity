/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class FeederToStartpoint extends CommandBase {
    
    public FeederToStartpoint() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        /* if the initDefault command on the Feeder subsystem calls this command
         * and makes it go backwards, in this method test to see if the switch
         * is already being hit, and if so don't set the speed. Do the same
         * for the other Command, FeederToEndpoint.java
         */
        feeder.setSpeed(-0.3);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return feeder.atStartLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
        feeder.setSpeed(0.0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
