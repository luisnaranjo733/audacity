/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

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
        System.out.print("Initial throttle speed: " + oi.getSecondThrottle() + "\n");
    }
    

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {        
        double threshold = 0.3;
        boolean shooterMoving = (oi.thirdStick.getX() < -0.2 || oi.thirdStick.getX() > 0.2);
        boolean shooterOverrides = (oi.leftStick.getY() < threshold && oi.rightStick.getY() < threshold);
        shooterOverrides = shooterOverrides && (oi.leftStick.getY() > -threshold && oi.rightStick.getY() > -threshold);

        if (shooterMoving && shooterOverrides){
            reductor = oi.thirdStick.getX() * 0.6;
            driveTrain.arcadeDrive(0, reductor);
        }
        else {
                    // Reduce speed by half when turning
            boolean turning = (leftSpeed < 0 && rightSpeed > 0) || (leftSpeed > 0 && rightSpeed < 0);
            reductor = oi.getSecondThrottle();
            if (turning == true) {
                reductor *= 0.8;
            }
            leftSpeed = oi.leftStick.getY() * reductor;
            rightSpeed = oi.rightStick.getY() * reductor;
            driveTrain.tankDrive(leftSpeed, rightSpeed);
        }
        //out(1, "Drive state: " + driveTrain.state());
        //out(6, "Drive speed: " + driveTrain.getLeftSpeed());
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
