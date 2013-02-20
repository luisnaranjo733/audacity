/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */
public class AltTankDrive extends CommandBase {
    double leftSpeed;
    double rightSpeed;
    double reductor;
    
    public AltTankDrive() {
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
        boolean shooterMoving = (oi.thirdStick.getX() < -0.2 || oi.thirdStick.getX() > 0.2);
        boolean shooterOverrides = (oi.leftStick.getY() < 0.3 && oi.rightStick.getY() < 0.3);
        shooterOverrides = shooterOverrides && (oi.leftStick.getY() > -0.3 && oi.rightStick.getY() > -0.3);

        if (shooterMoving && shooterOverrides){
            reductor = oi.thirdStick.getX() * 0.6;
            driveTrain.arcadeDrive(0, reductor);
        }
        else {
                    // Reduce speed by half when turning
            boolean turning = (leftSpeed < 0 && rightSpeed > 0) || (leftSpeed > 0 && rightSpeed < 0);
            reductor = oi.getSecondThrottle();
            System.out.print("drive throttle: " + reductor + "\n");
            if (turning == true) {
                reductor = 0.8;
            }
            System.out.print("Reductor: " + reductor);
            leftSpeed = oi.leftStick.getY() * reductor;
            rightSpeed = oi.rightStick.getX() * reductor;
            driveTrain.arcadeDrive(leftSpeed, rightSpeed);
        }
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
