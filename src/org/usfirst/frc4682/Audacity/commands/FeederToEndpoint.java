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
    
    public FeederToEndpoint() {
        requires(feeder);
    }

    protected void initialize() {
    }

    protected void execute() {
        // feeder.setSpeed(-RobotMap.feederSpeed);
        double feederSpeed = -(oi.getFirstThrottle() + RobotMap.feederSpeed);
        // todo: lop 1.4 off to 1.0 here
        out(4, "Feeder speed: " + feeder.getSpeed());
        out(2, "Feeder state: " + feeder.state());
        if (oi.thirdStick.getRawButton(2) == true) {
            feeder.setSpeed(feederSpeed);
        }
        else {
            feeder.setSpeed(0.0);
            //System.out.print("I wont shoot till you turn the wheels on!\n");
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
