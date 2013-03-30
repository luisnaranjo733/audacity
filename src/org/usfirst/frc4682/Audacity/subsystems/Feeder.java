package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4682.Audacity.commands.Feed;
/**
 *
 * @author luis
 */

// this subsystem should work
public class Feeder extends Subsystem {
    SpeedController feeder = new Talon(8);
    DigitalInput startLimit = new DigitalInput(1);
    DigitalInput endLimit = new DigitalInput(2);

    public void initDefaultCommand() {
        setDefaultCommand(new Feed());
    }
    
    public boolean atEndLimit() { // Normally open limit switch
        // return true when circuit is open
        // return false when circuit is closed
        return !endLimit.get();
    }
    
    public boolean atStartLimit() {
        return !startLimit.get();
    }
    
    public void setSpeed(double speed) {
        feeder.set(speed);
    }
    
    public void setForward(double speed) {
        double velocity = -Math.abs(speed);
        setSpeed(velocity);
    }
    
    public void setBackward(double speed) {
        double velocity = Math.abs(speed);
        setSpeed(velocity);
    }
    
    public double getSpeed() {
        return feeder.get();
    }
    
    public void stop() { // this is used in more than one place
        feeder.set(0.0);
    }
    
}
