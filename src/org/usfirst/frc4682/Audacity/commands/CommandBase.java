package org.usfirst.frc4682.Audacity.commands;

/**
 *
 * @author luis
 */

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc4682.Audacity.OI;
import org.usfirst.frc4682.Audacity.subsystems.Chassis;
import org.usfirst.frc4682.Audacity.subsystems.Feeder;
import org.usfirst.frc4682.Audacity.subsystems.Loader;
import org.usfirst.frc4682.Audacity.subsystems.Shooter;

public abstract class CommandBase extends Command {
    // CommandBase holds a static instance of OI
    public static OI oi;
    
    // Instances of each subsystem
    public static Chassis chassis = new Chassis();
    public static Feeder feeder = new Feeder();
    public static Loader loader = new Loader();
    public static Shooter shooter = new Shooter();
    
    /**
     * Call this command to properly finish initializing the CommandBase.
     * This call is automatically included in the default template.
     */
    public static void init() {
        oi = new OI();
        
        // Optional: Logs the currently running command for each subsystem in
        //           the SmartDashboard. This can be useful for debugging.
        SmartDashboard.putData(chassis);
        SmartDashboard.putData(feeder);
        SmartDashboard.putData(loader);
        SmartDashboard.putData(shooter);
    }
    
    // Automatically created constructors.
    public CommandBase(String name) { super(name); }
    public CommandBase() { super(); }
}
