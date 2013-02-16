/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 * @author luis
 */
public class StopAll extends CommandGroup {
    
    public StopAll() { // these commands run concurrently
        addParallel(new StopFeeder());
        addParallel(new StopShooter());
        addParallel(new StopDrive());
    }
}
