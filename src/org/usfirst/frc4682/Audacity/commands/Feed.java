/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4682.Audacity.commands.FeederToEndpoint;
import org.usfirst.frc4682.Audacity.commands.FeederToStartpoint;
/**
 *
 * @author luis
 */
public class Feed extends CommandGroup {
    
    public Feed() {
        addSequential(new FeederToEndpoint());
        addSequential(new FeederToStartpoint());
    }
}
