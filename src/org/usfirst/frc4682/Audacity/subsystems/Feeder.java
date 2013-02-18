package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class Feeder extends Subsystem {
    SpeedController feeder = new Talon(RobotMap.FeederPort);
    DigitalInput startLimit = new DigitalInput(RobotMap.startLimitSwitchPort);
    DigitalInput endLimit = new DigitalInput(RobotMap.endLimitSwitchPort);
    
    private boolean enabled = true;

    public void initDefaultCommand() {
        //setDefaultCommand(new TestSwitches());
    }
    
    public void toggleEnabled() {
        enabled = !enabled;
        if (enabled == true) {
            System.out.print("Enabled the feeder.\n");
        }
        else {
            System.out.print("Disabled the feeder.\n");
        }
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
    
    public void stop() {
        feeder.set(0.0);
    }
    
}
