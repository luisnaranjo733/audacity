/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.DigitalInput;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class Feeder extends Subsystem {
    SpeedController feeder = new Jaguar(RobotMap.FeederPort);
    DigitalInput startLimit = new DigitalInput(1,1);
    DigitalInput endLimit = new DigitalInput(1,2);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        //setDefaultCommand(new FeederToStartpoint()); // is this necessary?
    }
    
    public boolean atEndLimit() { // Normally open limit switch
        // should become closed (true) when the switch is hit
        return !endLimit.get();
    }
    
    public boolean atStartLimit() {
        return !startLimit.get();
    }
    
    public void setSpeed(double speed) {
        feeder.set(speed);
    }
    
    
}
