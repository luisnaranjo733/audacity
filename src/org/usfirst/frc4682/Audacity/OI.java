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
    public Joystick thirdStick = new Joystick(3);

    Button shootingButton = new JoystickButton(thirdStick, 2);
    
    Button firingButton = new JoystickButton(thirdStick, 1);
    public OI() {
        shootingButton.whenPressed(new TuneShooter());
        
        firingButton.whenPressed(new Feed());
  //      SmartDashboard.putData("StopShooter", new StopShooter());
    //    SmartDashboard.putData("TuneShooter", new TuneShooter());
      //  SmartDashboard.putData("Feed", new Feed());
    }
    
    public double getFirstThrottle() { // returns 0 < double < 1
        return getThrottle(leftStick);
    }
    
    public double getSecondThrottle() {
        return getThrottle(rightStick);
    }
    
    public double getThirdThrottle() {
        return getThrottle(thirdStick);
    }
    public double getThrottle(Joystick stick) {
        return -(stick.getRawAxis(3) + 1)/2;
        
    }

}
