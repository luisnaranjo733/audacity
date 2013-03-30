/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import com.sun.squawk.util.MathUtils;
/**
 *
 * @author luis
 */
public class TankDrive extends CommandBase {
    double leftSpeed;
    double rightSpeed;
    
    public TankDrive() {
        requires(driveTrain);
    }
    
    protected void execute() {
        leftSpeed = oi.getFirstY(); // -1 to 1
        rightSpeed = oi.getSecondY();
        leftSpeed = curve(leftSpeed);
        rightSpeed = curve(rightSpeed);
        driveTrain.tankDrive(leftSpeed, rightSpeed);
        }

    protected double curve(double StickY) {
        StickY *= reducer();
        return (StickY/Math.abs(StickY)) * MathUtils.pow(Math.abs(StickY), 1.0/3.0);
    }
    
    protected double reducer() {
        double throttle = oi.getSecondThrottle();
        double YStickDiff = Math.abs(oi.getFirstY() - oi.getSecondY());
        return (0.5 * throttle + 0.5)/*must add up to 1, added val is the new 0*/ * (1.0 - (0.2 * throttle * YStickDiff));
    }           /*   0.6*throttle +0.4   0.4 is the zero*/                          /*^  -( ^ * 2 )is max reduction val */

    protected void initialize() {}
    protected boolean isFinished() {return false;}
    protected void end() {}
    protected void interrupted() {}
}
