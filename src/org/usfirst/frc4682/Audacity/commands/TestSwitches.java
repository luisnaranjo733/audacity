/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class TestSwitches extends CommandBase {
    
    public TestSwitches() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Initializing testing switch command...\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        System.out.print("At end limit? " + feeder.atEndLimit() + "\n");
        System.out.print("At start limit? " + feeder.atStartLimit() + "\n");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Ended the test switches command\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.print("Interrupted the test switches command\n");
    }
}
