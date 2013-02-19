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

// HIGHLY EXPERIMENTAL
public abstract class BaseSubsystem extends Subsystem {
    public boolean enabled = true;
    public String name;
    
    public void enable() {
        enabled = true;
        System.out.print("Enabled the " + name + ".\n");
    }
    
    public void disable() {
        enabled = false;
        System.out.print("Disabled the " + name + ".\n");
    }

    public boolean state() {
        return enabled;
    }
}
