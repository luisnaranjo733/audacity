/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedController;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.ConstantShooter;
/**
 *
 * @author luis
 */
public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    SpeedController leftTalon = new Talon(RobotMap.leftShooterPort);
    SpeedController rightTalon = new Talon(RobotMap.rightShooterPort);
    private boolean enabled = true;

    private double incrementer = 0.005;
    public void initDefaultCommand() {
        // setDefaultCommand(new ConstantShooter());
    }
    
    public void toggleEnabled () {
        enabled = !enabled;
        if (enabled == true) {
            System.out.print("Enabled the shooter.\n");
        }
        else {
            System.out.print("Disabled the shooter.\n");
        }
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
    
    public void rampUpBothWheels() {
        double counter = 0.1;
        while (counter < RobotMap.feederSpeed) {
            counter += incrementer;
            setBothWheels(-counter);
        }
    }
    
}
