/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import java.lang.Math;
/**
 *
 * @author luis
 */
public class TankDrive extends CommandBase {
    double leftSpeed;
    double rightSpeed;
    double reductor;
    
    public TankDrive() {
        requires(driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        System.out.print("Starting tank drive...\n");
        if (oi.getSecondThrottle() == 0) {
            System.out.print("WARNING: Your drive throttle reductor is set to 0.\n");
        }
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        boolean shooterMoving = (oi.getThirdX() < -0.2 || oi.getThirdX() > 0.2);
        boolean shooterOverrides = Math.abs(oi.getFirstY()) < 0.3;
        shooterOverrides = shooterOverrides && Math.abs(oi.getSecondY()) < 0.3;

        if (shooterMoving && shooterOverrides){
            driveTrain.arcadeDrive(0, oi.thirdStick.getX() * 0.6);
        }
        else {
                    // Reduce speed by half when turning
            boolean turning = (leftSpeed < 0 && rightSpeed > 0) || (leftSpeed > 0 && rightSpeed < 0);
            double diff = Math.abs(leftSpeed) - Math.abs(rightSpeed);

            reductor = oi.getSecondThrottle() * 0.6 + 0.4;
            System.out.print("Throttle: " + oi.getSecondThrottle() + "\n");
            if (turning == true) {
                reductor = 0.8;
            }
            /*
             * variable: Throttle (actual speed), Throttle0 (position on throttle thing)
             * When Throttle = 0.4, Throttle=0
             */
            leftSpeed = oi.leftStick.getY() * reductor;
            rightSpeed = oi.rightStick.getY() * reductor;
            
            leftSpeed = curve(leftSpeed);
            rightSpeed = curve(rightSpeed);
            driveTrain.tankDrive(leftSpeed, rightSpeed);
        }
    }
    
    protected double curve(double val) {
       return (val/Math.abs(val)*Math.sqrt(Math.abs(val)));
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        System.out.print("Tank Drive interrupted!\n");
    }
}
