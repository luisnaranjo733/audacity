/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
/**
 *
 * @author luis
 */

public abstract class BaseSubsystem extends Subsystem {
    public boolean enabled = true;
    
    public void enable() {
        enabled = true;
    }
    
    public void disable() {
        enabled = false;
    }

    public boolean state() {
        return enabled;
    }
}
