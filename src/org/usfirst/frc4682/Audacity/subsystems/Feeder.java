package org.usfirst.frc4682.Audacity.subsystems;
import org.usfirst.frc4682.Audacity.RobotMap;
import org.usfirst.frc4682.Audacity.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Feeder extends Subsystem {
    SpeedController motor = RobotMap.feederMotor;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}