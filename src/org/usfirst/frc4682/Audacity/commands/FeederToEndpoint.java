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
    boolean allowed;
    
    public FeederToEndpoint() {
        requires(feeder);
    }

    protected void initialize() {
        allowed = oi.thirdStick.getRawButton(2);
        if (!allowed) {
            System.out.print("The feeder should not run");
            cancel();
        }
    }

    protected void execute() {
        double feederSpeed = -(oi.getFirstThrottle() + RobotMap.feederSpeed);
        if (feederSpeed > 1.0) {
            feederSpeed = 1.0;
        }
        if (feeder.enabled) {
            feeder.setSpeed(feederSpeed);
        }
        else {
            feeder.setSpeed(0.0);
            cancel();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //timer.
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
