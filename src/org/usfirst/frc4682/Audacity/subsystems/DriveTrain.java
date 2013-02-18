package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.GenericHID;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.ArcadeDrive;
/**
 *
 * @author luis
 */
public class DriveTrain extends Subsystem {
    
    SpeedController leftVictor = new Victor(RobotMap.leftDrivePort);
    SpeedController rightVictor = new Victor(RobotMap.rightDrivePort);
    RobotDrive drive = new RobotDrive(leftVictor, rightVictor);
    private boolean enabled = true;
    
    public DriveTrain() {
       drive.setSafetyEnabled(false);
    }

    public void initDefaultCommand() {
        setDefaultCommand(new ArcadeDrive());
    }

    public void toggleEnabled() {
        enabled = !enabled;
        if (enabled == true) {
            System.out.print("Enabled Drive Train.\n");
        }
        else {
            System.out.print("Disabled Drive Train.\n");
        }
    }
    public void tankDrive(GenericHID leftJoy, GenericHID rightJoy){
        drive.tankDrive(leftJoy, rightJoy);
    }
    
    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);
    }
    
    public void arcadeDrive(GenericHID stick){
        drive.arcadeDrive(stick);
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

}
