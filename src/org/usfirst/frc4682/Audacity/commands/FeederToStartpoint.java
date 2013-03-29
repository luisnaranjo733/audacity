/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;
import org.usfirst.frc4682.Audacity.RobotMap;
import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author luis
 */
public class FeederToStartpoint extends CommandBase {
    
    public FeederToStartpoint() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        double speed = Math.abs(0.5 * oi.getThirdThrottle() + 0.5);
        feeder.setSpeed(speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return feeder.atStartLimit();
    }

    // Called once after isFinished returns true
    protected void end() {
        feeder.stop();
        feeder.setSpeed(-RobotMap.feederSpeed); // bounce back a bit
        Timer.delay(0.05);
        feeder.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
