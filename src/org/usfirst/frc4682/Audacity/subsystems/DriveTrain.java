package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.GenericHID;
import org.usfirst.frc4682.Audacity.RobotMap;
/**
 *
 * @author luis
 */
public class DriveTrain extends Subsystem {
    
    SpeedController leftVictor = new Victor(RobotMap.leftVictorPort);
    SpeedController rightVictor = new Victor(RobotMap.rightVictorPort);
    RobotDrive drive = new RobotDrive(leftVictor, rightVictor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    public void tankDrive(GenericHID leftJoy, GenericHID rightJoy){
        drive.tankDrive(leftJoy, rightJoy);
    }
    
    public void arcadeDrive(GenericHID stick){
        drive.arcadeDrive(stick);
    }

}
