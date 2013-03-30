/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4682.Audacity.commands.Shoot;
/**
 *
 * @author luis
 */

// This subsystem should work.
public class Shooter extends Subsystem {
    SpeedController wheels = new Talon(1);
    SpeedController wheelTwo = new Talon(2);

    public void initDefaultCommand() {
        setDefaultCommand(new Shoot());
    }
    
    public void setVelocity(double velocity) {
        wheels.set(velocity);
        wheelTwo.set(velocity);
    }
    
    public void setForward(double speed) {
        double velocity = -Math.abs(speed);
        setVelocity(velocity);
    }
    
    public void setBackward(double speed) {
        double velocity = Math.abs(speed);
        setVelocity(velocity);
    }
    
    public void stop() {
        setVelocity(0.0);
    }
    
    public double getSpeed() {
        return wheels.get();
    }
}
