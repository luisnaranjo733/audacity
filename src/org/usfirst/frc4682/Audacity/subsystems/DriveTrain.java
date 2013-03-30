package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import org.usfirst.frc4682.Audacity.commands.TankDrive;
/**
 *
 * @author luis
 */
public class DriveTrain extends Subsystem {
    
    SpeedController leftVictor = new Victor(9);
    SpeedController rightVictor = new Victor(10);
    public RobotDrive drive = new RobotDrive(leftVictor, rightVictor);

    public void initDefaultCommand() {
        setDefaultCommand(new TankDrive());
    }

    public void tankDrive(double leftSpeed, double rightSpeed) {
        drive.tankDrive(leftSpeed, rightSpeed);

    }

}
