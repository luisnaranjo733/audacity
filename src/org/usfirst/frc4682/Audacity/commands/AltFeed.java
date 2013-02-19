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
public class AltFeed extends CommandBase {
    private double forwardSpeed;
    private boolean shooting;
    
    public AltFeed() {
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        out(4, "Feeder speed: " + feeder.getSpeed());
        out(2, "Feeder state: " + feeder.state());
        shooting = oi.thirdStick.getRawButton(2); // shooter button
        if (shooting == true) {
            while (!feeder.atEndLimit()) {
                forwardSpeed = -(oi.getFirstThrottle() + RobotMap.feederSpeed);
                feeder.setSpeed(forwardSpeed);
            }
            feeder.stop();
            while (!feeder.atStartLimit()) {
                feeder.setSpeed(-forwardSpeed);
            }
            feeder.stop();
            feeder.setSpeed(forwardSpeed);
            Timer.delay(0.05);
            feeder.stop();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return !shooting;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
