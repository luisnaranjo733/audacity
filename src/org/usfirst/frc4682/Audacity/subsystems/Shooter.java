/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController leftTalon = new Talon(RobotMap.leftTalonPort);
    SpeedController rightTalon = new Talon(RobotMap.rightTalonPort);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void setLeftWheel(double speed) {
        leftTalon.set(speed);
    }
    
    public void setRightWheel(double speed) {
        rightTalon.set(speed);
    }
    
    public void setSpeed(double left, double right) {
        setLeftWheel(left);
        setRightWheel(right);
    }
    
    public void stopLeftWheel() {
        setLeftWheel(0.0);
        
    }
    
    public void stopRightWheel() {
        setLeftWheel(0.0);
    }
    
    public void stopWheels() {
        stopLeftWheel();
        stopRightWheel();
    }
    
}
