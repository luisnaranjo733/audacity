package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.GenericHID;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.TankDrive;
/**
 *
 * @author luis
 */
public class DriveTrain extends Subsystem {
    
    SpeedController leftVictor = new Victor(RobotMap.leftDrivePort);
    SpeedController rightVictor = new Victor(RobotMap.rightDrivePort);
    RobotDrive drive = new RobotDrive(leftVictor, rightVictor);

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void tankDrive(GenericHID leftJoy, GenericHID rightJoy){
        drive.tankDrive(leftJoy, rightJoy);
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
