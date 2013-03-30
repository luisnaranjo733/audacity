/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author Audacity
 */
public class Feed extends CommandBase {
    
    public Feed() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if(oi.readyToFeed()) {
            while(!feeder.atEndLimit()) {
                feeder.setForward(getSpeed());
            }
            while (!feeder.atStartLimit()) {
                feeder.setBackward(getSpeed());
            }
            feeder.setForward(getSpeed());
            Timer.delay(0.05);
            feeder.stop();
        }
            // break after a certain amount of time
    }
    
    private double getSpeed() {
        return 0.5 * oi.getThirdThrottle() + 0.5;
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
