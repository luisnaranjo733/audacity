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
        //feeder.setSpeed(-RobotMap.feederSpeed);
        double speed = Math.abs(0.5 * oi.getThirdThrottle() + 0.5);
        feeder.setSpeed(-speed);
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
