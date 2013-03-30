/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;
import edu.wpi.first.wpilibj.Timer;
/**
 *
 * @author luis
 */
public class Autonomous extends CommandBase {
    
    private double shootingSpeed = 0.85;
    private double feederSpeed = 0.5;
    private int frisbeesShot = 0;
    public Autonomous() {
        requires(shooter);
        requires(feeder);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        frisbeesShot = 0;
        shooter.setForward(shootingSpeed);
        Timer.delay(1);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        frisbeesShot += 1;
        while (!feeder.atEndLimit()) {
            feeder.setForward(feederSpeed);
        }
        while (!feeder.atStartLimit()) {
            feeder.setBackward(feederSpeed);
        }
        feeder.setForward(feederSpeed);
        Timer.delay(0.05);
        feeder.stop();
        Timer.delay(2);
  
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return frisbeesShot >=  2;
    }

    // Called once after isFinished returns true
    protected void end() {
        feeder.stop();
        shooter.stop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
