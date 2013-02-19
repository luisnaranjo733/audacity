/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class Shooter extends BaseSubsystem {
    SpeedController leftTalon = new Talon(RobotMap.leftShooterPort);
    SpeedController rightTalon = new Talon(RobotMap.rightShooterPort);
    
    private double incrementer = 0.005;
    public void initDefaultCommand() {
        //setDefaultCommand(new TuneShooter());
    }
    
    public void setLeftWheel(double speed) {
        if (enabled == true) {
            leftTalon.set(speed);
        }
    }
    
    public void setRightWheel(double speed) {
        if (enabled = true) {
            rightTalon.set(speed);
        }
    }
    
    public void setBothWheels(double speed) {
        setLeftWheel(speed);
        setRightWheel(speed);
    }
    
    public void stopLeftWheel() {
        setLeftWheel(0.0);
    }
    
    public void stopRightWheel() {
        setRightWheel(0.0);
    }
    
    public void stopBothWheels() {
        stopLeftWheel();
        stopRightWheel();
    }
    
}
