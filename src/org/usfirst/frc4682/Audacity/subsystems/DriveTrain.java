package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.TankDrive;
/**
 *
 * @author luis
 */
public class DriveTrain extends BaseSubsystem {
    
    SpeedController leftVictor = new Victor(RobotMap.leftDrivePort);
    SpeedController rightVictor = new Victor(RobotMap.rightDrivePort);
    RobotDrive drive = new RobotDrive(leftVictor, rightVictor);

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        if (enabled == false) {
            leftSpeed = 0;
            rightSpeed = 0;
        }
        drive.tankDrive(leftSpeed, rightSpeed);

    }
    
    public void stopLeftMotor() {
        leftVictor.set(0.0);
    }
    
    public void stopRightMotor() {
        rightVictor.set(0.0);
    }
    
    public void stopBothMotors() {
        stopLeftMotor();
        stopRightMotor();
    }
    
    public double getLeftSpeed() {
        return leftVictor.get();
    }
    
    public double getRightSpeed() {
        return rightVictor.get();
    }

}
