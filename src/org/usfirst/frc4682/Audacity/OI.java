package org.usfirst.frc4682.Audacity;
import edu.wpi.first.wpilibj.Joystick;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    public Joystick firstStick = new Joystick(1);
    public Joystick secondStick = new Joystick(2);
    public Joystick thirdStick = new Joystick(3);
    
    public OI() {
    }
    
    public double getFirstThrottle() { // returns 0 < double < 1
        return getThrottle(firstStick);
    }
    
    public double getSecondThrottle() {
        return getThrottle(secondStick);// * 0.6 + 0.4;
    }
    
    public double getThirdThrottle() {
        return getThrottle(thirdStick);
    }
    public double getThrottle(Joystick stick) {
        return (-(stick.getRawAxis(3) + 1)/2) + 1;
        
    }
    
    public double getFirstY() {
        return firstStick.getY();
    }
    
    public double getSecondY() {
        return secondStick.getY();
    }
    
    public double getThirdX() {
        return thirdStick.getX();
    }
    
    public double getThirdY() {
            return thirdStick.getY();
    }
    
    public boolean readyToShoot() {
        return thirdStick.getRawButton(2);
    }
    
    public boolean readyToFeed() {
        return thirdStick.getRawButton(1);
    }
}
