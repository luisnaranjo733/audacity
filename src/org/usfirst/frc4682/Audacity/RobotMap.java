package org.usfirst.frc4682.Audacity;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import java.util.Vector;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController feederMotor;
    public static SpeedController chassisleftMotor;
    public static SpeedController chassisrightMotor;
    public static RobotDrive chassisDrive;
    public static SpeedController shooterflyWheel;
    public static SpeedController loaderloadWheel;
    public static void init() {
        feederMotor = new Victor(1, 5);
	LiveWindow.addActuator("Feeder", "Motor", (Victor) feederMotor);
        
        chassisleftMotor = new Victor(1, 1);
	LiveWindow.addActuator("Chassis", "leftMotor", (Victor) chassisleftMotor);
        
        chassisrightMotor = new Victor(1, 2);
	LiveWindow.addActuator("Chassis", "rightMotor", (Victor) chassisrightMotor);
        
        chassisDrive = new RobotDrive(chassisleftMotor, chassisrightMotor);
	
        chassisDrive.setSafetyEnabled(true);
        chassisDrive.setExpiration(0.1);
        chassisDrive.setSensitivity(0.5);
        chassisDrive.setMaxOutput(1.0);
        
        shooterflyWheel = new Victor(1, 3);
	LiveWindow.addActuator("Shooter", "flyWheel", (Victor) shooterflyWheel);
        
        loaderloadWheel = new Victor(1, 4);
	LiveWindow.addActuator("Loader", "loadWheel", (Victor) loaderloadWheel);
        
    }
}
