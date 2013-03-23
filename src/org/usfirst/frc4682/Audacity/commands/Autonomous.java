/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import org.usfirst.frc4682.Audacity.RobotMap;

/**
 *
 * @author luis
 */
public class Autonomous extends CommandBase {
    
    private int frisbeesShot = 0;
    public Autonomous() {
        requires(shooter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        frisbeesShot += 1;
        shooter.enable();
        shooter.setSpeed(1.0);
        while (!feeder.atEndLimit()) {
            feeder.setSpeed(-RobotMap.feederSpeed);
        }
        while (!feeder.atStartLimit()) {
            feeder.setSpeed(RobotMap.feederSpeed);
        }
  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return frisbeesShot < 3;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
