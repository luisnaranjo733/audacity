/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usfirst.frc4682.Audacity.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import org.usfirst.frc4682.Audacity.commands.*;

/**
 *
 * @author Audacity
 */
public class Restart extends CommandGroup{
    public Restart() {
        addParallel(new RestartDrive());
    }
}
