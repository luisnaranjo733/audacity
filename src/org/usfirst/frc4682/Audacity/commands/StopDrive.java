/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class StopDrive extends CommandBase {
    public boolean stopped = false;
    public StopDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        driveTrain.stopBothMotors();
        stopped = true;
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return stopped;
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Stopped the drive wheels\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
