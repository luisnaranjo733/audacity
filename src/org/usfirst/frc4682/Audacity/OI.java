package org.usfirst.frc4682.Audacity;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import org.usfirst.frc4682.Audacity.commands.*;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick leftStick = new Joystick(1);
    public Joystick rightStick = new Joystick(2);

    Button leftButton2 = new JoystickButton(leftStick, 2);
    Button rightButton2 = new JoystickButton(rightStick, 2);

    Button leftButton3 = new JoystickButton(leftStick, 3);
    Button rightButton3 = new JoystickButton(rightStick, 3);
    
    Button leftButton1 = new JoystickButton(leftStick, 1);
    Button rightButton1 = new JoystickButton(rightStick, 1);
    public OI() {
        leftButton2.whenPressed(new StopAll()); // maybe share an instance
        rightButton2.whenPressed(new StopAll());
        
        leftButton3.whenPressed(new TuneShooter()); // maybe share an instance
        rightButton3.whenPressed(new TuneShooter());
        
        leftButton1.whenPressed(new Feed());
        rightButton1.whenPressed(new Feed());
        SmartDashboard.putData("StopShooter", new StopShooter());
        SmartDashboard.putData("TuneShooter", new TuneShooter());
        SmartDashboard.putData("Feed", new Feed());
    }
    
    public double getLeftThrottle() { // returns 0 < double < 1
        return -(leftStick.getRawAxis(3) + 1)/2;
    }
    
    public double getRightThrottle() {
        return -(rightStick.getRawAxis(3) + 1)/2;
    }
}

