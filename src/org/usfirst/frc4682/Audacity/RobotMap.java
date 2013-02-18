package org.usfirst.frc4682.Audacity;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    
    // PWM ports
    public static final int leftShooterPort = 1;
    public static final int rightShooterPort = 2;
    public static final int FeederPort = 8;
    public static final int leftDrivePort = 9;
    public static final int rightDrivePort = 10;
    
    // Digital I/O ports
    public static final int startLimitSwitchPort = 1;
    public static final int endLimitSwitchPort = 2;
    
    // constants
    public static final double feederSpeed = 0.5;
    
    // oi
}
