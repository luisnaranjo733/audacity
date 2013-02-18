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
public class FeederToEndpoint extends CommandBase {
    private boolean notifyExecute;
    
    
    public FeederToEndpoint() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Initializing Feeder to End point command\n");
        // feeder.atEndLimit() should always be false at first
        System.out.print("Feeder at end limit? " + feeder.atEndLimit() + "\n");
        notifyExecute = true;
        // shooter.setBothWheels(-1.0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (notifyExecute == true) {
            System.out.print("Beginning to drive forward\n");
            notifyExecute = false;
        }
        // feeder.setSpeed(-RobotMap.feederSpeed);
        double feederSpeed = -(oi.getFirstThrottle() + RobotMap.feederSpeed);
        // todo: lop 1.4 off to 1.0 here
        
        if (oi.thirdStick.getRawButton(2) == true) {
            feeder.setSpeed(feederSpeed);
        }
        else {
            feeder.setSpeed(0.0);
            System.out.print("I wont shoot till you turn the wheels on!\n");
        }
        //System.out.print("First throttle: " + oi.getFirstThrottle() + "\n");
        //System.out.print("Feeder speed: " + feederSpeed + "\n");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return feeder.atEndLimit(); // should be false until the end limit
        // switch is hit
        
    }

    // Called once after isFinished returns true
    protected void end() {
        System.out.print("Feeder to endpoint command is finished.\n");
        feeder.stop();
        System.out.print("Turned off feeder wheel\n");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.print("Feeder To endpoint command has been interrupted\n");
    }
}
