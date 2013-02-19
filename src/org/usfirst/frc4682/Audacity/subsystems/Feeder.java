package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class Feeder extends BaseSubsystem {
    SpeedController feeder = new Talon(RobotMap.FeederPort);
    DigitalInput startLimit = new DigitalInput(RobotMap.startLimitSwitchPort);
    DigitalInput endLimit = new DigitalInput(RobotMap.endLimitSwitchPort);

    public void initDefaultCommand() {
        //setDefaultCommand(new TestSwitches());
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
        if (enabled == true) {
            feeder.set(speed);
        }
        else {
            stop();
        }
    }
    
    public void stop() { // this is used in more than one place
        feeder.set(0.0);
    }
    
}
