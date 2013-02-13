/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class TestLimitSwitch extends CommandBase {
    
    public TestLimitSwitch() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Initializing test limit switch command\n");
        /*
        if(feeder.atEndLimit()) {
            System.out.print("Feeder is at the end limit\n");
        }
        else {
            System.out.print("Feeder is not at the end limit\n");
        }
   
        if(feeder.atStartLimit()) {
            System.out.print("Feeder is at the start limit\n");
        }
        else {
            System.out.print("Feeder is not at the start limit\n");
        }
        */
        System.out.print("Start limit: " + feeder.atStartLimit() + "\n");
        System.out.print("End limit: " + feeder.atEndLimit() + "\n");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (!feeder.atEndLimit()) {
            feeder.setSpeed(0.3);
        }
        else {
            if (!feeder.atStartLimit()) {
                feeder.setSpeed(-0.3);
            }
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !feeder.atEndLimit();
        //return false;
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
