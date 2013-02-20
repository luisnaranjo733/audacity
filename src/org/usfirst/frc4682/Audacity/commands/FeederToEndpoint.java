/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.FeederToStartpoint;
import edu.wpi.first.wpilibj.command.Command;
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
        }
        //System.out.print("lol");
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        //timer.
        return feeder.atEndLimit(); // should be false until the end limit
        // switch is hit
        
    }

    // Called once after isFinished returns true
    protected void end() {
        feeder.stop();
        FeederToStartpoint cmd = new FeederToStartpoint();
        cmd.start();
        
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
